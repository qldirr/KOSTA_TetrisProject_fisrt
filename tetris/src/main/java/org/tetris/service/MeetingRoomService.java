package org.tetris.service;

import java.util.List;

import org.tetris.domain.MeetingRoomVO;

public interface MeetingRoomService {
	public void registerRoom(MeetingRoomVO mr);	
	public MeetingRoomVO getRoom(String mr_num);
	public List<MeetingRoomVO> getListRoom();
}
	

