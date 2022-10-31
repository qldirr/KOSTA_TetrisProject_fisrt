package org.tetris.mapper;

import java.util.List;

import org.tetris.domain.HrVO;

public interface HrMapper {

	public HrVO getHr(String e_id);
	
	public List<HrVO> getHrList(String e_id);
	public void startDate(String e_id);
	public int endDate(String e_id);
	
	public int outDate(String e_id);
}
