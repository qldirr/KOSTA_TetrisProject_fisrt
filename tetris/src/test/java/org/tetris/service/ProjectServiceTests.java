package org.tetris.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.tetris.mapper.ProjectMapper;

import lombok.extern.log4j.Log4j;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ProjectServiceTests {


	@Autowired
	private ProjectMapper mapper; 


	@Test
	public void testListProjectMember() {
		mapper.getListEmployees().forEach(member -> log.info(member)); 
	}
	
	@Test
	public void testListDept() {
		mapper.getListDept().forEach(dept -> log.info(dept)); 
	}

}
