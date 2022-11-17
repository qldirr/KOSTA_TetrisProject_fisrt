package org.tetris.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.tetris.domain.Criteria;
import org.tetris.domain.project.ProjectTaskVO;

public interface ProjectTaskMapper {
	
	public void insertTask(ProjectTaskVO task);
	public List<ProjectTaskVO> getListTask(Long pj_num);
	public void updateTask(ProjectTaskVO task);
	public void deleteTask(Long ts_num);
	public List<ProjectTaskVO> getListWithPaging(@Param("cri") Criteria cri, @Param("pj_num") Long pj_num);

}
