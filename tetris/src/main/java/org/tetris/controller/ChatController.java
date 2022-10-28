package org.tetris.controller;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
import org.tetris.service.ChatService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/messanger/*")
@Log4j
@AllArgsConstructor
public class ChatController {
	
	@Autowired
	private ChatService service;
	
	@GetMapping("/chatlogin")
	public void chatLogin() {
		
	}
	
	@PostMapping("/chatlogin")
	public String chatLogin(@RequestParam("user") String user, Model model, HttpServletRequest request) {
		EmployeeVO empVO = service.login(user);
		List<EmployeeVO> listEmp = service.getListEmp();
		List<DepartmentVO> listDept = service.getListDept();
		HttpSession session = request.getSession();
		session.setAttribute("user", empVO);
		
		if(session.getAttribute("user") != null) {
			model.addAttribute("listEmp", listEmp);
			model.addAttribute("listDept", listDept);
			
			return "/messanger/main/emplist";
		}else {
			return "/messanger/chatlogin";
		}
	}
	
	@GetMapping("/main/emplist")
	public void empList() {
		
	}
	
	@GetMapping("/main/chatroomlist")
	public void chatRoomList(HttpSession session, Model model) {
		EmployeeVO emp = (EmployeeVO)session.getAttribute("user");
		String e_id = emp.getE_id();
		model.addAttribute("listChatRoom", service.getListCRoom(e_id));
		System.out.println(service.getListCRoom(e_id));
	}
	
	@PostMapping("/register")
	@ResponseBody
	public void registerCR(@RequestBody Map<String, Object> map, HttpSession session) {
		EmployeeVO user = (EmployeeVO)session.getAttribute("user");
		String user_name = user.getE_name();
		
		String e_id = (String)map.get("e_id");
		EmployeeVO emp = service.getEmp(e_id);
		String emp_name = emp.getE_name();
		
		String cr_title = user_name + ", " + emp_name;
		
		String uuid = UUID.randomUUID().toString();
		ChatRoomVO chatRoomVO = new ChatRoomVO();
		chatRoomVO.setCr_id(uuid);
		chatRoomVO.setCr_title(cr_title);
		service.registerCRoom(chatRoomVO);
		
		ChatParticipantVO chatPartVO = new ChatParticipantVO();
		chatPartVO.setCr_id(chatRoomVO.getCr_id());
		chatPartVO.setE_id(user.getE_id());
		service.registerCPart(chatPartVO);
		
		chatPartVO.setCr_id(chatRoomVO.getCr_id());
		chatPartVO.setE_id(emp.getE_id());
		service.registerCPart(chatPartVO);
	}
	
	@GetMapping("/chatting")
	public void chatting() {
		
	}

}
