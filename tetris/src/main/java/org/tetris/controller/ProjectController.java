package org.tetris.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tetris.domain.UserVO;
import org.tetris.domain.project.ProjectMemberVO;
import org.tetris.domain.project.ProjectVO;
import org.tetris.mapper.ProjectMapper;
import org.tetris.security.domain.CustomUser;
import org.tetris.service.ElecAuthService;
import org.tetris.service.ProjectBoardService;
import org.tetris.service.ProjectService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/project/*")
@AllArgsConstructor
public class ProjectController {

	@Autowired
	private ProjectService service;

	@Autowired
	private ProjectMapper mapper;
	
	@Autowired
	private ProjectBoardService boardService;
	


	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
	@GetMapping("/main")
	public void listProject(Model model) {
		CustomUser user = (CustomUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String user_name = user.getUser().getE_name();
		String user_id = user.getUsername();
		
		List<ProjectVO> projectList =  service.getListProject(user_id);
		//해당하는 사용자가 속한 프로젝트 목록
		
		List<UserVO> projectMember = new ArrayList<UserVO>();
		List<Integer> task = new ArrayList<Integer>();
		
		for(int i=0; i<projectList.size(); i++) {
			
			projectMember = boardService.getProjectInfo(String.valueOf(projectList.get(i).getPj_num()));
			projectList.get(i).setPj_finishedTask(boardService.countTaskFinished(projectList.get(i).getPj_num()));
			projectList.get(i).setPj_members(projectMember);
		
		}
		
		
		log.info(projectList);
	
	
		model.addAttribute("list", projectList);
	}

	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
	@GetMapping("/register")
	public void registerForm(Model model) {
		
		CustomUser user = (CustomUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String user_name = user.getUser().getE_name();
		
		model.addAttribute("loginedName", user_name);

	}

	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
	@PostMapping("/register")
	public String registerProject(ProjectVO project, Model model) {
		
		CustomUser user = (CustomUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String user_id = user.getUsername();
		
		project.setPj_manager(user_id);
		service.registerProject(project);
		
		model.addAttribute("project", project);
		return "/project/reginfo"; 
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
	@PostMapping("/registerend")
	public String registerProjectEnd(ProjectVO project) {
		Long projectNum = service.getProjectNum(project);
		project.setPj_num(projectNum);
		service.registerProjectList(project);
		
		return "redirect: /project/main";
	}
	

	@GetMapping("/member")
	public void registerProjectMember(Model model) {
		
		model.addAttribute("dept", service.getListDept());
		model.addAttribute("employees", service.getListEmployees());

	}

	@ResponseBody
	@PostMapping("/member")
	public void registerProjectMember(@RequestBody ProjectMemberVO proMember) {
		
		CustomUser user = (CustomUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String user_id = user.getUsername();
		
		String pl_num = user_id;
		String e_id = "";
		
		for (int i = 0; i < proMember.getPmembers().size(); i++) {
			e_id = proMember.getPmembers().get(i);
			service.registerProjectMember(pl_num, e_id);
		}

	}

}