package org.tetris.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tetris.domain.CalendarVO;
import org.tetris.service.CalendarService;

import com.google.gson.JsonObject;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@AllArgsConstructor
@RequestMapping("/calendar")
public class CalendarController {

	private CalendarService service;
	
	/*@GetMapping("/list")
	@ResponseBody
    public List<Map<String, Object>> list(){
        List<CalendarVO> list = service.getList();
        
        JSONObject jsonObj = new JSONObject();
		JSONArray jsonArr = new JSONArray();
		HashMap<String, Object> hash = new HashMap<>();	

		for(int i=0; i < list.size(); i++) {			
			hash.put("cl_num", list.get(i).getCl_num()); //제목
			hash.put("cl_name", list.get(i).getCl_name()); //시작일자
			hash.put("cl_startdate", list.get(i).getCl_startdate()); //종료일자
			hash.put("cl_enddate", list.get(i).getCl_enddate()); 
			hash.put("cl_type", list.get(i).getCl_type()); 
			hash.put("cl_contents", list.get(i).getCl_contents());
			hash.put("cl_color", list.get(i).getCl_color()); 
			
			
			jsonObj = new JSONObject(hash); //중괄호 {key:value , key:value, key:value}
			jsonArr.add(jsonObj); // 대괄호 안에 넣어주기[{key:value , key:value, key:value},{key:value , key:value, key:value}]
		}
		
		log.info(jsonArr);
		
        return jsonArr;
        
    }*/

	
	
	/*@RequestMapping(value= "/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public String list(){
		List<CalendarVO> list = service.getList();
		
		JSONObject jsonObj = new JSONObject();
		JSONArray jsonArr = new JSONArray();
		HashMap<String, Object> hash = new HashMap<>();	
		
		for(int i=0; i < list.size(); i++) {			
			hash.put("cl_num", list.get(i).getCl_num()); //제목
			hash.put("cl_name", list.get(i).getCl_name()); //시작일자
			hash.put("cl_startdate", list.get(i).getCl_startdate()); //종료일자
			hash.put("cl_enddate", list.get(i).getCl_enddate()); 
			hash.put("cl_type", list.get(i).getCl_type()); 
			hash.put("cl_contents", list.get(i).getCl_contents());
			hash.put("cl_color", list.get(i).getCl_color()); 
			
			
			jsonObj = new JSONObject(hash); //중괄호 {key:value , key:value, key:value}
			jsonArr.add(jsonObj); // 대괄호 안에 넣어주기[{key:value , key:value, key:value},{key:value , key:value, key:value}]
		}
		
		log.info(jsonArr);
		
		return jsonArr.toJSONString();
		
	}*/
	
	/*@GetMapping("/list")
	public void list(Model model) {
		log.info("list..");
		model.addAttribute("list", service.getList());
		
	}*/
}
