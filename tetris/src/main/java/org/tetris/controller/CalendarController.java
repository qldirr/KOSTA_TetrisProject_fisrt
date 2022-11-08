package org.tetris.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tetris.domain.CalendarVO;
import org.tetris.security.domain.CustomUser;
import org.tetris.service.CalendarService;



import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@AllArgsConstructor
@RequestMapping("/calendar")
public class CalendarController {

	@Autowired
	private CalendarService service;
	
	
	
	@GetMapping(value="/list", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void getList() {
		
	}
	
	@GetMapping(value="/listCal", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<List<HashMap<String, Object>>> getCalendarList() {
		CustomUser user = (CustomUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String e_id = user.getUsername(); 
		List<CalendarVO> list = service.getList(e_id);

		log.info(list);

		List<HashMap<String, Object>> calList = new ArrayList<HashMap<String, Object>>();
		HashMap<String, Object> calMap;

		for (int i = 0; i < list.size(); i++) {

			calMap = new HashMap<String, Object>();
			calMap.put("title", list.get(i).getCl_name());
			calMap.put("start", list.get(i).getCl_startdate()+"T"+list.get(i).getCl_starttime());
			calMap.put("end", list.get(i).getCl_enddate()+"T"+list.get(i).getCl_endtime());
			calMap.put("color", list.get(i).getCl_color());
			calMap.put("id", list.get(i).getCl_num());
			calMap.put("groupId", list.get(i).getE_id());
			

			calList.add(calMap);
		}

		log.info(calList);

		return new ResponseEntity<>(calList, HttpStatus.OK);
	}

	@GetMapping("/register")
	public void registerCalForm(Model model) {
		CustomUser user = (CustomUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String e_id = user.getUsername(); 		
		model.addAttribute("e_id",e_id);

	}

	@PostMapping("/register")
	public String registerCal(CalendarVO calendar) {

		service.register(calendar);
		return "redirect: /calendar/list";
	}
	
	@GetMapping("/get")
	public void get(@RequestParam("cl_num") int cl_num, Model model) {
		log.info("get..");
		CalendarVO calendar = service.get(cl_num);
		model.addAttribute("calendar", calendar);
	}
	
	@PostMapping("/modify")
	public String modifyCal(CalendarVO calendarVO) {
		if (service.modify(calendarVO)) {
			log.info("modify..");
		}
		return "redirect: /calendar/list";
	}
	
	/*@PostMapping("/remove")
	public String removeCal(@RequestParam("cl_num") int cl_num) {
		if (service.remove(cl_num)) {
			log.info("remove..");
		}
		return "redirect: /calendar/get";
	}*/
	
	@PostMapping("/remove")
	public String removeCal(CalendarVO calendar) {
		if (service.remove(calendar)) {
			log.info("remove..");
		}
		return "redirect: /calendar/list";
	}

	
}
