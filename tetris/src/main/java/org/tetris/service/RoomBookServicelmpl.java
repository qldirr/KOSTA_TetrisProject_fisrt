package org.tetris.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tetris.domain.RoomBookVO;
import org.tetris.mapper.RoomBookMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@AllArgsConstructor
@Log4j
public class RoomBookServicelmpl implements RoomBookService {
	
	@Autowired
	private RoomBookMapper mapper;
	
	
    //회의실 예약테이블 가져오기
	@Override
	public List<RoomBookVO> getListResRoom(Map<String, String> paraMap) {
		log.info("getListResRoom........"+paraMap);
		return mapper.getListResRoom(paraMap);
	}
	
    //회의실 예약등록하기
	@Override
	public int registerResRoom(Map<String, String> paraMap) {
		log.info("regoster....."+paraMap);
		return mapper.insertResRoom(paraMap);
	}
	
    //회의실 예약중복일 체크하기
	@Override
	public int checkdate(Map<String, String> paraMap) {
		log.info("checkdate......."+paraMap);
		
		return mapper.checkdate(paraMap);
	}
	
    //나의 회의실 예약조회하기.
	@Override
	public List<RoomBookVO> getResRoom(Map<String, String> paraMap) {
	    log.info("getResRoom..........."+paraMap);
	    
	    return mapper.readResRoom(paraMap);

	}

}
