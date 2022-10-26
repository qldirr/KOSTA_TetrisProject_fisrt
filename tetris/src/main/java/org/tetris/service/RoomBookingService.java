package org.tetris.service;

import java.util.List;

import org.tetris.domain.RoomBookVO;

public interface RoomBookingService {
	
	//회의실 예약하기	
	public int register(RoomBookVO vo);
	//회의실 예약진행리스트
	public List<RoomBookVO>getList();
}
