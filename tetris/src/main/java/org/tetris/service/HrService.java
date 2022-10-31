package org.tetris.service;

import java.util.List;

import org.tetris.domain.HrVO;

public interface HrService {

	//페이지진입시 정보출력
	public HrVO getHr(String e_id);

	//출근하기
	public void startDate(String e_id);
	//퇴근하기
	public void endDate(String e_id);
	
	public boolean outDate(HrVO hrVO);
	
	public List<HrVO> getHrList(String e_id);
	
}
