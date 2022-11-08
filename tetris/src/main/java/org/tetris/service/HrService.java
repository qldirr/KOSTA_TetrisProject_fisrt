package org.tetris.service;

import java.util.List;

import org.tetris.domain.Criteria;
import org.tetris.domain.HrVO;
import org.tetris.domain.HrVO2;
import org.tetris.domain.VacVO;

public interface HrService {

	public HrVO getHr(String e_id);

	public void startDate(String e_id);

	public void endDate(String e_id);
	
	public void outDate(String e_id);
	
	public List<HrVO> getHrList(String e_id);
	
	//personAll.jsp

	public List<HrVO> getHrAll();

	public List<HrVO> getHrWithPaging(Criteria cri);
	
	public int getTotal(Criteria cri);
	
	public List<HrVO> getPersonal(String e_id);
	
	public HrVO2 getAttendance(String e_id);
	
	public List<VacVO> getVac(String e_id);
	public HrVO2 getHrVA(String e_id);
	
}
