package org.tetris.service;

import java.util.List;
import java.util.Map;

import org.tetris.domain.RoomBookVO;

public interface RoomBookService {

	// 회의실 예약테이블 불러오기 
	public List<RoomBookVO> getListResRoom();

	// 회의실 예약하기(모달창에서 전송누르기)
	public void registerResRoom(RoomBookVO rb);

	// 회의실 예약날짜 중복 확인
	public String checkdate(Map<String, String> paraMap);

	// 내 예약정보 불러오기
	public RoomBookVO getResRoom(Long rb_num);
	
	//회의실별 예약정보 불러오기
	public List<RoomBookVO> setResRoom(String mr_num);

}


