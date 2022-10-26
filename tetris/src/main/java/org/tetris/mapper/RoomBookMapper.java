package org.tetris.mapper;

import java.util.List;

import org.tetris.domain.RoomBookVO;

public interface RoomBookMapper {
	
	//회의실 예약등록
	public int insertResRoom(RoomBookVO vo);
	//회의실 예약진행리스트
	public List<RoomBookVO> getList();
	//회의실예약날짜 체크
	public int checkdate(RoomBookVO vo);
	

}
