package org.tetris.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.tetris.domain.tmenu.TmenuVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class TmenuMapperTests {

	@Autowired
	private TmenuMapper mapper;
	
	/*@Test
	public void testGetList() {
		mapper.getList().forEach(tmenu -> log.info(tmenu));
	}*/
	
	/*@Test
	public void testInsert() {
		TmenuVO tmenu = new TmenuVO();
		tmenu.setT_title("qq");
		tmenu.setT_contents("ee");
		tmenu.setT_contents("dd");
		
		mapper.insert(tmenu);
		
		log.info(tmenu);
	}*/
	
	/*@Test
	public void testRead() {
		TmenuVO tmenu = mapper.read(1L);
		log.info(tmenu);
	}*/
	
	/*@Test
	public void testDelete() {
		log.info(mapper.delete(13L));
	}*/
	
	@Test
	public void testInsert() {
		TmenuVO tmenu = new TmenuVO();
		tmenu.setT_num(1L);
		tmenu.setT_title("qq");
		tmenu.setT_contents("ee");
		
		int count = mapper.update(tmenu);
		log.info(count);
	}
	
	
	
	
	
	
	
	
	
	
	
}
