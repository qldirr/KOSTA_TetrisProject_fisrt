package org.tetris.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({ "file:src/main/webapp//WEB-INF/spring/root-context.xml",
		"file:src/main/webapp//WEB-INF/spring/appServlet/servlet-context.xml" })

@Log4j

public class CareBookControllerTest {
	
	@Autowired
	private WebApplicationContext ctx;

	private MockMvc mockMvc;// 가상의 톰캣

	@Before // 테스트 케이스 시작전 각각 호출
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
		log.info("complete setup");

	}
	
	
	 @org.junit.Test 
	 public void testList()throws Exception {
	  mockMvc.perform(get("/carbook/listResCar"));
	  
	  }
	 
	 

	
	
	
	
}
