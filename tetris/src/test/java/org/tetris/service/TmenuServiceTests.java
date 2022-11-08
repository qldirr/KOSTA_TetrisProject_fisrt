package org.tetris.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.tetris.domain.TmenuVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class TmenuServiceTests {

	@Autowired
	private TmenuService service;
	
	/*@Test
	public void testRegister() {
		
	TmenuVO tmenu = new TmenuVO();
	tmenu.setT_title("11");
	tmenu.setT_contents("22");
	
	service.regeister(tmenu);
	
	log.info(tmenu.getT_num());
	}*/
	
	/*@Test
	public void testGetList() {
		service.getList().forEach(tmenu -> log.info(tmenu));
	}*/
	
	/*@Test
	public void testGet() {
		log.info(service.get(1L));
	}*/
	
	/*@Test
	public void testDelete() {
		log.info(service.remove(14L));
	}*/
	
	/*@Test
	public void testUpdate() {
		TmenuVO tmenu = service.get(1L);
		
		if(tmenu == null) {
			return;
		}
		
		tmenu.setT_title("1월");
		tmenu.setT_contents("1월 식단표");
		log.info(service.modify(tmenu));
	}*/
	
	
}
