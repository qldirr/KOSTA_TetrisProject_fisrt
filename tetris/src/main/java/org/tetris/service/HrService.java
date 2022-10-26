package org.tetris.service;

import java.util.List;

import org.tetris.domain.HrVO;

public interface HrService {

	//페이지진입시 정보출력
	public HrVO get(String e_id);

	//출근하기
	public void startDate(HrVO hrVO);
	
	public boolean endDate(HrVO hrVO);
	
	public boolean outDate(HrVO hrVO);
	
	public List<HrVO> getList(long depNo);
	
}
