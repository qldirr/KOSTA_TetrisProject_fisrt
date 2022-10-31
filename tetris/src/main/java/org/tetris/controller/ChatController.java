package org.tetris.controller;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.server.ServerEndpoint;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.tetris.domain.DepartmentVO;
import org.tetris.domain.EmployeeVO;
import org.tetris.domain.chat.ChatParticipantVO;
import org.tetris.domain.chat.ChatRoomVO;
import org.tetris.security.domain.CustomUser;
import org.tetris.service.ChatService;

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
	
//	@GetMapping("/chatlogin")
//	public void chatLogin() {
//		
//	}
	
//	@PostMapping("/chatlogin")
//	public String chatLogin(@RequestParam("user") String user, Model model, HttpServletRequest request) {
//		EmployeeVO loginUser = chatService.login(user);
//		List<EmployeeVO> listEmp = chatService.getListEmp();
//		List<DepartmentVO> listDept = chatService.getListDept();
//		HttpSession session = request.getSession();
//		session.setAttribute("loginUser", loginUser);
//		
//		if(session.getAttribute("loginUser") != null) {
//			model.addAttribute("listEmp", listEmp);
//			model.addAttribute("listDept", listDept);
//			
//			return "/messanger/main/emplist";
//		}else {
//			return "/messanger/chatlogin";
//		}
//	}
	
//	@GetMapping("/main/emplist")
//	public void empList() {
//		
//	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
	@GetMapping("/main/chatroomlist")
	public void chatRoomList(HttpSession session, Model model) {
//		EmployeeVO loginUser = (EmployeeVO)session.getAttribute("loginUser");
//		String e_id = loginUser.getE_id();
		CustomUser loginUser = (CustomUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String e_id = loginUser.getUsername();
		model.addAttribute("listChatRoom", chatService.getListCRoom(e_id));
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
	@PostMapping("/register")
	@ResponseBody
	public void registerCR(@RequestBody Map<String, Object> map, HttpSession session, Model model) {
		CustomUser loginUser = (CustomUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String user_name = loginUser.getUser().getUserName();
		
//		EmployeeVO loginUser = (EmployeeVO)session.getAttribute("loginUser");
//		String user_name = loginUser.getE_name();
		
		String e_id = (String)map.get("e_id");
		EmployeeVO emp = chatService.getEmp(e_id);
		String emp_name = emp.getE_name();
		
		String cr_title = user_name + ", " + emp_name;
		
		String cr_id = UUID.randomUUID().toString();
		ChatRoomVO chatRoomVO = new ChatRoomVO();
		chatRoomVO.setCr_id(cr_id);
		chatRoomVO.setCr_title(cr_title);
		chatService.registerCRoom(chatRoomVO);
		
		ChatParticipantVO chatPartVO = new ChatParticipantVO();
		chatPartVO.setCr_id(chatRoomVO.getCr_id());
		chatPartVO.setE_id(loginUser.getUser().getUserId());
		chatService.registerCPart(chatPartVO);
		
		chatPartVO.setCr_id(chatRoomVO.getCr_id());
		chatPartVO.setE_id(emp.getE_id());
		chatService.registerCPart(chatPartVO);
		
		session.setAttribute("cr_id", cr_id);
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
	@PostMapping("/chatting")
	@ResponseBody
	public void chatting(@RequestBody Map<String, Object> map, HttpSession session) {
//		String e_id = (String)map.get("e_id");
		String cr_id = (String)map.get("cr_id");
		session.setAttribute("cr_id", cr_id);
//		model.addAttribute("cr_id", cr_id);
//		rttr.addFlashAttribute("cr_id", cr_id);
//		service.getCRoom(cr_id);
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
	@GetMapping("/chatting")
	public void chatting(Model model) {
		CustomUser loginUser = (CustomUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("loginUser", loginUser.getUser());
	}

}
