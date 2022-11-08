package org.tetris.mapper;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.tetris.domain.project.ProjectVO;
import org.tetris.domain.user.UserVO;
import org.tetris.service.ProjectServiceTests;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ProjectMapperTests {

	@Autowired
	private ProjectBoardMapper mapper;
	
	@Autowired
	private BoardAttachMapper attachMapper;
/*
	@Test
	public void testListProjectMember() {
		mapper.listAllMember().forEach(member -> log.info(member));
	}

	@Test
	public void testListDept() {
		mapper.listDept().forEach(dept -> log.info(dept));
	}

	@Test
	public void testListProject() {
		UserVO user = new UserVO();
		user.setE_id("gdong123");
		mapper.listProject(user).forEach(list -> log.info(list));
	}
	
	
	@Test
	public void testListProjectBoard() {
		String num = "38";
		mapper.listProjectBoard(num).forEach(list -> log.info(list));
	}
 */	
	/*@Test
	public void testListProjectInfo() {
		Long num = 38L;
		mapper.readProjectInfo(num).forEach(list -> log.info(list));
	}
	
	
	@Test
	public void testAttachList() {
		attachMapper.findByPbnum(48L).forEach(attach -> log.info(attach));
	}*/
	
	@Test
	public void testProjectInfo() {
		
	 log.info(mapper.readProjectInfo("45"));
	}


}
