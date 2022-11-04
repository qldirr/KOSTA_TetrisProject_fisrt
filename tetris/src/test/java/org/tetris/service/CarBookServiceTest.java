package org.tetris.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.tetris.domain.CarBookVO;

import lombok.extern.log4j.Log4j;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class CarBookServiceTest {
	
	@Autowired
	private CarBookService service;

	/*
	 * @Test public void testRegister() { CarBookVO cb = new CarBookVO();
	 * 
	 * cb.setCa_num("C003"); cb.setCb_startday("2022-12-15");
	 * cb.setCb_endday("2022-12-18"); cb.setCb_starttime("12:00");
	 * cb.setCb_endtime("15:00"); cb.setE_id("jsh123");
	 * 
	 * 
	 * service.registerRseCar(cb);
	 * 
	 * 
	 * }
	 */
	/*
	 * @Test public void testread(){ log.info(service.getCar("C001")); }
	 */
	
	
	
}