package org.tetris.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.tetris.domain.calendar.CalendarVO;
import org.tetris.mapper.CalendarMapperTest;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class CalendarServiceTest {
	@Autowired
	private CalendarService service;
	
	/*@Test
	public void testRegister() {
		CalendarVo calendar = new CalendarVo();
		calendar.setCl_name("운동");
		calendar.setCl_startdate("2022-10-06");
		calendar.setCl_enddate("2022-10-06");
		calendar.setCl_starttime("18:00");
		calendar.setCl_endtime("19:00");
		calendar.setCl_type("개인");
		calendar.setCl_contents(" ");
		calendar.setCl_color("red");
		calendar.setE_id("gdong123");
		
		service.register(calendar);
		
		log.info("생성된 번호"+calendar.getCl_num());
	}*/
	
	/*@Test
	public void testGetlist() {
		service.getList("gdong123").forEach(calendar -> log.info(calendar));
	}*/
	
	/*@Test
	public void testGet() {
		log.info(service.get(3));
	}*/
	
	/*@Test
	public void testModify() {
		CalendarVO calendar = service.get(6);
		
		if (calendar == null) {
			return;
		}
		
		calendar.setCl_name("저녁약속");
		log.info("modify result.."+service.modify(calendar));
	}*/
	
	/*@Test
	public void testRemove() {
		log.info("modify result.."+service.remove(5));
	}*/
}
