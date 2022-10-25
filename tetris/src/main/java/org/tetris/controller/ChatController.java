package org.tetris.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
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
	public String chatLogin(@RequestParam("user") String user, RedirectAttributes rttr, HttpServletRequest request) {
		EmployeeVO empvo = service.login(user);
		System.out.println(user);
		System.out.println(empvo);
		
		if(empvo != null) {
			rttr.addFlashAttribute("empvo", empvo);
			HttpSession session = request.getSession();
			session.setAttribute("user", empvo);
			return "redirect:/messanger/chatting";
		}else {
			return "redirect:/messanger/chatlogin";
		}
	}
	
	@GetMapping("/chatting")
	public void chatting() {
		
	}

}
