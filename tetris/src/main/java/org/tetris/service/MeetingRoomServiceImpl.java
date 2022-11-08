package org.tetris.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tetris.domain.MeetingRoomVO;
import org.tetris.mapper.MeetingRoomMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@AllArgsConstructor
@Log4j

public class MeetingRoomServiceImpl implements MeetingRoomService {
	
	@Autowired
	private MeetingRoomMapper mapper;

	@Override
	public void registerRoom(MeetingRoomVO mr) {
		log.info("registerroom......"+mr);
		
		mapper.insertRoom(mr);	
	}

	@Override
	public MeetingRoomVO getRoom(String mr_num) {
		log.info("getroom....."+mr_num);
		
		return mapper.readRoom(mr_num);
	}

	@Override
	public List<MeetingRoomVO> getListRoom() {
		log.info("getlist.....");
		
		return mapper.getListRoom();
	}

}
