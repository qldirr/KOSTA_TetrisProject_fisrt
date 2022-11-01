package org.tetris.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
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
import org.tetris.domain.RoomBookVO;
import org.tetris.service.RoomBookService;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/meetingroom/*")
@AllArgsConstructor

public class RoomBookController {
	
	private RoomBookService service;
	
		

	// 회의실예약 등록페이지
	@GetMapping("/registerresroom")
	public String registerRseCar(Model model) {
		// model.addAttribute();

		return "/meetingroom/registerresroom";

	}

	// 회의실예약 등록하기
	@PostMapping("/registerrseroom")
	public String registerRseRoom( RoomBookVO rb, Model model, RedirectAttributes rttr) {
		log.info("registerresroom...........");

		//service.registerResRoom(rb);

		return "redirect:/meetingroom/listresroom";
	}
	

	// 예약된 회의실목록
	@GetMapping("/listresroom")
	public String listResCar(Model model) {

		log.info("listResCar....");
		//model.addAttribute("list", service.getListResRoom());

		return "/meetingroom/listresroom";

	}

	// 예약조회
	
	@GetMapping("/readrescar")
	public String readResCar(@RequestParam("cb_num") String cb_num,Model model) {
		
		//model.addAttribute("rescar",service.readResCar(cb_num));
			
		return "/reservation/readrescar";
		
	}
	
	
	
	
	
	
/*		
	//예약테이블 불러오기
	@GetMapping("/listResRoom")
	@ResponseBody
	public List<RoomBookVO> listResRoom( @RequestBody Map<String,String> paraMap) {
		Map<String,String> paraMap1 = new HashMap<String, String>();
		
		RoomBookVO room = new RoomBookVO();
		String mr_num = room.getMr_num();
	
		paraMap1.put("mr_num",mr_num);

		List<RoomBookVO> resList = service.getListResRoom(paraMap1);
		
		JSONArray jsonArr = new JSONArray();
		
		for (RoomBookVO rbvo : resList) {
			JSONObject jsonObj = new JSONObject();
			jsonObj.put("rb_num", rbvo.getRb_num());
			jsonObj.put("mr_num", rbvo.getMr_num());
			jsonObj.put("e_id", rbvo.getE_id());
			jsonObj.put("rb_startday", rbvo.getRb_startday());
			jsonObj.put("rb_endday", rbvo.getRb_endday());
				
			jsonArr.add(jsonObj);
		}
		
		log.info("jsonArrCheck: {}"+jsonArr);				
		return jsonArr;
				
	}
	
	/*
	 * @GetMapping("/readResRoom")
	 * 
	 * @ResponseBody public List<RoomBookVO> readResRoom( @RequestBody
	 * Map<String,String> paraMap){
	 * 
	 * 
	 * 
	 * 
	 * return List<RoomBookVO>; }
	 * 
	 */
	
}

