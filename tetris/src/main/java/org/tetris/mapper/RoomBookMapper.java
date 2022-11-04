package org.tetris.mapper;

import java.util.List;
import java.util.Map;

import org.tetris.domain.RoomBookVO;

public interface RoomBookMapper {

	// 회의실 예약테이블 불러오기(예약진행 페이지)
	public List<RoomBookVO> getListResRoom();

	// 회의실 예약하기(모달창에서 전송누르기)
	public void insertResRoom(RoomBookVO rb);

	// 회의실 예약날짜 중복 확인
	public String checkdate(Map<String, String> paraMap);

	// 내 예약정보 불러오기
	public RoomBookVO readResRoom(Long rb_num);
	
	//회의실별 예약날짜
	public List<RoomBookVO> setResRoom(String mr_num);
		
		
}

