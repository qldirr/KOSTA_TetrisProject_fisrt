package org.tetris.mapper;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.tetris.domain.Criteria;
import org.tetris.domain.attendance.HrVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class HrMapperTest {
	
	@Autowired
	private HrMapper mapper;
	
	@Test
	public void testSearch() {
		
		Criteria cri = new Criteria();
//		cri.setD_num("02");
//		cri.setE_name("철");
//		cri.setType("NDE");	
		
		List<HrVO> list = mapper.getHrWithPaging(cri);
		
		list.forEach(hr -> log.info(hr));
	}
	
//	@Test
//	public void testPaging() {
//		Criteria cri = new Criteria();
//		cri.setPageNum(3);
//		cri.setAmount(10);
//		List<HrVO> list = mapper.getHrWithPaging(cri);
//		list.forEach(hr -> log.info(hr.getHr_num()));
//	}
	
//	@Test
//	public void testGetHr() {
//		HrVO hr = mapper.getHr("001");
//		log.info(hr);
//	}
	
	//�빊�뮄�젏占쎈�믭옙�뮞占쎈뱜
//	@Test
//	public void testInsert() {
//		
//		
//		HrVO hr = mapper.startDate("jhs123");
//		log.info(hr);
//	}
	
	//占쎈닚域뱀눛�믭옙�뮞占쎈뱜
//	@Test
//	public void testLeaving() {
//		HrVO hrVO = new HrVO();
//		hrVO.setE_id("chulsu625");
//		
//		mapper.endDate(hrVO);
//		log.info(hrVO);
//	}
	
}
