package org.tetris.service;

import java.util.Date;

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
public class HrServiceTest {
	Date now = new Date();
	
	@Autowired
	private HrService service;
	
//	@Test
//	public void testEndDate()throws {
//		HrVO hr = service.getHr("chulsu625");
//		hr.setHr_leave(now);
//		hr.setE_id("chulsu625");
//		if(hr == null) { return; }
//		
//		log.info(service.endDate(hr));
//	}
	
//	@Test
//	public void test() {
//		service.startDate("jhs123");
//	}

	@Test
	public void testGetList() {
		service.getHrWithPaging(new Criteria(2, 10)).forEach(hr -> log.info(hr));
	}
}
