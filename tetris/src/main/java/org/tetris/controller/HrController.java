package org.tetris.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.tetris.service.HrService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/attendance")
@AllArgsConstructor
public class HrController {
	
	private HrService service;
	//근태관련 컨트롤러
	
	//개인근태페이지 - e_id로 정보출력
	@GetMapping("/get")
	public String get( Model model) {
		log.info("/get");
		
		//model.addAttribute("hrVO", service.get(e_id));
		return "person";
	}

	@GetMapping("/listAll")
	public void listAll() {
		log.info("main page...");
	}
	
	@PostMapping("/setHour")
	public void setHour() {
		log.info("setting...");
		
	}
	
	@PostMapping("/setHoli")
	public void setHoli() {
		
	}
	
	@GetMapping("/listAllStatic")
	public void listAllStatic() {
		
	}
	
	@GetMapping("/checkFifyTwo")
	public void checkFifyTwo() {
		
	}
	
	//출퇴근시간
	@PostMapping("/startingWork")
	public void staringWork() {
		
	}
	
	
	@GetMapping("/holiday")
	public void holiday() {
		
	}
	
	@GetMapping("listTeam")
	public void ListTeam() {
		
	}
	
	@GetMapping("leavingAgent")
	public void leavingAgent() {
		
	}
	
	
	@GetMapping("alert")
	public void alert() {
		
	}
	

	
}
