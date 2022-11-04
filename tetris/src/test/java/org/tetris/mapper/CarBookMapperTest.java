package org.tetris.mapper;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.tetris.domain.CarBookVO;
import org.tetris.mapper.CarBookMapper;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class CarBookMapperTest {

	@Autowired
	private CarBookMapper mapper;

	
	/*
	 * @Test public void test() { mapper.getListResCar().forEach(cb->log.info(cb));
	 * } }
	 */

      @Test public void updatetest() { 
    	  
    	 Long num=3080L;
    	  
	      mapper.carResApp(num);
      }
      
      
      }
	 

	/*
	 * @Test public void testInsert() { CarBookVO cb= new CarBookVO();
	 * 
	 * cb.setCB_NUM(2l);
	 * 
	 * 
	 * 
	 * mapper.insertResCar(cb);}
	 */
	/*
	 * @Test public void testInsert() {
	 * 
	 * CarBookVO cb = new CarBookVO();
	 * 
	 * cb.setCa_num("C002"); cb.setCb_startday("2022-12-15");
	 * cb.setCb_endday("2022-12-18"); cb.setCb_starttime("12:00");
	 * cb.setCb_endtime("15:00"); cb.setE_id("jsh123");
	 * 
	 * mapper.insertResCar(cb);
	 * 
	 * }
	 * 
	 * }
	 */
