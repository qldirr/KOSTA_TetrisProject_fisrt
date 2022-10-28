package org.tetris.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.tetris.domain.project.ProjectBoardVO;
import org.tetris.domain.project.ProjectMemberVO;
import org.tetris.domain.project.ProjectVO;
import org.tetris.domain.user.DepartmentVO;
import org.tetris.domain.user.UserVO;


public interface ProjectService {
	
	public List<ProjectVO> listProject(UserVO user);
	public void register(ProjectVO project);
	public List<UserVO> listProjectMember();
	public List<DepartmentVO> listDept();
	public void insertProjectMember(String pl_num, String e_id);
	public void insertProjectList(ProjectVO project);
	public Long getProjectNum(ProjectVO project);
	
}
