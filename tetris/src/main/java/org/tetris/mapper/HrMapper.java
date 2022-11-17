package org.tetris.mapper;

import java.util.List;

import org.tetris.domain.Criteria;
import org.tetris.domain.attendance.HrVO;
import org.tetris.domain.attendance.HrVO2;
import org.tetris.domain.attendance.VacVO;

public interface HrMapper {

	public HrVO getHr(String e_id);
	
	public List<HrVO> getHrList(String e_id);
	public void startDate(String e_id);
	public int endDate(String e_id);
	
	public int outDate(String e_id);
	
	public List<HrVO> getHrAll();
	
	public List<HrVO> getHrWithPaging(Criteria cri);
	
	public int getTotalCount(Criteria cri);
	
	public List<HrVO> getPersonal(String e_id);
	
	public HrVO2 getAttendance(String e_id);
	
	public List<VacVO> getVac(String e_id);
	
	public HrVO2 getHrVA(String e_id);
}
