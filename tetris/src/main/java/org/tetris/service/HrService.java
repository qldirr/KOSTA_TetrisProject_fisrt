package org.tetris.service;

import java.util.List;

import org.tetris.domain.HrVO;

public interface HrService {

	public HrVO getHr(String e_id);

	public void startDate(String e_id);

	public void endDate(String e_id);
	
	public void outDate(String e_id);
	
	public List<HrVO> getHrList(String e_id);
	
	//personAll.jsp
	public List<HrVO> getHrAll();
	
}
