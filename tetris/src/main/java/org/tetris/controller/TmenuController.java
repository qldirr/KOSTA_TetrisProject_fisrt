package org.tetris.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.tetris.domain.Criteria;
import org.tetris.domain.PageDTO;
import org.tetris.domain.suggestions.SuggestionsVO;
import org.tetris.domain.tmenu.TmenuVO;
import org.tetris.service.NoticeService;
import org.tetris.service.SuggestionsService;
import org.tetris.service.TmenuService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/tmenu/*")
@AllArgsConstructor
public class TmenuController {

	private TmenuService service;
	
	@GetMapping("/list")
	public void list(Model model) {
	
	log.info("list");
	model.addAttribute("list", service.getList());
	}
	
	@PostMapping("/register")
	public String register(TmenuVO tmenu, RedirectAttributes rttr) {
		
		log.info("register: " + tmenu);		
		service.regeister(tmenu);		
		rttr.addFlashAttribute("result", tmenu.getT_num());	
		return "redirect:/tmenu/list";
	}

	@GetMapping("/register")	
	public void register() {
		
	}
	
	@GetMapping("/get")  
	public void get(@RequestParam("t_num") Long t_num, Model model) {
		
		log.info("/get");
		model.addAttribute("tmenu", service.get(t_num));
	}	
	
	@PostMapping("/modify")
	public String modify(TmenuVO tmenu, RedirectAttributes rttr) {		
		//SuggestionsVO suggestions, 
		
		
		log.info("modify : " + tmenu);	
		// + suggestions
		
		if (service.modify(tmenu)) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/tmenu/list";
	}	
	
	@PostMapping("remove")
	public String remove(@RequestParam("t_num") Long t_num, RedirectAttributes rttr) {

		
		log.info("remove : " + t_num);
		
		if (service.remove(t_num)) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/tmenu/list";
	}	
	
	
	
	
	
	
	
}
