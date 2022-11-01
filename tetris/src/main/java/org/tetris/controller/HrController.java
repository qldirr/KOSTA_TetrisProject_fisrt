package org.tetris.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.tetris.domain.HrVO;
import org.tetris.service.HrService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/attendance/*")
@AllArgsConstructor
public class HrController {
	
	private HrService service;
	//근태관련 컨트롤러
	
//person.jsp 개인근태페이지 - e_id로 정보출력
	@GetMapping("/person")
	public void get(@RequestParam("e_id") String e_id, Model model) {
		log.info("/get");
		
		model.addAttribute("hrVO", service.getHr(e_id));
		model.addAttribute("list", service.getHrList(e_id));
		
	}
	
	
	
	//출근하기
	@PostMapping("/insertAction.do")
	@ResponseBody
	public String insertAction(@RequestBody HrVO hr, Model model, RedirectAttributes rttr) {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
		log.info("insertAction.do");
		log.info("e_id: " + hr.getE_id());
		hr.setHr_Time(formatter.format(date));
		log.info(hr.getHr_Time());
		service.startDate(hr.getE_id());
		rttr.addFlashAttribute("e_id", hr.getE_id());
		
		//rttr.addFlashAttribute("result", hr.getE_id());
		return "redirect:/attendance/person";
	}
	
	//외근
	@PostMapping("/outAction.do")
	@ResponseBody
	public String outAction(@RequestBody HrVO hr, Model model, RedirectAttributes rttr) {
		log.info("outAction.do...");
		service.outDate(hr.getE_id());
		rttr.addFlashAttribute("e_id", hr.getE_id());
		
		return "redirect:/attendance/person";
	}

	//퇴근하기
	@PostMapping("/endAction.do")
	@ResponseBody
	public String endDate(@RequestBody HrVO hr, Model model, RedirectAttributes rttr) {
		log.info("/endAction.do");
		log.info("e_id: " + hr.getE_id());
		service.endDate(hr.getE_id());
		rttr.addFlashAttribute("e_id", hr.getE_id());

		return "redirect:/attendance/get";
	} 
	
	
	
//personAll.jsp
	
	//처음들어가면 리스트 출력
	@GetMapping("/personAll")
	public void get(Model model) {
		log.info("get...");
		
		model.addAttribute("list", service.getHrAll());
	}
	
	
	
	
	
}
