package org.tetris.mapper;

import java.util.List;
import java.util.Map;

import org.tetris.domain.RoomBookVO;

public interface RoomBookMapper {

	// 회의실 예약테이블 불러오기(예약진행 페이지)
	public List<RoomBookVO> getListResRoom(Map<String, String> paraMap);

	// 회의실 예약하기(모달창에서 전송누르기)
	public int insertResRoom(Map<String, String> paraMap);

	// 회의실 예약날짜 중복 확인
	public int checkdate(Map<String, String> paraMap);

	// 내 회의실 예약정보 불러오기
	public List<RoomBookVO> readResRoom(Map<String, String> paraMap);
	

}
