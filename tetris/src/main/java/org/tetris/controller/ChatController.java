package org.tetris.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.tetris.domain.user.DepartmentVO;
import org.tetris.domain.user.UserVO;
import org.tetris.domain.chat.ChatContentsVO;
import org.tetris.domain.chat.ChatParticipantVO;
import org.tetris.domain.chat.ChatRoomVO;
import org.tetris.security.domain.CustomUser;
import org.tetris.service.ChatService;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import net.coobird.thumbnailator.Thumbnailator;

@Controller
@RequestMapping("/messanger/*")
@Log4j
@AllArgsConstructor
public class ChatController {
	
	@Autowired
	private ChatService chatService;
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
	@GetMapping({"/main", "/main/emplist"})
	public String main(Model model) {
		List<UserVO> listEmp = chatService.getListEmp();
		List<DepartmentVO> listDept = chatService.getListDept();
		model.addAttribute("listEmp", listEmp);
		model.addAttribute("listDept", listDept);
		return "/messanger/main/emplist";
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
	@GetMapping("/main/chatroomlist")
	public void chatRoomList(Model model, Principal principal) {
		String e_id = principal.getName();
		model.addAttribute("listChatRoom", chatService.getListCRoom(e_id));
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
	@PostMapping("/register")
	public String registerCR(HttpServletRequest request, Principal principal, Model model) {
		List<UserVO> newChatPart = new ArrayList<>();
		UserVO loginUserVO = chatService.getEmp(principal.getName());
		newChatPart.add(loginUserVO);
		
		String e_id = request.getParameter("e_id");
		UserVO empVO = chatService.getEmp(e_id);
		newChatPart.add(empVO);
		
//		if(loginUserVO.getE_name().compareTo(empVO.getE_name()) < 0) {
//			newChatPart.add(loginUserVO);
//			newChatPart.add(empVO);
//		}else {
//			newChatPart.add(empVO);
//			newChatPart.add(loginUserVO);
//		}

		String cr_title = "";
		for(int i=0;i<newChatPart.size();i++) {
			cr_title += newChatPart.get(i).getE_name();
			
			if(i != newChatPart.size()-1) {
				cr_title += ", ";
			}else {
				break;
			}
		}
		
		List<ChatRoomVO> listCRoom = chatService.getListCRoom(principal.getName());
		
		int idx = -1;
		for(int i=0;i<listCRoom.size();i++) {
			List<ChatParticipantVO> listCPart = chatService.getListCPart(listCRoom.get(i).getCr_id());
			
			List<UserVO> chatPart = new ArrayList<UserVO>();
			for(int j=0;j<listCPart.size();j++) {
				chatPart.add(chatService.getEmp(listCPart.get(j).getE_id()));
				}
			if(newChatPart.containsAll(chatPart) && chatPart.containsAll(newChatPart)) {
				idx = i;
				break;
			}
		}
		
		String cr_id = "";
		
		if(idx == -1) {
			cr_id = UUID.randomUUID().toString();
			ChatRoomVO chatRoomVO = new ChatRoomVO();
			chatRoomVO.setCr_id(cr_id);
			chatRoomVO.setCr_title(cr_title);
			chatService.registerCRoom(chatRoomVO);
			
			ChatParticipantVO chatPartVO = new ChatParticipantVO();
			for(int i=0;i<newChatPart.size();i++) {
				chatPartVO.setCr_id(cr_id);
				chatPartVO.setE_id(newChatPart.get(i).getE_id());
				chatService.registerCPart(chatPartVO);
			}
		}else {
			cr_id = listCRoom.get(idx).getCr_id();
		}
		
		model.addAttribute("cr_id", cr_id);

		return "/messanger/chatting";
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
	@PostMapping("/chatting")
	public void chatting(HttpServletRequest request, Model model) {
		String cr_id = request.getParameter("cr_id");
		model.addAttribute("cr_id", cr_id);
		
//		List<ChatContentsVO> listChatContents = chatService.getListCC(cr_id);
//		session.setAttribute("listChatContents", listChatContents);
	}
	
//	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
//	@GetMapping("/chatting")
//	public void chatting(HttpSession session) {
//		String cr_id = request.getParameter("cr_id");
//		System.out.println(cr_id);
//		model.addAttribute("cr_id", cr_id);
//		String cr_id = (String)session.getAttribute("cr_id");
//		List<ChatContentsVO> listChatContents = chatService.getListCC(cr_id);
//	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
	@PostMapping(value = "/registerMsg", produces = "application/text; charset=UTF-8")
	@ResponseBody
	public String registerMsg(@RequestBody ChatContentsVO chatContentsVO) {
		chatService.registerMsg(chatContentsVO);
		Gson gson = new Gson();
		String chatContentsJson = gson.toJson(chatContentsVO);
		return chatContentsJson;
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
	@PostMapping(value = "/getListMsg", produces = "application/text; charset=UTF-8")
	@ResponseBody
	public String getListMsg(@RequestBody Map<String, Object> map) {
		String cr_id = (String)map.get("cr_id");
		Gson gson = new Gson();
		String listChatContentsJson = gson.toJson(chatService.getListCC(cr_id));
		return listChatContentsJson;
	}
	
	
	
	
	
	
	
	
	

//	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
//	@PostMapping("/uploadAjaxAction")
//	@ResponseBody
//	public ResponseEntity<List<ChatContentsVO>> uploadAjaxPost(MultipartFile[] uploadFile, MultipartHttpServletRequest multi, Principal principal) {
//		String cr_id = multi.getParameter("cr_id");
//		String e_id = principal.getName();
//		List<ChatContentsVO> list = new ArrayList<ChatContentsVO>();
//		String uploadFolder = "C:\\upload";
//
//		// 폴더 생성
//		File uploadPath = new File(uploadFolder, cr_id);
//		if (uploadPath.exists() == false) {
//			uploadPath.mkdirs();
//		}
//
//		for (MultipartFile multipartFile : uploadFile) {
//
//			ChatContentsVO chatContentsVO = new ChatContentsVO();
//			
//			chatContentsVO.setCr_id(cr_id);
//			chatContentsVO.setE_id(e_id);
//			chatContentsVO.setCc_size(multipartFile.getSize());
//			String uploadFileName = multipartFile.getOriginalFilename();
//
//			// IE의 경우에는 전체 파일 경로가 전송되므로, 마지막에 \\를 기준으로 잘라낸 문자열이 실제 파일 이름
//			uploadFileName = uploadFileName.substring(uploadFileName.lastIndexOf("\\") + 1);
//
//			// 원본 파일의 이름
//			chatContentsVO.setCc_contents(uploadFileName);
//
//			// 중복 방지를 위한 UUID 적용
//			UUID uuid = UUID.randomUUID();
//			String uploadUuidFileName = uuid.toString() + "_" + uploadFileName;
//
//			try {
//
//				File saveFile = new File(uploadPath, uploadUuidFileName);
//				multipartFile.transferTo(saveFile);
//
//				// UUID 값
//				chatContentsVO.setCc_uuid(uuid.toString());
//				// 업로드 경로
//				chatContentsVO.setCc_path(uploadPath.toString());
//
//				// 이미지 파일 체크
//				if (checkImageType(saveFile)) {
//
//					// 이미지 여부
//					chatContentsVO.setCc_image("true");
//
//					FileOutputStream thumbnail = new FileOutputStream(new File(uploadPath, "s_" + uploadUuidFileName));
//
//					// Thumbnailator는 InputStream과 java.io.File 객체를 이용해서 파일을 생성할 수 있고, 뒤에 사이즈에 대한 부분을 파라미터로 witdh와 height를 지정할 수 있음
//					Thumbnailator.createThumbnail(multipartFile.getInputStream(), thumbnail, 200, 200);
//
//					thumbnail.close();
//				}else chatContentsVO.setCc_image("false");
//
//				list.add(chatContentsVO);
//
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			chatService.registerCFile(chatContentsVO);
//		}
//
//		return new ResponseEntity<>(list, HttpStatus.OK);
//	}
//	
//	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
//	@GetMapping("/display")
//	@ResponseBody
//	public ResponseEntity<byte[]> getFile(String fileName) {
//
//		log.info("fileName: " + fileName);
//
//		File file = new File(fileName);
//
//		log.info("file: " + file);
//
//		ResponseEntity<byte[]> result = null;
//
//		try {
//
//			HttpHeaders header = new HttpHeaders();
//
//			header.add("Content-Type", Files.probeContentType(file.toPath()));
//			result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file), header, HttpStatus.OK);
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
//		return result;
//	}
//	
//	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
//	@GetMapping("/download")
//	@ResponseBody
//	public ResponseEntity<Resource> downloadFile(@RequestHeader("User-Agent") String userAgent, String fileName){
//		Resource resource = new FileSystemResource(fileName);
//		
//		if(resource.exists() == false) {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//		
//		String resourceName = resource.getFilename();
//		String resourceOriginalName = resourceName.substring(resourceName.indexOf("_") + 1);
//		HttpHeaders headers = new HttpHeaders();
//		try {
//			String downloadName = null;
//			if(userAgent.contains("Trident")) {
//				downloadName = URLEncoder.encode(resourceOriginalName, "UTF-8").replaceAll("\\+", " ");
//			}else if(userAgent.contains("Edge")) {
//				downloadName = URLEncoder.encode(resourceOriginalName, "UTF-8");
//			}else {
//				downloadName = new String(resourceOriginalName.getBytes("UTF-8"), "ISO-8859-1");
//			}
//			
//			headers.add("Content-Disposition", "attachment; filename =" + downloadName);
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
//		
//		return new ResponseEntity<Resource>(resource, headers, HttpStatus.OK);
//	}
//
//
////이미지 파일 여부 체크
//	private boolean checkImageType(File file) {
//		
//		try {
//			String contentType = Files.probeContentType(file.toPath());
//			
//			return contentType.startsWith("image");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		return false;
//	}

}