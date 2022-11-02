package org.tetris.controller;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.tetris.domain.DepartmentVO;
import org.tetris.domain.EmployeeVO;
import org.tetris.domain.chat.ChatFileVO;
import org.tetris.domain.chat.ChatMsgVO;
import org.tetris.domain.chat.ChatParticipantVO;
import org.tetris.domain.chat.ChatRoomVO;
import org.tetris.security.domain.CustomUser;
import org.tetris.service.ChatService;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/messanger/**")
@Log4j
@AllArgsConstructor
public class ChatController {
	
	@Autowired
	private ChatService chatService;
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
	@GetMapping({"/main", "/main/emplist"})
	public String main(Model model) {
		List<EmployeeVO> listEmp = chatService.getListEmp();
		List<DepartmentVO> listDept = chatService.getListDept();
		model.addAttribute("listEmp", listEmp);
		model.addAttribute("listDept", listDept);
		return "/messanger/main/emplist";
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
	@GetMapping("/main/chatroomlist")
	public void chatRoomList(HttpSession session, Model model, Principal principal) {
//		CustomUser loginUser = (CustomUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		String e_id = loginUser.getUsername();
		String e_id = principal.getName();
		model.addAttribute("listChatRoom", chatService.getListCRoom(e_id));
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
	@PostMapping("/register")
	@ResponseBody
	public void registerCR(@RequestBody Map<String, Object> map, HttpSession session, Model model, RedirectAttributes rttr, Principal principal) {
		List<EmployeeVO> chatPart = new ArrayList<>();
//		CustomUser loginUser = (CustomUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		EmployeeVO loginUserVO = chatService.getEmp(principal.getName()/* loginUser.getUser().getUserId() */);
		chatPart.add(loginUserVO);
		
		String e_id = (String)map.get("e_id");
		EmployeeVO empVO = chatService.getEmp(e_id);
		chatPart.add(empVO);
		
		String cr_title = "";
		for(int i=0;i<chatPart.size();i++) {
			cr_title += chatPart.get(i).getE_name();
			cr_title += ", ";
		}
		
		String cr_id = UUID.randomUUID().toString();
		ChatRoomVO chatRoomVO = new ChatRoomVO();
		chatRoomVO.setCr_id(cr_id);
		chatRoomVO.setCr_title(cr_title);
		chatService.registerCRoom(chatRoomVO);
		
		ChatParticipantVO chatPartVO = new ChatParticipantVO();
		for(int i=0;i<chatPart.size();i++) {
			chatPartVO.setCr_id(cr_id);
			chatPartVO.setE_id(chatPart.get(i).getE_id());
			chatService.registerCPart(chatPartVO);
		}
//		model.addAttribute("cr_id", cr_id);
//		return cr_id;
		session.setAttribute("cr_id", cr_id);
//		rttr.addFlashAttribute("cr_id", cr_id);
//		return "/messanger/chatting";
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
	@PostMapping("/chatting")
	@ResponseBody
	public void chatting(@RequestBody Map<String, Object> map, /*@ModelAttribute("cr_id") String cr_id, */HttpSession session, Model model, RedirectAttributes rttr, HttpServletResponse response) throws IOException {
		String cr_id = (String)map.get("cr_id");
		session.setAttribute("cr_id", cr_id);
		List<ChatMsgVO> listChatMsg = chatService.getListMsg(cr_id);
//		response.setContentType("application/json; charset=utf-8");
//		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
//        gson.toJson(listChatMsg, response.getWriter());
//		model.addAttribute("listChatMsg",listChatMsg);
//		rttr.addAttribute("listChatMsg", listChatMsg);
		session.setAttribute("listChatMsg", listChatMsg);
//		return "redirect:/messanger/chatting/{roomId}";
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
	@GetMapping("/chatting")
	public void chatting(/* @ModelAttribute("cr_id") String cr_id */) {
//		List<ChatMsgVO> listChatMsg = chatService.getListMsg(cr_id);
//		model.addAttribute("listChatMsg",listChatMsg);
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
	@PostMapping("/registerMsg")
	@ResponseBody
	public void registerMsg(@RequestBody ChatMsgVO chatMsgVO) {
//		String cr_id = (String)map.get("cr_id");
//		String e_id = (String)map.get("e_id");
//		String cm_contents = (String)map.get("cm_contents");
//		ChatMsgVO chatMsgVO = new ChatMsgVO();
//		chatMsgVO.setCr_id(cr_id);
//		chatMsgVO.setE_id(e_id);
//		chatMsgVO.setCm_contents(cm_contents);
		chatService.registerMsg(chatMsgVO);
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
	@PostMapping(value = "/uploadAjaxAction", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<List<ChatFileVO>> uploadAjaxPost(
			MultipartFile[] uploadFile, @RequestBody Map<String, Object> map) {

//		MultipartFile[] uploadFile = (MultipartFile[])map.get("formData");
		String cr_id = (String)map.get("cr_id");
		List<ChatFileVO> listChatFileVO = new ArrayList<ChatFileVO>();
		String uploadFolder = "C:\\upload";

//		String cr_id = request.getParameter("cr_id");
		String uploadFolderPath = cr_id;

		// 년/월/일 폴더의 생성
		File uploadPath = new File(uploadFolder, uploadFolderPath);
		if (uploadPath.exists() == false) {
			uploadPath.mkdirs();
		}

		for (MultipartFile multipartFile : uploadFile) {

			ChatFileVO chatFileVO = new ChatFileVO();

			String uploadFileName = multipartFile.getOriginalFilename();

			// IE의 경우에는 전체 파일 경로가 전송되므로, 마지막에 \\를 기준으로 잘라낸 문자열이 실제 파일 이름
			uploadFileName = uploadFileName.substring(uploadFileName.lastIndexOf("\\") + 1);

			// 원본 파일의 이름
			chatFileVO.setCf_name(uploadFileName);

			// 중복 방지를 위한 UUID 적용
//			UUID uuid = UUID.randomUUID();
//			uploadFileName = uuid.toString() + "_" + uploadFileName;

			try {
				File saveFile = new File(uploadPath, uploadFileName);
				multipartFile.transferTo(saveFile);

				// UUID 값
//				chatFileVO.setUuid(uuid.toString());
				// 업로드 경로
				chatFileVO.setCf_path(uploadFolder);

				// 이미지 파일 체크
//				if (checkImageType(saveFile)) {
//
//					// 이미지 여부
//					attachDTO.setImage(true);
//
//					FileOutputStream thumbnail = new FileOutputStream(new File(uploadPath, "s_" + uploadFileName));
//
//					// Thumbnailator는 InputStream과 java.io.File 객체를 이용해서 파일을 생성할 수 있고, 뒤에 사이즈에 대한 부분을 파라미터로 witdh와 height를 지정할 수 있음
//					Thumbnailator.createThumbnail(multipartFile.getInputStream(), thumbnail, 100, 100);
//
//					thumbnail.close();
//				}

				listChatFileVO.add(chatFileVO);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return new ResponseEntity<>(listChatFileVO, HttpStatus.OK);
	}

}
