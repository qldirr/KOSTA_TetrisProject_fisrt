package org.tetris.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.tetris.domain.project.ProjectVO;
import org.tetris.domain.user.DepartmentVO;
import org.tetris.domain.user.UserVO;

public interface ProjectMapper {

	public void insertProject(ProjectVO project);
	public void insertProjectMember(@Param("pl_num") String pl_num, @Param("e_id") String e_id);
	public List<ProjectVO> getListProject(@Param("e_id") String e_id);
	public List<DepartmentVO> getListDept();
	public List<UserVO> getListEmployees();
	public void insertProjectList(ProjectVO project);
	public Long readProjectNum(ProjectVO project);
	public void deleteProject(Long pj_num);
	public void updateProject(ProjectVO project);

}
