package org.tetris.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.tetris.domain.Criteria;
import org.tetris.domain.suggestions.SuggestionsVO;
import org.tetris.mapper.SuggestionsMapper;



import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class SuggestionsMapperTests {

	@Autowired
	private SuggestionsMapper mapper;
	
	/*@Test
	public void testGetList() {
		mapper.getList().forEach(suggestions -> log.info(suggestions));
	}*/
	
	/*@Test
	public void testInsert() {
		
		SuggestionsVO suggestions = new SuggestionsVO();
		suggestions.setS_num(5);
		suggestions.setE_id("gdong123");
		suggestions.setS_title("qq건의사항 입니다~~.");
		suggestions.setS_contents("qq주4일제로 바꿔주세요!~~");
		
		mapper.insert(suggestions);
		
		log.info(suggestions);
	}*/
	
	/*@Test
	public void testRead() {
		SuggestionsVO suggestions = mapper.read(1);
		
		log.info(suggestions);
	}*/
	
	/*@Test
	public void testDelete() {
		log.info("delete count: " + mapper.delete(90));
	}*/
	
	@Test
	public void testupdate() {//데이터 수정 테스트
		SuggestionsVO suggestions = new SuggestionsVO();
		suggestions.setS_num(1000);		
		suggestions.setS_title("수정 입니다$$.");
		suggestions.setS_contents("바꿔주세요!!!$$");		
		
		mapper.update(suggestions);
		
		log.info(suggestions);		
	}

	/*@Test
	public void testPaging() {
		Criteria cri = new Criteria();
		
		cri.setPageNum(3);
		cri.setAmount(10);
		
		List<SuggestionsVO> list = mapper.getListWithPaging(cri);
		list.forEach(suggestions -> log.info(suggestions.getS_num()));
	}*/
	
}

















