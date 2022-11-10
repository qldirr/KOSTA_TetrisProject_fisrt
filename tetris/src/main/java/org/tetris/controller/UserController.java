package org.tetris.controller;




import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.tetris.domain.AuthVO;
import org.tetris.domain.DepartmentVO;
import org.tetris.domain.EmployeeVO;
import org.tetris.domain.UserVO;
import org.tetris.security.CustomNoOpPasswordEncoder;
import org.tetris.service.ChatService;
import org.tetris.service.UserService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/member/*")
@Controller
@AllArgsConstructor
public class UserController {
 @Autowired
 UserService service;

 @Autowired
 CustomNoOpPasswordEncoder passEncoder;
	
 @GetMapping("/all")
 public void doAll() {
	 log.info("all access");
 }
 @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
 @GetMapping("/user")
 public void doUser(Model model, String e_id) {
UserVO vo = service.detailUser(e_id); 
model.addAttribute("u",vo);
		 
	 log.info("UserOnly");
 }

 @GetMapping("/modifyView")
 public void modify(Model model, String e_id) {
		UserVO vo = service.detailUser(e_id);
		model.addAttribute("u",vo);	
	 log.info("get UPDATE");
 }
 
 @PostMapping("/modify")
 public String modify(UserVO user) {
	service.updateUser(user);
	return "redirect:/";
 }

 
 
	/*
	 * @Secured({"ROLE_ADMIN"})
	 * 
	 * @GetMapping("/admin") public void doAdmin() { log.info("AdminOnly"); }
	 * 
	 * @Secured({"ROLE_ADMIN"})
	 * 
	 * @GetMapping("/register") public void register() { log.info("get register"); }
	 * 
	 * @PostMapping("/register") public String register(UserVO vo,AuthVO auth){
	 * String inputPass =vo.getUserPass(); String pass =
	 * passEncoder.encode(inputPass);
	 * 
	 * service.insertUser(vo); service.insertAuthmapping(auth); return
	 * "redirect:/user/all";
	 * 
	 * }
	 */
}
