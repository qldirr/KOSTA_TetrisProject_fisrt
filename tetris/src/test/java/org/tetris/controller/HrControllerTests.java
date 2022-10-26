package org.tetris.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.tetris.domain.HrVO;
import org.tetris.mapper.HrMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({
	"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})
@Log4j
public class HrControllerTests {
	@Autowired
	private WebApplicationContext ctx;
	
	@Setter(onMethod_ = @Autowired)
	private HrMapper mapper;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
	@Test
	public void testInsert()throws Exception{
		
//		String resultPage = 
//				mockMvc.perform(MockMvcRequestBuilders.post("/attendance/insertAction.do")
//							.param("e_id", "chulsu625")
//							.param("hr_date", "2022-12-24"))
//							.andReturn()
//							.getModelAndView()
//							.getViewName();
//						
//				
//				log.info(resultPage);
		
		HrVO hr = new HrVO();
		hr.setE_id("chulsu625");
		
		mapper.startDate(hr);
		log.info(hr);
	}
	
//	@Test
//	public void testGet()throws Exception{
//		log.info(
//				mockMvc.perform(MockMvcRequestBuilders.get("/tetris/get")
//							.param("e_id", "chulsu625"))
//							.andReturn()
//							.getModelAndView()
//				);
//	}
}
