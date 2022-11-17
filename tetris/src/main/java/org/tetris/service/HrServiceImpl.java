
package org.tetris.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.tetris.domain.Criteria;
import org.tetris.domain.attendance.HrVO;
import org.tetris.domain.attendance.HrVO2;
import org.tetris.domain.attendance.VacVO;
import org.tetris.mapper.HrMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.*;

@Service
@AllArgsConstructor
@Log4j
public class HrServiceImpl implements HrService {

	@Setter(onMethod_ = @Autowired)
	private HrMapper hrMapper;
	
	@Override
	public void startDate(String e_id) {
		log.info("startDate..." + e_id);
		
		hrMapper.startDate(e_id);
	}

	@Override
	public void endDate(String e_id) {
		log.info("leaving..." + e_id);
		
		boolean leavingResult = hrMapper.endDate(e_id) == 1;
		
	}

	@Override
	public void outDate(String e_id) {
		hrMapper.outDate(e_id);
	}



	@Override
	public HrVO getHr(String e_id) {
		log.info("getHr ServiceImpl: " + hrMapper.getHr(e_id));
		return hrMapper.getHr(e_id);
	}

	@Override
	public List<HrVO> getHrList(String e_id) {
		log.info("getHrList ServiceImpl: " + hrMapper.getHrList(e_id));
		return hrMapper.getHrList(e_id);
	}

	@Override
	public List<HrVO> getHrAll() {
		log.info("getHrAll ServiceImpl: " + hrMapper.getHrAll());
		return hrMapper.getHrAll();
	}


	@Override
	public List<HrVO> getHrWithPaging(Criteria cri) {
		
		log.info("get List with criteria: " + cri);
		return hrMapper.getHrWithPaging(cri);
	}

	@Override
	public int getTotal(Criteria cri) {
		
		log.info("get total count");
		return hrMapper.getTotalCount(cri);
	}

	@Override
	public List<HrVO> getPersonal(String e_id) {
		return hrMapper.getPersonal(e_id);
	}

	@Override
	public HrVO2 getAttendance(String e_id) {
		return hrMapper.getAttendance(e_id);
	}

	@Override
	public List<VacVO> getVac(String e_id) {
		return hrMapper.getVac(e_id);
	}

	@Override
	public HrVO2 getHrVA(String e_id) {
		return hrMapper.getHrVA(e_id);
	}

	
}
