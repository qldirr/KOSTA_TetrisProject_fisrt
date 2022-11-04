package org.tetris.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tetris.domain.project.ProjectMemberVO;
import org.tetris.domain.project.ProjectVO;
import org.tetris.domain.user.UserVO;
import org.tetris.mapper.ProjectMapper;
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

	@GetMapping("/main")
	public void listProject(Model model) {
		UserVO user = new UserVO();
		user.setE_id("gdong123");
		List<ProjectVO> projectList =  service.getListProject(user);
		//해당하는 사용자가 속한 프로젝트 목록
		model.addAttribute("list", projectList);
	}

	@GetMapping("/register")
	public void registerForm() {

	}

	@PostMapping("/register")
	public String registerProject(ProjectVO project, Model model) {
		service.registerProject(project);
		
		model.addAttribute("project", project);
		return "/project/reginfo"; 
	}
	
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
		String pl_num = proMember.getPl_num();
		String e_id = "";
		
		for (int i = 0; i < proMember.getPmembers().size(); i++) {
			e_id = proMember.getPmembers().get(i);
			service.registerProjectMember(pl_num, e_id);
		}

	}

}