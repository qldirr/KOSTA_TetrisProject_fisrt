package org.tetris.mapper;

import org.tetris.domain.MeetingRoomVO;

public interface MeetingRoomMapper {
	
	public void insertRoom(MeetingRoomVO mr);	
	public MeetingRoomVO read(String mr_num);
	
	

}
