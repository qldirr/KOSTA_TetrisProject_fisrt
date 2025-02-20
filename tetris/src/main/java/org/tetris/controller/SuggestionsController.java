package org.tetris.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.tetris.domain.Criteria;
import org.tetris.domain.PageDTO;
import org.tetris.domain.suggestions.SuggestionsVO;
import org.tetris.service.SuggestionsService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/suggestions/*")
@AllArgsConstructor
public class SuggestionsController {

	private SuggestionsService service;
	
	//리스트
	@GetMapping("/suggestionslist")
	public void list(Criteria cri, Model model) {
		
		log.info("list" + cri);
		model.addAttribute("list", service.getList(cri));
		model.addAttribute("pageMaker", new PageDTO(cri, 123));
	}	
	
	//글 등록
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
	
	//자세히 보기, 수정
	@GetMapping({"/suggestionsget", "/suggestionsmodify"})  
	public void get(@RequestParam("s_num") Long s_num, @ModelAttribute("cri") //@ModelAttribute("cri") Criteria cri -> 실행x 316
	Criteria cri, Model model) {
		
		log.info("/suggestionsget or suggestionsmodify");
		model.addAttribute("suggestions", service.get(s_num));
		log.info("get");
	}	
	
	@PostMapping("/suggestionsmodify")
	public String modify(SuggestionsVO suggestions, RedirectAttributes rttr) {
		
		if(service.modify(suggestions)) {
			rttr.addFlashAttribute("result", "success");
		}	
		return "redirect:/suggestions/suggestionslist";
	}

	//삭제
	@PostMapping("remove")
	public String remove(@RequestParam("s_num") Long s_num, RedirectAttributes rttr) {

		
		log.info("remove : " + s_num);
		
		if (service.remove(s_num)) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/suggestions/suggestionslist";
	}
	

}










