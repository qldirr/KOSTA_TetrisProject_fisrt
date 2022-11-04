package org.tetris.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
import org.tetris.domain.MeetingRoomVO;
import org.tetris.domain.RoomBookVO;
import org.tetris.service.MeetingRoomService;
import org.tetris.service.RoomBookService;


import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/meetingroom/*")
@AllArgsConstructor

public class RoomBookController {
	
	@Autowired
	private RoomBookService service;
	
	private MeetingRoomService roomservice;
			
	// 회의실예약 메인페이지
	@GetMapping("/resroommain")
	public void roomMain(Model model) {
		//회원번호
		//회의실정보		
		model.addAttribute("list",roomservice.getListRoom());		
	}
	
	//예약페이지 이동
	@GetMapping("/registerrseroom")
	public void registerRseRoomPage(@RequestParam("mr_num") String mr_num, Model model) {
		
		model.addAttribute("registerrseroom",roomservice.getRoom(mr_num));

	}


	// 회의실예약 등록하기
	@PostMapping("/registerrseroom")
	public String registerRseRoom( RoomBookVO rb, Model model, RedirectAttributes rttr) {
		log.info("registerresroom...........");

		service.registerResRoom(rb);

		return "redirect:/meetingroom/resroommain";
	}
	

	// 예약된 회의실목록
	@GetMapping("/listresroom")
	public String listResRoom(Model model) {

		log.info("listResCar....");
		model.addAttribute("list", service.getListResRoom());

		return "/meetingroom/listresroom";

	}
	

	/*
	 * // 예약조회
	 * 
	 * @GetMapping("/readresroom") public String readResRoom(@RequestParam("rb_num")
	 * Long rb_num,Model model) {
	 * 
	 * log.info("aaaaaaaaaaaa.");
	 * model.addAttribute("readresroom",service.getResRoom(rb_num));
	 * log.info(service.getResRoom(rb_num));
	 * 
	 * return "/meetingroom/readresroom";
	 * 
	 * }
	 */
	
	@GetMapping(value="/resroomcal", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void getResCal(@RequestParam("mr_num") String mr_num, Model model) {		
		model.addAttribute("mr_num",roomservice.getRoom(mr_num));
		log.info("omg.......");
		
					
	}
	
	
	
	//예약목록 불러오기
	@GetMapping(value="/listresroomcal", produces= MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody 
	public ResponseEntity<List<HashMap<String, Object>>> getListResRoom(Model model) {
		
		log.info("omg.......222");

	
		List<RoomBookVO> list = service.setResRoom("RS001");
																																		
		log.info(list);
		
		List<HashMap<String, Object>> resList = new ArrayList<HashMap<String, Object>>();
		
		HashMap<String, Object> resMap;
		
		
		for (int i = 0; i < list.size(); i++) {

			resMap = new HashMap<String, Object>();
			resMap.put("title", list.get(i).getE_id());
			resMap.put("start", list.get(i).getRb_startday()+"T"+list.get(i).getRb_starttime());
			resMap.put("end", list.get(i).getRb_endday()+"T"+list.get(i).getRb_endtime());
			resMap.put("id", list.get(i).getRb_num());
			

			resList.add(resMap);
		}

		log.info(resList);

		return new ResponseEntity<>(resList, HttpStatus.OK);
	}




	/*
	 * @ResponseBody
	 * @GetMapping
	 * public checkResRoom() { 
	 * 
	 * 
	 * int result = 
	 * 
	 * if(result >0) { 
	 * 
	 * 
	 * return "success"; 
	 * 
	 * } return "fail"; 
	 * 
	 * } 
	 * 
	 * 
	 * 
	 * 
	 * }
	 */


}
