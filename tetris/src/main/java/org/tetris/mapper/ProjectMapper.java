package org.tetris.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.tetris.domain.project.ProjectVO;
import org.tetris.domain.user.DepartmentVO;
import org.tetris.domain.user.UserVO;

public interface ProjectMapper {

	public void insert(ProjectVO project);
	public void insertProjectMember(@Param("pl_num") String pl_num, @Param("e_id") String e_id);
	public List<DepartmentVO> listDept();
	public List<UserVO> listAllMember();
	public void insertProjectList(ProjectVO project);
	public Long getProjectNum(ProjectVO project);
	public List<ProjectVO> listProject(UserVO user);
	

}
