package org.tetris.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.tetris.domain.Criteria;
import org.tetris.domain.notice.NoticeVO;
import org.tetris.domain.PageDTO;
import org.tetris.security.domain.CustomUser;
import org.tetris.service.NoticeService;
import org.tetris.service.SuggestionsService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/notice/*")
@AllArgsConstructor
public class Noticecontroller {
	
	private NoticeService service;

	//리스트
	@GetMapping("/list")
	public void list(Criteria cri, Model model) {
		
		log.info("list" + cri);
		model.addAttribute("list", service.getList(cri));
		model.addAttribute("pageMaker", new PageDTO(cri, 123));
	}		
	
	//글 등록
	@PostMapping("/register")
	public String register(NoticeVO notice, RedirectAttributes rttr) {
		
		log.info("register: " + notice);
		service.register(notice);
		rttr.addFlashAttribute("result", notice.getN_num());
		return "redirect:/notice/list";
	}
	
	@Secured({ "ROLE_ADMIN" })
	@GetMapping("/register")
	public void register(Model model) {
		CustomUser user = (CustomUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String user_id = user.getUsername();
		model.addAttribute("userId", user_id);
	}
	
	//자세히 보기, 수정
	@GetMapping({"/get","/modify"})
	public void get(@RequestParam("n_num") Long n_num,  @ModelAttribute("cri")
	Criteria cri, Model model) {
		
		log.info("/get or modify");
		model.addAttribute("notice", service.get(n_num));
	}	
	
	@PostMapping("/modify")
	public String modify(NoticeVO notice, RedirectAttributes rttr) {
		log.info("modify:" + notice);
		
		if(service.modify(notice)) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/notice/list";
	}

	//삭제
	@PostMapping("remove")
	public String remove(@RequestParam("n_num") Long n_num, RedirectAttributes rttr) {
	
		log.info("remove..." + n_num);
		
		if(service.remove(n_num)) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/notice/list";
	}

}

