package org.tetris.mapper;

import java.util.List;

import org.tetris.domain.reservation.MeetingRoomVO;

public interface MeetingRoomMapper {
	
	public void insertRoom(MeetingRoomVO mr);	
	public MeetingRoomVO readRoom(String mr_num);
	public List<MeetingRoomVO> getListRoom();
	
	

}
