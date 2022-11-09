package org.tetris.mapper;

import java.util.List;

import org.tetris.domain.project.ProjectCalVO;

public interface ProjectCalendarMapper {
	
	public List<ProjectCalVO> readCalendar(Long pj_num);
	public void insertCalendar(ProjectCalVO calendar); 

}
