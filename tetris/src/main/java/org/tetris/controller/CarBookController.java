package org.tetris.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.tetris.domain.CarBookVO;
import org.tetris.domain.CarInfoVO;
import org.tetris.security.domain.CustomUser;
import org.tetris.service.CarBookService;
import org.tetris.service.CarInfoService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/reservation/*")
@AllArgsConstructor

public class CarBookController {

	@Autowired
	private CarBookService service;

	@Autowired
	private CarInfoService carservice;
	
	

	// 차량 목록페이지

	@GetMapping("/rescarmain")
	public void lisCarpage(Model model) {

		model.addAttribute("");
		log.info("listCar....");
		model.addAttribute("list", carservice.getListCar());

	}

	// 차량 목록페이지(질문해여해)
	/*
	 * @PostMapping("/rescarmain") public String lisCar(Model model) {
	 * 
	 * log.info("listCar...."); model.addAttribute("list", carservice.getListCar());
	 * 
	 * return "/reservation/registerrsecar";
	 * 
	 * }
	 */

	/*// 차량예약 등록페이지
	@PostMapping("/registerrsecainfo")
	public String registerRseCar(@RequestBody String ca_num, Model model) {

		return "/reservation/registerrsecar";

	}*/
	
	@Secured({"ROLE_USER"})
	@GetMapping("/registerrsecar")
	public void registerRseCar(@RequestParam("ca_num") String ca_num, Model model) {
		CustomUser user = (CustomUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userName = user.getUser().getE_name();
		model.addAttribute("userName",userName);
		model.addAttribute("registerrsecar",carservice.getCar(ca_num));

	}

	// 차량예약 등록하기
	@PostMapping("/registerrsecar")
	public String registerRseCar(CarBookVO cb, Model model, RedirectAttributes rttr) {
		log.info("registerrescar...........");

		service.registerRseCar(cb);

		return "redirect:/reservation/rescarmain";
	}

	// 예약된 차량목록
	@GetMapping("/listrescar")
	public String listResCar(Model model) {

		log.info("listResCar....");
		model.addAttribute("list", service.listResCar());

		return "/reservation/listrescar";
	}
	
	
	
	@PostMapping("/setCarApp")
   public String setCarApp(@RequestParam("cb_num") Long cb_num, Model model) {
		
			service.carResApp(cb_num);
			
	   return "redirect:/reservation/rescarmain";
   }
	
	

	// 예약조회
	@GetMapping("/readrescar")
	public String readResCar(@RequestParam("cb_num") Long cb_num, Model model) {

		model.addAttribute("rescar", service.readResCar(cb_num));

		return "/reservation/readrescar";

	}

}
