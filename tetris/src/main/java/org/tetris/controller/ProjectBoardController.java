package org.tetris.controller;

import java.io.File;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.tetris.domain.UserVO;
import org.tetris.domain.project.BoardAttachVO;
import org.tetris.domain.project.BoardReplyVO;
import org.tetris.domain.project.ProjectBoardVO;
import org.tetris.domain.project.ProjectCalVO;
import org.tetris.domain.project.ProjectTaskVO;
import org.tetris.security.domain.CustomUser;
import org.tetris.service.ProjectBoardService;
import org.tetris.service.ProjectCalService;
import org.tetris.service.ProjectService;
import org.tetris.service.ProjectTaskService;

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
	
	@Autowired
	private ProjectTaskService taskService;
	
	private static Long projectNum;
	
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
	@GetMapping("/home/{pj_num}")
	public String getMain(@PathVariable("pj_num") Long pj_num, String searchkey, Model model) {
		projectNum = pj_num;
		Long pb_num = 0L;
		
		CustomUser user = (CustomUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String user_name = user.getUser().getE_name();
		String user_id = user.getUsername();
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("pj_num", projectNum);
		map.put("searchkey", searchkey);
		
		/* List<UserVO> projectMember =service.getProjectInfo(pj_num); */
		List<ProjectBoardVO> projectBoard = service.getListProjectBoard(map);
		List<BoardReplyVO> projectReplies = service.getListBoardReply(pb_num,  pj_num);
		
		model.addAttribute("loginedId", user_id);
		model.addAttribute("board", projectBoard);
		model.addAttribute("replies", projectReplies);
		model.addAttribute("pj_num", projectNum);
		model.addAttribute("project", service.getProject(projectNum));
		
		return "/projectdetail/board";
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
	@GetMapping("/register")
	public void registForm(Model model) {
		
		CustomUser user = (CustomUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String user_name = user.getUser().getE_name();
		String user_id = user.getUsername();
		
		model.addAttribute("loginedId", user_id);
		model.addAttribute("pj_num", projectNum);
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
	@PostMapping("/register")
	public String register(ProjectBoardVO board) {
		if(board.getPb_status() == null) {
			board.setPb_status("N");
		}
		service.registerProjectBoard(board);
		return "redirect:/projectdetail/home/" + projectNum;
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
	@ResponseBody
	@PostMapping("/registerReply")
	public List<BoardReplyVO> registerReply(@RequestBody BoardReplyVO reply) {
		service.registerReply(reply);
		Long pb_num = reply.getPb_num();
		List<BoardReplyVO> replies = service.getListBoardReply(pb_num, projectNum);
		return replies;
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
	@Transactional
	@ResponseBody
	@PostMapping("/removeReply")
	public List<BoardReplyVO> removeReply(@RequestBody BoardReplyVO reply) {
		service.removeReply(reply.getPr_num());
		List<BoardReplyVO> replies = service.getListBoardReply(reply.getPb_num(), projectNum);
		return replies;
	}
	
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
	@GetMapping("/uploadfile")
	public void uploadFileForm() {
		
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
	@PostMapping(value = "/uploadfile", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<List<BoardAttachVO>> uploadFile(MultipartFile[] uploadFile) {
		
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
	
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
	@GetMapping(value = "/getAttachList", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<List<HashMap<Long, Object>>> getAttachList(Long pj_num) {
		
		List<BoardAttachVO> list = service.getAttachList(pj_num);
		
		List<HashMap<Long, Object>> attachList = new ArrayList<HashMap<Long,Object>>();
		HashMap<Long, Object> attachMap;

		for (int i = 0; i < list.size(); i++) {
			
			attachMap = new HashMap<Long, Object>();
			attachMap.put(list.get(i).getPb_num(), list.get(i));
			attachList.add(attachMap);
		}
		
		return new ResponseEntity<List<HashMap<Long, Object>>>(attachList, HttpStatus.OK);
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
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
	
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
	@GetMapping("/calendar")
	public void getCalendar(Model model) {
		model.addAttribute("pj_num", projectNum);
		model.addAttribute("project", service.getProject(projectNum));
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
	@GetMapping(value="/calendarList", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<List<HashMap<String, Object>>> getCalendarList() {
		
		List<ProjectCalVO> list = calService.getListCalendar(projectNum);
		
		log.info(list);
		
		List<HashMap<String, Object>> calList = new ArrayList<HashMap<String,Object>>();
		HashMap<String, Object> calMap;
		
		for(int i=0; i < list.size(); i++) {
			
			calMap = new HashMap<String, Object>();
			calMap.put("title", list.get(i).getPc_name());
			calMap.put("start", list.get(i).getPc_startdate()+"T"+list.get(i).getPc_starttime());
			calMap.put("end", list.get(i).getPc_enddate()+"T"+list.get(i).getPc_endtime());
			
			calList.add(calMap);
		}
		
		log.info(calList);
		
		
		return new ResponseEntity<>(calList, HttpStatus.OK);
	}
	
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
	@GetMapping("/registerCal")
	public void registerCalForm(Model model) {
		model.addAttribute("pj_num", projectNum);
		
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
	@PostMapping("/registerCal")
	public String registerCal(ProjectCalVO calendar) {
		
		calService.registerCalendar(calendar);
		return "redirect: /projectdetail/calendar";
	}
	
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
	@GetMapping("/taskboard")
	public void getTaskBoard(Model model) {
		model.addAttribute("pj_num", projectNum);
		model.addAttribute("project", service.getProject(projectNum));
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
	@GetMapping(value = "/taskList", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<List<ProjectTaskVO>> getTaskList(){
		List<ProjectTaskVO> list = taskService.getListTask(projectNum);
		return new ResponseEntity<>(list, HttpStatus.OK);
		
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
	@GetMapping("/registerTask")
	public void registerTaskForm(Model model) {
		
		String pj_num = String.valueOf(projectNum);
		List<UserVO> projectMember = service.getProjectInfo(pj_num);
		model.addAttribute("member", projectMember);
		model.addAttribute("pj_num", projectNum);
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
	@PostMapping("/registerTask")
	public String registerTask(ProjectTaskVO task){
		log.info(task);
		taskService.registerTask(task);
		
		return "redirect: /projectdetail/taskboard";
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
	@PostMapping("/modifyTask")
	public String modifyTask(@RequestBody ProjectTaskVO task) {
		
		log.info(task);
		taskService.modifyTask(task);
		
		return "redirect: /projectdetail/taskboard";
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
	@PostMapping("/removeTask")
	public String removeTask(Long ts_num) {
		
		taskService.removeTask(ts_num);
		return "redirect: /projectdetail/taskboard";
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
	@GetMapping("/tasklist")
	public void getTaskList(Model model) {
		model.addAttribute("pj_num", projectNum);
		model.addAttribute("project", service.getProject(projectNum));
	}

}