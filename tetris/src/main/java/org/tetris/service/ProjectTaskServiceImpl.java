package org.tetris.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tetris.domain.project.ProjectTaskVO;
import org.tetris.mapper.ProjectTaskMapper;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Service
@NoArgsConstructor
@AllArgsConstructor
public class ProjectTaskServiceImpl implements ProjectTaskService {

	
	@Autowired
	private ProjectTaskMapper mapper;
	
	@Override
	public List<ProjectTaskVO> getListTask(Long pj_num) {
		return mapper.getListTask(pj_num);
	}

	@Override
	public void registerTask(ProjectTaskVO task) {
		mapper.insertTask(task);
	}

	@Override
	public void modifyTask(ProjectTaskVO task) {
		mapper.updateTask(task);
	}

	@Override
	public void removeTask(Long ts_num) {
		mapper.deleteTask(ts_num);
	}

}
