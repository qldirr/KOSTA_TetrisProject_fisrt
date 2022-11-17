package org.tetris.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.tetris.domain.notice.NoticeVO;
import org.tetris.domain.suggestions.SuggestionsVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class NoticeServiceTests {

	@Autowired
	private NoticeService service;
	
	/*@Test
	public void testExist() {
		
		log.info(service);
		assertNotNull(service);
	}*/
	
	/*@Test
	public void testRegister() {//데이터 삽입 서비스
		NoticeVO notice = new NoticeVO();
		notice.setE_id("gdong123");
		notice.setN_title("새로 작성");
		notice.setN_contents("새로 작성하는 내용");
		
		service.register(notice);
	}	*/
	
	/*@Test
	public void testGetList() {
		service.getList().forEach(notice -> log.info(notice));
	}*/
	
	/*@Test
	public void testGet() {
		log.info(service.get(1L));
	}*/
	
	/*@Test
	public void testDelete() {
		log.info("remove result: " + service.remove(2L));
	}*/
	
	/*@Test
	public void testUpdate() {
		NoticeVO notice = service.get(1L);
		
		if(notice == null) {
			return;
		}
		
	}*/
	
}

















