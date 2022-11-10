package org.tetris.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.tetris.domain.HrVO;
import org.tetris.domain.SuggestionsVO;
import org.tetris.domain.elecauth.ElecAuthVO;
import org.tetris.domain.project.ProjectVO;
import org.tetris.domain.user.UserVO;
import org.tetris.security.domain.CustomUser;
import org.tetris.service.ElecAuthService;
import org.tetris.service.HrService;
import org.tetris.service.ProjectBoardService;
import org.tetris.service.ProjectService;
import org.tetris.service.SuggestionsService;
import org.tetris.service.UserService;

import jdk.jshell.SourceCodeAnalysis.Suggestion;

/**
 * Handles requests for the application home page.
 */

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
	@Autowired
	private ElecAuthService elecService;
	
	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private ProjectBoardService boardService;
	
	@Autowired
	private SuggestionsService sugService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private HrService hrService;
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model ) {
		//org.tetris.domain.UserVO user = userService.detailUser(e_id);
		//String userId = user.getE_id();
		//CustomUser user = (CustomUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    //String e_id = user.getUsername();
		
		 //HrVO vo= hrService.getHr(e_id);
		 List<ElecAuthVO> list = elecService.getListUncheckedList("gdong123");
		 List<ProjectVO> projectList = projectService.getListProject("gdong123"); //�ش��ϴ� ����ڰ� ����
		 List<UserVO> member = boardService.getProjectInfo("81");
		 List<SuggestionsVO> suglist = sugService.getList();
		 
		// model.addAttribute("hrVO", hrService.getHr(e_id));
		 
		 Long pj_num= 70L;
		 
		 //int taskFinished = boardService.countTaskFinished(pj_num);
		 
		 //model.addAttribute("hrVO",hrVO);
		 model.addAttribute("suglist",suglist);
		 model.addAttribute("list", projectList);
		// model.addAttribute("task", taskFinished);
				
		 model.addAttribute("authlist", list);
		
		return "main";
	}
}