package org.tetris.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.tetris.domain.AuthVO;
import org.tetris.domain.UserVO;
import org.tetris.security.CustomNoOpPasswordEncoder;
import org.tetris.service.UserService;

import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/hr/*")
@Controller
public class AdminController {
 @Autowired
 UserService service;
 
 @Autowired
 CustomNoOpPasswordEncoder passEncoder;
	


 @Secured({"ROLE_ADMIN"})
 @GetMapping("/admin")
 public void doAdmin() {
	 log.info("AdminOnly");
 }
 @Secured({"ROLE_ADMIN"})
 @GetMapping("/register")
 public void register() {
	log.info("get register");
 }
 @PostMapping("/register")
 public String register(UserVO vo,AuthVO auth){
	String inputPass =vo.getUserPass();
	String pass = passEncoder.encode(inputPass);
	 
	service.insertUser(vo);
	service.insertAuthmapping(auth);
	 return "redirect:/member/all";
	  
 }
}
