package org.tetris.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.tetris.domain.TestVO;
import org.tetris.mapper.TestMapper;
import org.tetris.service.TestService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/tetris/*")
@AllArgsConstructor
public class TestController {
	
	@Autowired
	private TestMapper mapper;
	
	@Autowired
	private TestService service;
	
	
	
	@PostMapping("/test")
	public void register(TestVO vo) {
		service.register(vo);
	}

}
