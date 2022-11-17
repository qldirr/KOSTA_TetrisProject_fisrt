package org.tetris.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.tetris.domain.reservation.CarInfoVO;
import org.tetris.service.CarInfoService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/reservation/*")
@AllArgsConstructor

public class CarInfoController {
	
	@Autowired
	private CarInfoService service;
		
	
	//목록
	@GetMapping("/listcar")
	public String listCar(Model model) {
		log.info("listCar.....");
		
		model.addAttribute("list",service.getListCar());
				
		return "/reservation/listcar";
	}
		
	//등록 페이지 이동	
	@GetMapping("/registercar")
	public String registerCar(Model model) {
		
		return "/reservation/registercar";
				
	}
		
	//차량 등록
	@PostMapping("/registercar")
	public String registerCar(CarInfoVO car,Model model) {
		
		log.info("registerCar....");
		service.registerCar(car);
	
		return "redirect:/reservation/listcar";
				
	}
	
	//컨트롤러가 왜 안되냐구....
	@GetMapping("/readcar")
	public String readcar(@RequestParam("ca_num") String ca_num, Model model) {
	
	
		model.addAttribute("readcar",service.getCar(ca_num));
		
		return "/reservation/readcar";
	}
	

}
