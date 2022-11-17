package org.tetris.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tetris.domain.UserVO;
import org.tetris.domain.project.ProjectBoardVO;
import org.tetris.domain.project.ProjectVO;
import org.tetris.domain.user.DepartmentVO;
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
	public List<ProjectVO> getListProject(String e_id) {
		return mapper.getListProject(e_id);
	}

	@Override
	public void registerProject(ProjectVO project) {
		mapper.insertProject(project);
	}

	@Override
	public List<UserVO> getListEmployees() {
		return mapper.getListEmployees(); 
	}

	@Override
	public List<DepartmentVO> getListDept() {
		return mapper.getListDept();
	}

	@Override
	public void registerProjectMember(String pl_num, String e_id) {
		mapper.insertProjectMember(pl_num, e_id);
		
	}

	@Override
	public void registerProjectList(ProjectVO project) {
		mapper.insertProjectList(project);
	}

	@Override
	public Long getProjectNum(ProjectVO project) {
		return mapper.readProjectNum(project);
	}

	


}
