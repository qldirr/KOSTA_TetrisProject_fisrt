package org.tetris.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.tetris.domain.SuggestionsVO;
import org.tetris.service.SuggestionsService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/suggestions/*")
@AllArgsConstructor
public class SuggestionsController {

	private SuggestionsService service;
	
	@GetMapping("/suggestionslist")
	public void list(Model model) {
		
		log.info("list");
		model.addAttribute("list", service.getList());
	}
	
	@PostMapping("/suggestionsregister")
	public String register(SuggestionsVO suggestions, RedirectAttributes rttr) {
		
		log.info("register: " + suggestions);
		
		service.register(suggestions);
		
		rttr.addFlashAttribute("result", suggestions.getS_num());
		
		return "redirect:/suggestions/suggestionslist";
	}

	@GetMapping("/suggestionsregister")	
	public void register() {
		
	}
	
	
	/*@GetMapping("/suggestionsget")  
	public void get(@RequestParam("s_num") Long s_num, Model model) {
		
		log.info("/get");
		model.addAttribute("suggestions", service.get(s_num));
	}*/
	
	@GetMapping({"/suggestionsget", "/suggestionsmodify"})  
	public void get(@RequestParam("s_num") Long s_num, Model model) {
		
		//log.info("/get or modify");
		model.addAttribute("suggestions", service.get(s_num));
	}	
	

	
	
	@PostMapping("/modify")
	public String modify(RedirectAttributes rttr) {		
		//SuggestionsVO suggestions, 
		
		
		log.info("modify : ");	
		// + suggestions
		
		//if (service.modify(suggestions)) {
			//rttr.addFlashAttribute("result", "success");
		//}
		return "redirect:/suggestions/suggestionslist";
	}

	/*@PostMapping("/modify")
	public  String modity(SuggestionsVO suggestions, RedirectAttributes rttr) {
		log.info("modify :" + suggestions);
		
		if(service.modify(suggestions)) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/suggestions/suggestionslist";
	}*/
	
	
	
	
	
	@PostMapping("remove")
	public String remove(@RequestParam("s_num") Long s_num, RedirectAttributes rttr) {

		
		log.info("remove : " + s_num);
		
		if (service.remove(s_num)) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/suggestions/suggestionslist";
	}
	

}










