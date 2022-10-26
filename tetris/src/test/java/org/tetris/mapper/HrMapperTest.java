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
	
	@Test
	public void testInsert() {
		Calendar now = Calendar.getInstance();
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		HrVO hr = new HrVO();
		hr.setE_id("002");
		hr.setHr_date(sdf1.format(now.getTime()));
		hr.setHr_status("업무중");
		hr.setHr_num(2);
		hr.setHr_note("--");
		
		log.info(hr);
	}
	
}
