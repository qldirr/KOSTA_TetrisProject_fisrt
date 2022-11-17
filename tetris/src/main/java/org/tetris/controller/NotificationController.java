package org.tetris.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.tetris.domain.notification.AlarmVO;
import org.tetris.domain.Criteria;
import org.tetris.domain.PageDTO;
import org.tetris.security.domain.CustomUser;
import org.tetris.service.NotificationService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/notification/*")
@Log4j
@AllArgsConstructor
public class NotificationController {
	
	@Autowired
	private NotificationService service;
	
	@PostMapping("/register")
	public String registerNotification(@RequestBody AlarmVO alarm) {
		
		log.info(alarm);
		service.registerNotification(alarm);
		
		return "redirect: /project/main";
	}
	
	
	@ResponseBody
	@GetMapping("/count")
	public int countNotification() {
		CustomUser user = (CustomUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String e_id = user.getUsername();
		return service.countNotification(e_id);
	}
	
	
	@ResponseBody
	@GetMapping("/list")
	public List<AlarmVO> getListNotification() {
		CustomUser user = (CustomUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String e_id = user.getUsername();
		return service.readNotificationList(e_id);
	}
	
	
	@PostMapping("/check")
	public String modifyNotiStatus(Long al_num) {
		service.modifyNotiStatus(al_num);
		
		return "redirect: /project/main";
	}
	
	
	@GetMapping("/checkTotal")
	public String modifyTotalNotiStatus() {
		CustomUser user = (CustomUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String e_id = user.getUsername();
		service.modifyTotalNotiStatus(e_id);
		return "redirect: /notification/all/1";
	}
	
	
	@GetMapping("/all/{pageNum}")
	public String getListTotalNotification(@PathVariable("pageNum") int pageNum, Model model) {
		CustomUser user = (CustomUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String e_id = user.getUsername();
		
		Criteria cri = new Criteria(pageNum, 10);
		model.addAttribute("list", service.readTotalNotificationList(cri, e_id));
		model.addAttribute("pageMaker", new PageDTO(cri, service.countTotalNotification(e_id)));
		
		
		return "/notification/all";
	}
	
	

}
