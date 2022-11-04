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
	
	public List<ProjectVO> getListProject(UserVO user);
	public void registerProject(ProjectVO project);
	public List<UserVO> getListEmployees();
	public List<DepartmentVO> getListDept();
	public void registerProjectMember(String pl_num, String e_id);
	public void registerProjectList(ProjectVO project);
	public Long getProjectNum(ProjectVO project);
	
}
