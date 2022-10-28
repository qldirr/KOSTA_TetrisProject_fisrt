package org.tetris.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.tetris.domain.CarBookVO;
import org.tetris.service.CarBookService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/carbook/*")
@AllArgsConstructor


public class CarBookController {
	
	@Autowired
	private CarBookService service;
	
	@GetMapping("/listResCar")
	public void listResCar(Model model){
		log.info("listResCar....");
		model.addAttribute("list", service.listResCar());		
	}
	
	
	@GetMapping("/registerRseCar")
	public void registerRseCar() {
		
		
	}
	
	public String registerRseCa(CarBookVO cb,Model model) {
		service.registerRseCar(cb);
		
		model.addAttribute(model);
		
		return"/Carbook/listResCar";		
	}

}
