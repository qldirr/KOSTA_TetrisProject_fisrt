package org.tetris.mapper;

import org.tetris.domain.HrVO;

public interface HrMapper {

	//사원의 근태정보가져오기 
	public HrVO getHr(String e_id);
	
	//출퇴근 
	public void startDate(String date);
	
	
}
