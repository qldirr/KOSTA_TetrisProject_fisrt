package org.tetris.mapper;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.tetris.domain.reservation.MeetingRoomVO;
import org.tetris.mapper.MeetingRoomMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class MeetingRoomMapperTest {

	@Autowired
	private MeetingRoomMapper mapper;

	@Test
	public void test() { // DBpool.Mybatis,DB 
		MeetingRoomVO mr = new
		MeetingRoomVO();
		mr.setMr_num("RS003");
		mr.setMr_name("날라가서");
		mr.setMr_total("88명");

		mapper.insertRoom(mr);
	}

}
