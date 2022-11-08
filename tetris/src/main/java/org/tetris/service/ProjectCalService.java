package org.tetris.service;

import java.util.List;

import org.tetris.domain.project.ProjectCalVO;

public interface ProjectCalService {
	
	public List<ProjectCalVO> getListCalendar(Long pj_num);
	public void registerCalendar(ProjectCalVO calendar); 

}
