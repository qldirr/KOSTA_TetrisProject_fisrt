package org.tetris.service;

import java.util.List;

import org.tetris.domain.HrVO;

public interface HrService {

	public void startDate(HrVO hrVO);
	
	public boolean endDate(HrVO hrVO);
	
	public boolean outDate(HrVO hrVO);
	
	public List<HrVO> getList(long depNo);
	
	public HrVO get(String e_id);
}
