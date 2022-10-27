package org.tetris.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.tetris.domain.HrVO;
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
	public void startDate(HrVO hrVO) {
		log.info("startDate..." + hrVO);
		
		hrMapper.startDate(hrVO);
	}

	@Override
	public void endDate(HrVO hrVO) {
		log.info("leaving..." + hrVO);
		
		boolean leavingResult = hrMapper.endDate(hrVO) == 1;
		
	}

	@Override
	public boolean outDate(HrVO hrVO) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public HrVO getHr(String e_id) {
		return hrMapper.getHr(e_id);
	}

	@Override
	public List<HrVO> HrList(long depNo) {
		// TODO Auto-generated method stub
		return null;
	}


}
