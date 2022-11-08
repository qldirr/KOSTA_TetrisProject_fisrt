package org.tetris.service;

import java.util.List;

import org.tetris.domain.project.ProjectCalVO;
import org.tetris.domain.project.ProjectTaskVO;

public interface ProjectTaskService {
	
	public List<ProjectTaskVO> getListTask(Long pj_num);
	public void registerTask(ProjectTaskVO task); 
	public void modifyTask(ProjectTaskVO task);
	public void removeTask(Long ts_num);
}
