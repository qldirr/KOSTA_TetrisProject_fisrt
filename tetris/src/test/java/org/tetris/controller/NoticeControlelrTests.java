package org.tetris.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({
	"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})
@Log4j
public class NoticeControlelrTests {

	@Autowired
	private WebApplicationContext ctx;

	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
	/*@Test
	public void testList() throws Exception{
		
		log.info(
			mockMvc.perform(MockMvcRequestBuilders.get("/notice/list"))
			.andReturn()
			.getModelAndView()
			.getModelMap());
		
	}	*/
	
	/*@Test
	public void testRegister()throws Exception{
		
		String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/notice/register")
			.param("e_id", "gdong123")
			.param("n_title", "테스트 새글 제목")
			.param("n_contents", "테스트 새글 내용")
				).andReturn().getModelAndView().getViewName();
		
		log.info(resultPage);		
	}*/
	
	/*@Test
	public void testGet() throws Exception{
		
		log.info(mockMvc.perform(MockMvcRequestBuilders
				.get("/notice/get")
				.param("n_num", "4"))
				.andReturn()
				.getModelAndView().getModelMap());	
		}*/
	
	@Test
	public void testModify() throws Exception {
	
		String resultPage = mockMvc
				.perform(MockMvcRequestBuilders.post("/notice/modify")
					.param("n_num", "8")
					.param("n_title", "수정된 테스트 새글 제목")
					.param("n_contents", "수정된 테스트 새글 내용"))
					
				.andReturn().getModelAndView().getViewName();
		log.info(resultPage);
		}
	
	/*@Test
	public void testRemove() throws Exception {	
	
		String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/notice/remove/")
				.param("n_num", "4")
				).andReturn().getModelAndView().getViewName();
		
		log.info(resultPage);
	
	}	*/
}



















