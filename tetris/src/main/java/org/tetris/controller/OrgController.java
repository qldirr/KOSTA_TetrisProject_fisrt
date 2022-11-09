package org.tetris.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tetris.domain.UserVO;
import org.tetris.service.OrgService;

import com.google.gson.Gson;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/organization/*")
@AllArgsConstructor
public class OrgController {
	
	@Autowired
	private OrgService service;
	
	@GetMapping("/list")
	public void orgPage(Model model) {
		model.addAttribute("dept", service.listDept());
		model.addAttribute("memberList", service.listAllMember());
	}
	
	@GetMapping(value="/read", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<UserVO> orgRead(Model model, @RequestParam("e_id") String e_id) {
		UserVO user = service.read(e_id);
		if(user != null) {
			return new ResponseEntity<>(user, HttpStatus.OK);
		}
		else {
			return null;
		}
		
	}
}
