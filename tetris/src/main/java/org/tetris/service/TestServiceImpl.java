package org.tetris.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tetris.domain.TestVO;
import org.tetris.mapper.TestMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TestServiceImpl implements TestService {
	
	@Autowired
	private TestMapper mapper;

	@Override
	public void register(TestVO vo) {
		mapper.insert(vo);
	}

}
