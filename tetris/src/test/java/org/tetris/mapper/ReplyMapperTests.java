package org.tetris.mapper;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.tetris.domain.Criteria;
import org.tetris.domain.suggestions.ReplyVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyMapperTests {

	@Autowired
	private ReplyMapper mapper;
	
	/*@Test
	public void testMapper() {
		log.info(mapper);
	}*/
	
	private Long[] s_numArr = {210L, 203L, 202L, 201L, 200L}; 
	
	@Test
	public void testCreate() {//댓글 삽입 테스트
		IntStream.rangeClosed(1, 10).forEach(i -> {
			ReplyVO vo = new ReplyVO();
			vo.setS_num(s_numArr[i%5]);
			vo.setR_reply("댓글 테스트" + i);
			vo.setR_replyer("replyer" + i);
			
			mapper.insert(vo);
		});
	}
	
	@Test
	public void teatMapper() {
		log.info(mapper);
	}
	
	/*@Test
	public void testRead() {
		Long targetn_num = 1L;
		ReplyVO vo = mapper.read(targetn_num);
		log.info(vo);
	}*/
	
	/*@Test
	public void testDelete() {
		Long targetr_num = 1L;
		mapper.delete(targetr_num);
	}*/
	
	/*@Test
	public void testUpdate() {
		Long targetr_num = 10L;
		ReplyVO vo = mapper.read(targetr_num);
		vo.setR_reply("update reply:");
		int count = mapper.update(vo);
		log.info("update count" + count);
	}*/
	
	/*@Test
	public void testList() {
		Criteria cri = new Criteria();
		List<ReplyVO> replies = mapper.getListWithPaging(cri, s_numArr[0]);
		replies.forEach(reply -> log.info(reply));
	}*/
	
	
	
}
























