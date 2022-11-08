package org.tetris.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tetris.domain.project.ProjectCalVO;
import org.tetris.mapper.ProjectCalendarMapper;



@Service
public class ProjectCalSerivceImpl implements ProjectCalService {

	
	@Autowired
	private ProjectCalendarMapper mapper;
	
	@Override
	public List<ProjectCalVO> getListCalendar(Long pj_num) {
		return mapper.readCalendar(pj_num);
	}

	@Override
	public void registerCalendar(ProjectCalVO calendar) {
		mapper.insertCalendar(calendar);
	}

}
