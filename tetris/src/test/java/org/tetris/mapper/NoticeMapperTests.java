package org.tetris.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.tetris.domain.NoticeVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class NoticeMapperTests {

	@Autowired
	private NoticeMapper mapper;
	
	/*@Test
	public void testGetList() {
		mapper.getList().forEach(notice -> log.info(notice));
	}*/
	
	/*@Test
	public void testInsert() {
		
		NoticeVO notice = new NoticeVO();
		notice.setE_id("gdong123");
		notice.setN_title("공지사항 입니다.");
		notice.setN_contents("공지사항 내용");
		
		mapper.insert(notice);
		
		log.info(notice);
	}*/
	
	/*@Test
	public void testRead() {
	
	NoticeVO notice = mapper.read(1L);
	
	log.info(notice);
	
	}*/
	
	/*@Test
	public void testDelete() {
		log.info("delete count: " + mapper.delete(3L));
	}*/
	
	/*@Test
	public void testupdate() {
		NoticeVO notice = new NoticeVO();
		notice.setN_num(1);
		notice.setN_title("수정");
		notice.setN_contents("수정");
		
		mapper.update(notice);
		
	}*/	
	
	
	
	
}






















