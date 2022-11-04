package org.tetris.service;


import java.util.List;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tetris.domain.RoomBookVO;
import org.tetris.mapper.MeetingRoomMapper;
import org.tetris.mapper.RoomBookMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@AllArgsConstructor
@Log4j
public class RoomBookServicelmpl implements RoomBookService {
	
	@Autowired
	RoomBookMapper mapper;

	@Override
	public List<RoomBookVO> getListResRoom() {
		log.info("list...........");
		return mapper.getListResRoom();
	}

	@Override
	public void registerResRoom(RoomBookVO rb) {
		log.info("register...........");
		mapper.insertResRoom(rb); 
	}

	@Override
	public String checkdate(Map<String, String> paraMap) {
		log.info("");
		return mapper.checkdate(paraMap);
	}

	@Override
	public RoomBookVO getResRoom(Long rb_num) {
		log.info("get");
		return mapper.readResRoom(rb_num);
	}
	
	@Override
	public List<RoomBookVO> setResRoom(String mr_num){
		log.info("set.....");
		
		return mapper.setResRoom(mr_num);

	}
	
	
}
