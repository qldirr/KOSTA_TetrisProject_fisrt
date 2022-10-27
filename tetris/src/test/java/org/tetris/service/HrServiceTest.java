package org.tetris.service;

import java.util.Date;

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
public class HrServiceTest {
	Date now = new Date();
	
	@Autowired
	private HrService service;
	
	@Test
	public void testEndDate() {
		HrVO hr = service.getHr("chulsu625");
		hr.setHr_leave(now);
		hr.setE_id("chulsu625");
		if(hr == null) { return; }
		
		log.info("endDate result: " + service.endDate(hr));
	}
}
