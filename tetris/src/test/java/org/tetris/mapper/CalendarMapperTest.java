package org.tetris.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.tetris.domain.CalendarVO;
import org.tetris.mapper.CalendarMapper;

import lombok.extern.log4j.Log4j;
import oracle.net.aso.l;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class CalendarMapperTest {

	@Autowired
	private CalendarMapper mapper;
	
	/*@Test
	public void testgetList() {
		mapper.getList("gdong123").forEach(calendar -> log.info(calendar));
	}*/
	
	/*@Test
	public void testInsertSelectKey() {
		CalendarVO calendar = new CalendarVO();
		calendar.setCl_name("운동");
		calendar.setCl_startdate("2022-10-07");
		calendar.setCl_enddate("2022-10-07");
		calendar.setCl_starttime("18:00");
		calendar.setCl_endtime("19:00");
		calendar.setCl_contents(" ");
		calendar.setCl_color("blue");
		calendar.setE_id("gdong123");
		
		mapper.insertSelectKey(calendar);
		
		log.info(calendar);
	}*/
	
	@Test
	public void testRead() {
		CalendarVO calendar = mapper.read(3);
		log.info(calendar);
	}
	
	/*@Test
	public void testUpdate() {
		CalendarVo calendar = new CalendarVo();
		calendar.setCl_num(2);
		calendar.setCl_contents("");
		calendar.setCl_enddate("2022-10-23");
		calendar.setCl_startdate("2022-10-23");
		calendar.setCl_starttime("14:00");
		calendar.setCl_endtime("15:00");
		calendar.setCl_color("yellow");
		calendar.setCl_type("휴식");
		calendar.setCl_name("낚시");
		
		int count = mapper.update(calendar);
		log.info("update count"+count);
	}*/
	
	/*@Test
	public void testDelete() {
		log.info("delete count"+mapper.delete(6));
	}*/
}
