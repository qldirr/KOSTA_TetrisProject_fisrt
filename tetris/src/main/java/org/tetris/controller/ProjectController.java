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

	@GetMapping("/projectmain")
	public void list(Model model) {
		UserVO user = new UserVO();
		user.setE_id("gdong123");
		List<ProjectVO> list =  service.listProject(user);
		model.addAttribute("list", list);
	}

	@GetMapping("/register")
	public void registerPage() {

	}

	@PostMapping("/register")
	public String register(ProjectVO project, Model model) {
		service.register(project);
		
		model.addAttribute("project", project);
		return "/project/reginfo"; 
	}
	
	@PostMapping("/finalregister")
	public String finalregister(ProjectVO project) {
		Long projectNum = service.getProjectNum(project);
		project.setPj_num(projectNum);
		service.insertProjectList(project);
		
		return "redirect: /project/projectmain";
	}
	

	@GetMapping("/memberReg")
	public void memberRegPage(Model model) {
		model.addAttribute("dept", service.listDept());
		model.addAttribute("memberList", service.listProjectMember());

	}

	@ResponseBody
	@PostMapping("/memberReg")
	public void memberReg(@RequestBody ProjectMemberVO proMember) {
		
		String pl_num = proMember.getPl_num();
		String e_id = "";
		for (int i = 0; i < proMember.getPmembers().size(); i++) {
			e_id = proMember.getPmembers().get(i);
			service.insertProjectMember(pl_num, e_id);
		}

	}

}
