package org.tetris.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.tetris.domain.reservation.MeetingRoomVO;
import org.tetris.service.MeetingRoomService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/meetingroom/*")
@AllArgsConstructor
public class MeetingRoomController {
	
	
	@Autowired
	private MeetingRoomService service;
	
	 
	 
	 @GetMapping("/listroom")
		public String listRoom(Model model) {
			log.info("listroom.....");
			
			model.addAttribute("list",service.getListRoom());
					
			return "/meetingroom/listroom";
		}
			
		//등록 페이지 이동	
		@GetMapping("/registerroom")
		public String registerRoom(Model model) {
			
			return "/meetingroom/registerroom";
					
		}
			
		//회의실 등록
		@PostMapping("/registerroom")
		public String registerRoom(MeetingRoomVO mr,Model model) {
			
			log.info("registerRoom....");
			service.registerRoom(mr);
		
			return "redirect:/meetingroom/listroom";
					
		}
		
		//컨트롤러가 왜 안되냐구....
		@GetMapping("/readroom")
		public String readRoom(@RequestParam("mr_num") String mr_num, Model model) {
		
		
			model.addAttribute("readroom",service.getRoom(mr_num));
			
			return "/meetingroom/readroom";
		}
		
	 
	 

}
