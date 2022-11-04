package org.tetris.mapper;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.tetris.domain.CarInfoVO;
import org.tetris.mapper.CarInfoMapper;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class CarInfoMapperTest {

	@Autowired
	private CarInfoMapper mapper;

	/*
	 * @Test public void testInsert() { CarinfoVO ca= new CarinfoVO();
	 * 
	 * ca.setCa_num("C002"); ca.setCa_model("벤츠"); ca.setCa_type("중형세단");
	 * ca.setCa_age("2010");
	 * 
	 * mapper.insertCar(ca); }
	 */

	/*
	 * @Test public void test() { mapper.getListCar().forEach(ca -> log.info(ca)); }
	 * 
	 * 
	 * }
	 */
	
	@Test
	public void testread() {
		String  ca_num ="C001";  			
		CarInfoVO car = mapper.readCar(ca_num);
		log.info(car);
				
	}
	
	
	




}
