package org.tetris.mapper;

import java.util.List;

import org.tetris.domain.HrVO;

public interface HrMapper {

	//사원의 근태정보가져오기 
	public HrVO getHr(String e_id);
	
	public List<HrVO> getList(String date);
	//출퇴근 
	public void startDate(HrVO hrvo);
	//퇴근
	public int endDate(HrVO hrVO);
}
