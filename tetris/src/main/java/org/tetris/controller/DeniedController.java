package org.tetris.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@AllArgsConstructor
@RequestMapping("/member/*")
public class DeniedController {
@GetMapping("/accessError")
public void accessDenied(Authentication auth, Model model) {
	log.info("access Denied: " + auth);
	model.addAttribute("msg", "ACCESS DENIED");
}

@GetMapping("/customLogin")
public void loginInput(String error, String logout, Model model) {
	log.info("error: " + error);
	log.info("logout: " + logout);
	
	if(error!=null) {
		model.addAttribute("error", "입력하신 정보가 올바르지 않습니다.");
	}
	
	if(logout!=null) {
		model.addAttribute("logout","Logout!!");	
		
	}
}

@GetMapping("/logout")
public void getLogout() {
	log.info("custom logout");
}
}