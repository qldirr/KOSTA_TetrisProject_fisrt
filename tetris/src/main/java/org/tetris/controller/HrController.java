package org.tetris.controller;

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
@RequestMapping("/attendance")
@AllArgsConstructor
public class HrController {
	
	private HrService service;
	//근태관련 컨트롤러
	
	//개인근태페이지 - e_id로 정보출력
	@GetMapping("/get")
	public String get(@RequestParam("e_id") String e_id, Model model) {
		log.info("/get");
		
		model.addAttribute("hrVO", service.getHr(e_id));
		return "person";
	}
	
	//근태리스트 출력
	@GetMapping("/list")
	public List<HrVO> HrList(Model model) {
		log.info("list.....");
		
		
		
		return null;
	}
	
	
	//출근하기
	@PostMapping("/insertAction.do")
	@ResponseBody
	public String insertAction(@RequestBody HrVO hr, Model model) {
		log.info("/insertAction");
		service.startDate(hr);
		log.info(hr);
		
		//rttr.addFlashAttribute("result", hr.getE_id());
		return "redirect:/attendance/get";
	}

	//퇴근하기
	@PostMapping("/endAction.do")
	@ResponseBody
	public String endDate(@RequestBody HrVO hr, @Param("e_id") String e_id) {
		log.info("/endAction");
		hr.setE_id(e_id);
		service.endDate(hr);
		log.info(hr);

		return "redirect:/attendance/get";
	} 
	
}
