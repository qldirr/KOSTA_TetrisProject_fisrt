package org.tetris.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.tetris.domain.CarInfoVO;
import org.tetris.service.CarInfoService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/carInfo/*")
@AllArgsConstructor

public class CarInfoController {
	
	@Autowired
	private CarInfoService service;
	
	
	@GetMapping("/listCar")
	public List<CarInfoVO> listCar() {
		log.info("listCar.....");
		List<CarInfoVO> car = service.getListCar();
		log.info(car);	
		return car;
	}
	
		
	@GetMapping("/registerCar")
	public void registerCar() {
				
	}
		
	@PostMapping("/registerCar")
	public void registerCar(CarInfoVO car,RedirectAttributes rttr) {
		
		log.info("registerCar....");
		service.registerCar(car);
		rttr.addFlashAttribute("result",car.getCa_num());
	
		//return "redirect:/Carinfo/list";
				
	}
	

}
