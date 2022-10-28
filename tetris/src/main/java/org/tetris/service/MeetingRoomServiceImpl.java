package org.tetris.service;

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
	public void register(MeetingRoomVO mr) {
		log.info("register...."+mr);
		
		mapper.insertRoom(mr);
		
	}

}
