package org.tetris.controller;

import java.io.File;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.tetris.domain.project.BoardAttachVO;
import org.tetris.domain.project.BoardReplyVO;
import org.tetris.domain.project.ProjectBoardVO;
import org.tetris.domain.project.ProjectCalVO;
import org.tetris.mapper.ProjectMapper;
import org.tetris.service.ProjectBoardService;
import org.tetris.service.ProjectCalService;
import org.tetris.service.ProjectService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/projectdetail/*")
@Log4j
@AllArgsConstructor
public class ProjectBoardController {
	
	@Autowired
	private ProjectBoardService service;
	
	@Autowired
	private ProjectCalService calService;
	
	private static Long projectNum;
	
	@GetMapping("/home/{pj_num}")
	public String getHome(@PathVariable("pj_num") Long pj_num, Model model) {
		projectNum = pj_num;
		Long pb_num = 0L;
		List<String> namelist =	service.getProjectInfo(pj_num);
		List<ProjectBoardVO> projectboardlist = service.listProjectBoard(pj_num);
		List<BoardReplyVO> replies = service.listBoardReply(pb_num,  pj_num);
		
		model.addAttribute("list", namelist);
		model.addAttribute("boardlist", projectboardlist);
		model.addAttribute("pj_num", projectNum);
		model.addAttribute("replies", replies);
		
		return "/projectdetail/board";
	}
	
	
	@GetMapping("/register")
	public void registForm(Model model) {
		model.addAttribute("pj_num", projectNum);
	}
	
	@PostMapping("/register")
	public String register(ProjectBoardVO board) {
		if(board.getPb_status() == null) {
			board.setPb_status("N");
		}
		service.insertProjectBoard(board);
		return "redirect:/projectdetail/home/" + projectNum;
	}
	
	
	@ResponseBody
	@PostMapping("/registReply")
	public List<BoardReplyVO> registReply(@RequestBody BoardReplyVO reply) {
		service.insertReply(reply);
		Long pb_num = reply.getPb_num();
		List<BoardReplyVO> replies = service.listBoardReply(pb_num, projectNum);
		return replies;
	}
	
	
	@GetMapping("/deleteReply{pr_num}")
	public String deleteReply(@PathVariable("pr_num") Long pr_num) {
		service.deleteReply(pr_num);
		
		return "redirect:/projectdetail/home/" + projectNum;
	}
	
	
	@GetMapping("/uploadfile")
	public void uploadFile() {
		
	}
	
	@PostMapping(value = "/uploadfile", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<List<BoardAttachVO>> uploadAjaxFile(MultipartFile[] uploadFile) {
		
		log.info("update ajax post........");
		
		List<BoardAttachVO> list = new ArrayList<BoardAttachVO>();
		String uploadFolder = "C:\\upload";
		
		for(MultipartFile multipartFile : uploadFile) {
			log.info("-------------------------------------");
			log.info("Upload File Name: " + multipartFile.getOriginalFilename());
			log.info("Upload File Size: " + multipartFile.getSize());
			
			BoardAttachVO attach = new BoardAttachVO();
			
			String uploadFileName = multipartFile.getOriginalFilename();
			
			uploadFileName = uploadFileName.substring(uploadFileName.lastIndexOf("\\") + 1);
			log.info("only file name" + uploadFileName);
			attach.setPf_name(uploadFileName);
			
			UUID uuid = UUID.randomUUID();
			uploadFileName = uuid.toString() + "_" + uploadFileName;
			
			
			try {
				File saveFile = new File(uploadFolder, uploadFileName);
				multipartFile.transferTo(saveFile);
				
				attach.setPf_uuid(uuid.toString());
				attach.setPf_path(uploadFolder);
				
				
				list.add(attach);
				
			} catch (Exception e) {
				log.error(e.getMessage());
			}
		}
		
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	
	@GetMapping(value="/getAttachList", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<List<BoardAttachVO>> getAttachList(Long pj_num){
		log.info("getAttachList" + pj_num);
		
		return new ResponseEntity<List<BoardAttachVO>>(service.getAttachList(pj_num), HttpStatus.OK);
	}
	
	@GetMapping(value = "/download", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	@ResponseBody
	public ResponseEntity<Resource> downloadFile(@RequestHeader("User-Agent") String userAgent, String fileName){
		
		log.info(userAgent);
		log.info(fileName);
		
		Resource resource = new FileSystemResource(fileName);
		
		if(resource.exists() == false) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		String resourceName = resource.getFilename();
		HttpHeaders headers = new HttpHeaders();
		
		try {
			String downloadName = null;
			if(userAgent.contains("Trident")) {
				downloadName = URLEncoder.encode(resourceName, "UTF-8").replaceAll("\\", " ");
			} else if(userAgent.contains("Edge")) {
				downloadName = URLEncoder.encode(resourceName, "UTF-8");
			} else {
				downloadName = new String(resourceName.getBytes("UTF-8"), "ISO-8859-1");
			}
			
			headers.add("Content-Disposition", "attachment; filename=" + downloadName);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<>(resource, headers, HttpStatus.OK);
	}
	
	@GetMapping("/calendar")
	public void showCalendar(Model model) {
		model.addAttribute("pj_num", projectNum);
	}
	
	
	@GetMapping("/registerCal")
	public void registerCalForm(Model model) {
		model.addAttribute("pj_num", projectNum);
	}
	
	@PostMapping("/registerCal")
	public String registerCal(ProjectCalVO calendar) {
		
		calService.insertCalendar(calendar);
		return "redirect: /projectdetail/calendar";
	}

}
