package org.tetris.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tetris.domain.project.ProjectBoardVO;
import org.tetris.domain.project.ProjectVO;
import org.tetris.domain.user.DepartmentVO;
import org.tetris.domain.user.UserVO;
import org.tetris.mapper.ProjectMapper;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class ProjectServiceImpl implements ProjectService {
	
	@Autowired
	private ProjectMapper mapper; 
	

	@Override
	public List<ProjectVO> listProject(UserVO user) {
		return mapper.listProject(user);
	}

	@Override
	public void register(ProjectVO project) {
		mapper.insert(project);
	}

	@Override
	public List<UserVO> listProjectMember() {
		return mapper.listAllMember(); 
	}

	@Override
	public List<DepartmentVO> listDept() {
		return mapper.listDept();
	}

	@Override
	public void insertProjectMember(String pl_num, String e_id) {
		mapper.insertProjectMember(pl_num, e_id);
		
	}

	@Override
	public void insertProjectList(ProjectVO project) {
		mapper.insertProjectList(project);
	}

	@Override
	public Long getProjectNum(ProjectVO project) {
		return mapper.getProjectNum(project);
	}

	


}
