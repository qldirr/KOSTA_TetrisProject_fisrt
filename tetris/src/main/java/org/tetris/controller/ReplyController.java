package org.tetris.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tetris.domain.Criteria;
import org.tetris.domain.ReplyPageDTO;
import org.tetris.domain.suggestions.ReplyVO;
import org.tetris.service.NoticeService;
import org.tetris.service.ReplyService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/replies/*")
@AllArgsConstructor
public class ReplyController {

	@Autowired
	private ReplyService service;
	
	@PostMapping(value = "/new", 
					consumes = "application/json",
					produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> create(@RequestBody ReplyVO vo){
		log.info("replyVO:" + vo);		
		int insertCount = service.regeister(vo);
		log.info("insertCount: " + insertCount);
		
		return insertCount == 1
					? new ResponseEntity<>("success", HttpStatus.OK)
					: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);		
	}


	@GetMapping(value = "/{r_num}")
	public ResponseEntity<ReplyVO> get(@PathVariable("r_num") Long r_num){
		log.info("get................" + r_num);
		
		return new ResponseEntity<>(service.get(r_num), HttpStatus.OK);
	}

	@RequestMapping(method = { RequestMethod.PUT,
			RequestMethod.PATCH }, value = "/{r_num}", consumes = "application/json", 
			produces = {MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<String> modify(@RequestBody ReplyVO vo, @PathVariable("r_num") Long r_num) {

		vo.setR_num(r_num);

		log.info("rno: " + r_num);
		log.info("modify: " + vo);

		return service.modify(vo) == 1 
				? new ResponseEntity<>("success", HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

	}	
	
	//삭제
	@DeleteMapping("/{r_num}")  
	public ResponseEntity<String> remove(@PathVariable("r_num") Long r_num){
		log.info("remove................"+ r_num);
		
		return service.remove(r_num) == 1
				? new ResponseEntity<>("success", HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);		
	}	
	
	@ResponseBody
	@GetMapping(value = "/pages/{s_num}/{page}",     //페이징 처리
			produces = { 
			MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_UTF8_VALUE })
	public ResponseEntity<List<ReplyVO>> getList(
			@PathVariable("page") int page, 
			@PathVariable("s_num") Long s_num) {

		log.info("getlist...");
		Criteria cri = new Criteria(page, 10);

		log.info(cri);
		List<ReplyVO> list = service.getList(cri, s_num);

		return new ResponseEntity<>(service.getList(cri, s_num), HttpStatus.OK);
	}	

}
