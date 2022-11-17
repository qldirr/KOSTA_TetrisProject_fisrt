package org.tetris.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
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
import org.tetris.domain.Criteria;
import org.tetris.domain.elecauth.ElecAuthVO;
import org.tetris.domain.elecauth.ElecLineVO;
import org.tetris.domain.PageDTO;
import org.tetris.domain.user.UserVO;
import org.tetris.mapper.ProjectMapper;
import org.tetris.security.domain.CustomUser;
import org.tetris.service.ElecAuthService;
import org.tetris.service.ProjectService;
import org.tetris.service.UserService;

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
	
	@Autowired
	private UserService userService;
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
	@GetMapping("/main")
	public void getMain(Model model) {
		
		CustomUser user = (CustomUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String e_id = user.getUsername();
		List<ElecAuthVO> list1 = elecService.getListElecAuth(e_id);
		List<ElecAuthVO> list2 = elecService.getListUncheckedList(e_id);
		model.addAttribute("authlist1", list1);
		model.addAttribute("authlist2", list2);
		
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
	@GetMapping("/register")
	public void registerForm(Model model) {
		CustomUser user = (CustomUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String user_name = user.getUser().getE_name();
		String user_id = user.getUsername();
		model.addAttribute("userName", user_name);
		model.addAttribute("userId", user_id);
	}
	
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
	@GetMapping("/selectForm")
	public void selectForm() {
		
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
	@GetMapping("/line")
	public void registerLine(Model model) {
		
		CustomUser user = (CustomUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String user_id = user.getUsername();
		model.addAttribute("userId", user_id);
		model.addAttribute("dept", service.getListDept());
		model.addAttribute("employees", service.getListEmployees());
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
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
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
	@Transactional
	@PostMapping("/register")
	public void register(@RequestBody ElecAuthVO auth) {
		
		elecService.registerElecAuth(auth);
		elecService.modifyElecLine(auth);

		
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
	@GetMapping("/document/{el_num}")
	public String showDocument(@PathVariable("el_num") Long el_num, Model model) {
		CustomUser user = (CustomUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String e_id = user.getUsername();
		String userName = user.getUser().getE_name();
		String d_num = user.getUser().getD_num();
		
		log.info(e_id);
		el_num = (el_num == 0) ? elecService.getRecentDoc(e_id) : el_num;
		log.info(el_num);
		String l_num = String.valueOf(el_num);

		ElecAuthVO auth = elecService.getElecAuth(el_num);
		List<ElecLineVO> line = elecService.getListElecLine(l_num);

		model.addAttribute("auth", auth);
		model.addAttribute("line", line);
		model.addAttribute("userId", e_id);
		model.addAttribute("userName", userName);
		
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
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
	@GetMapping("/writtenList")
	public void getWrittenList(Model model) {
		
		CustomUser user = (CustomUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String e_id = user.getUsername();
		List<ElecAuthVO> list = elecService.getListElecAuth(e_id);
		model.addAttribute("authlist", list);
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
	@GetMapping("/uncheckedList")
	public void getUncheckedList(Model model) {
		
		CustomUser user = (CustomUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String e_id = user.getUsername();
		
		
		log.info(e_id + "...............................");
		
		List<ElecAuthVO> list = elecService.getListUncheckedList(e_id);
		model.addAttribute("authlist", list);
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
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
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
	@GetMapping("/disapprovedList")
	public void getDisapprovedList(Model model) {
		
		CustomUser user = (CustomUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String e_id = user.getUsername();
		
		List<ElecAuthVO> list = elecService.getListDisapproved(e_id);
		model.addAttribute("authlist", list);
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
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
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
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

	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
	@GetMapping("/sendList")
	public void sendList(Model model) {//Criteria cri, 
		
		CustomUser user = (CustomUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String e_id = user.getUsername();
		List<ElecAuthVO> list = elecService.sendList(e_id);
		model.addAttribute("authlist", list); 
		//model.addAttribute("authlist", elecService.sendList(cri)); 
		//model.addAttribute("pageMaker", new PageDTO(cri, 123));		
	}	
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
	@GetMapping("/getList")
	public void getList(Model model) {//Criteria cri, 
		
		CustomUser user = (CustomUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String e_id = user.getUsername();
		List<ElecAuthVO> list = elecService.getList(e_id);
		model.addAttribute("authlist", list); 		
		//model.addAttribute("authlist", elecService.getList(cri)); 
		//model.addAttribute("pageMaker", new PageDTO(cri, 123));		
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
	@ResponseBody
	@GetMapping("/count")
	public int countUncheckedList() {
		CustomUser user = (CustomUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String e_id = user.getUsername();
		return elecService.countListUncheckedList(e_id);
	}

}
