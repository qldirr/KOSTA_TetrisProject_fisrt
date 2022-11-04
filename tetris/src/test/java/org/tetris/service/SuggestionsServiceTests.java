package org.tetris.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.tetris.domain.Criteria;
import org.tetris.domain.SuggestionsVO;

import jdk.jshell.SourceCodeAnalysis.Suggestion;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class SuggestionsServiceTests {

	@Autowired
	private SuggestionsService service;
	
	/*@Test
	public void textExist() {
		
		log.info(service);
		assertNotNull(service);
		
	}*/
	
	/*@Test
	public void testRegister() {
		SuggestionsVO suggestion = new SuggestionsVO();
		suggestion.setS_num(111);
		suggestion.setE_id("작성자");
		suggestion.setS_title("새로 작성하는 글");
		suggestion.setS_contents("새로 작성하는 내용");
		
		service.register(suggestion);
	}*/
	
	/*@Test
	public void testGetList() {
		service.getList().forEach(suggestions -> log.info(suggestions));
	}*/
	
	/*@Test
	public void testGet() {
	log.info(service.get(5L));		
	}*/
	
	/*@Test
	public void testDelete() {
		log.info("remove result: " + service.remove(3L));
	}*/
	
	/*@Test
	public void testUpdate() {
		SuggestionsVO suggestions = service.get(5L);
		
		if(suggestions == null) {
			return;
		}
		
		suggestions.setS_title("졔목 수정합니다");
		log.info("modify result: " + service.modify(suggestions));
		
	}*/

	@Test
	public void testGetList() {
		service.getList(new Criteria(2,10)).forEach(Suggestion -> log.info(Suggestion));
	}
	
	
	
	
};




