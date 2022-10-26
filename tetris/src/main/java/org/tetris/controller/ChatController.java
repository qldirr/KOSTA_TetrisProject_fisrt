package org.tetris.controller;

import java.util.List;
import java.util.Map;

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
		EmployeeVO empvo = service.login(user);
		List<EmployeeVO> listEmp = service.getListEmp();
		List<DepartmentVO> listDept = service.getListDept();
		
		System.out.println(user);
		System.out.println(empvo);
		
		if(empvo != null) {
			HttpSession session = request.getSession();
			session.setAttribute("user", empvo);
			
			model.addAttribute("empvo", empvo);
			model.addAttribute("listEmp", listEmp);
			model.addAttribute("listDept", listDept);
			
			return "/messanger/main/emplist";
		}else {
			return "/messanger/chatlogin";
		}
	}
	
	@PostMapping("/register")
	@ResponseBody
	public String registerCR(@RequestParam Map<String, Object> map) {
		System.out.println((String)map.get("e_id"));
		return "redirect:/messanger/register";
	}
	
	@GetMapping("/register")
	public void registerCR() {
		
	}
	
	@GetMapping("/chatting")
	public void chatting() {
		
	}

}
