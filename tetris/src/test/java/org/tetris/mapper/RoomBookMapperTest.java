package org.tetris.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.tetris.domain.RoomBookVO;
import org.tetris.mapper.RoomBookMapper;


import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j

public class RoomBookMapperTest {
	
	@Autowired
	private RoomBookMapper mapper;
	
	@Test
	public void insertResRoom() {
	 Map<String,String> vo= new HashMap();
	 

		
	}

}
