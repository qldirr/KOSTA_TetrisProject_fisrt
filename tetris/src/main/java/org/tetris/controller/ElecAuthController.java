package org.tetris.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tetris.domain.elecauth.ElecAuthVO;
import org.tetris.domain.elecauth.ElecLineVO;
import org.tetris.domain.user.UserVO;
import org.tetris.mapper.ProjectMapper;
import org.tetris.service.ElecAuthService;
import org.tetris.service.ProjectService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/elecauth/*")
@Log4j
@AllArgsConstructor
public class ElecAuthController {
	
	
	@Autowired
	private ProjectService service;
	
	@Autowired
	private ElecAuthService elecService;
	
	@GetMapping("/main")
	public void getMain() {
		
	}
	
	@GetMapping("/register")
	public void registerForm() {
		
	}
	
	@GetMapping("/selectForm")
	public void selectForm() {
		
	}
	
	@GetMapping("/line")
	public void registerLine(Model model) {
		model.addAttribute("dept", service.getListDept());
		model.addAttribute("employees", service.getListEmployees());
	}
	
	@PostMapping("/line")
	public void registerLine(@RequestBody ElecLineVO line) {
		
		String l_num = line.getL_num();
		String e_id = "";
		String l_seq = "";
		
		log.info(l_num);
		line.getLines().forEach(list -> log.info(list));
		
		for (int i = 0; i < line.getLines().size(); i++) { 
			l_seq = String.valueOf(i+1);
			e_id = line.getLines().get(i);
			elecService.registerElecLine(l_num, l_seq, e_id);
		}
		
	}
	
	
	@Transactional
	@PostMapping("/register")
	public void register(@RequestBody ElecAuthVO auth) {
		
		elecService.registerElecAuth(auth);
		elecService.modifyElecLine(auth);
		
		log.info(auth.getE_id());
		
	}
	
	
	@GetMapping("/document/{el_num}")
	public String showDocument(@PathVariable("el_num") Long el_num, Model model) {
		
		el_num = (el_num == 0)? elecService.getRecentDoc("gdong123") : el_num;
		String l_num = String.valueOf(el_num); 
		
		ElecAuthVO auth = elecService.getElecAuth(el_num);
		List<ElecLineVO> line = elecService.getListElecLine(l_num);
		
		
		model.addAttribute("auth", auth);
		model.addAttribute("line", line);
		
		String draft = "/elecauth/draftResult";
		String vacation = "/elecauth/vacationResult";
		
		
		switch (Integer.parseInt(auth.getDm_num())) {
		case 1:
			return draft;
	
		case 2:
			return vacation;
		}
		return null;

	}
	
	
	@GetMapping("/draftResult")
	public void getDraft() {
		
	}
	
	@GetMapping("/vacationResult")
	public void getVacation() {
		
	}
	
	
	@GetMapping("/writtenList")
	public void getWrittenList(Model model) {
		
		List<ElecAuthVO> list = elecService.getListElecAuth("gdong123");
		model.addAttribute("authlist", list);
	}
	
	
	@GetMapping("/uncheckedList")
	public void getUncheckedList(Model model) {
		List<ElecAuthVO> list = elecService.getListUncheckedList("nayoung88");
		model.addAttribute("authlist", list);
	}
	
	@Transactional
	@PostMapping("/check")
	public String modifyCheckStatus(@RequestBody ElecLineVO line, Model model) {

		elecService.modifyElecLine(line);
		
		if(line.getL_status().equals("결재완료")) {
			
			Long leftLine = elecService.checkElecAuthStatus(line.getL_num());
			
			String el_status = (leftLine == 0)? "결재완료" : "결재진행중";
			elecService.modifyElecProcess(el_status, line.getL_num());
			
		}
		
		return "redirect:/elecauth/main";
	}
	
	
	@GetMapping("/disapprovedList")
	public void getDisapprovedList(Model model) {
		List<ElecAuthVO> list = elecService.getListDisapproved("gdong123");
		model.addAttribute("authlist", list);
	}
	
	
	@GetMapping("/modify/{el_num}")
	public String modifyElecAuth(@PathVariable("el_num") Long el_num, Model model) {
		
		String l_num = String.valueOf(el_num); 
		
		ElecAuthVO auth = elecService.getElecAuth(el_num);
		List<ElecLineVO> line = elecService.getListElecLine(l_num);
		

		model.addAttribute("auth", auth);
		model.addAttribute("line", line);
		
		String draft = "/elecauth/draftUpdateForm";
		String vacation = "/elecauth/vacationResult";
		
		
		switch (Integer.parseInt(auth.getDm_num())) {
		case 1:
			return draft;
	
		case 2:
			return vacation;
		}
		return null;
	
		
	}
	
	
	@GetMapping("/draftUpdateForm")
	public void draftUpdateForm() {
		
	}
	
	@Transactional
	@PostMapping("modify")
	public String modifyElecAuth(@RequestBody ElecAuthVO auth) {
		
		String l_num = String.valueOf(auth.getEl_num()); 
		elecService.modifyElecAuth(auth);
		elecService.resetElecLine(l_num);
		
		return "redirect:/elecauth/document/" + auth.getEl_num();
	}
	
	
	@PostMapping("remove")
	public String removeElecAuth(Long el_num) {
		
		return "redirect:/elecauth/main";
	}
	

}
