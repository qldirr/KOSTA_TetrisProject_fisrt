package org.tetris.mapper;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.tetris.domain.HrVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class HrMapperTest {
	
	@Autowired
	private HrMapper mapper;
	
//	@Test
//	public void testGetHr() {
//		HrVO hr = mapper.getHr("001");
//		log.info(hr);
//	}
	
	//출근테스트
//	@Test
//	public void testInsert() {
//
//		HrVO hr = new HrVO();
//		hr.setE_id("chulsu625");
//		mapper.startDate(hr);
//		
//		log.info(hr);
//	}
	
	//퇴근테스트
//	@Test
//	public void testLeaving() {
//		HrVO hrVO = new HrVO();
//		hrVO.setE_id("chulcu625");
//		
//		mapper.endDate(hrVO);
//		log.info(hrVO);
//	}
	
}
