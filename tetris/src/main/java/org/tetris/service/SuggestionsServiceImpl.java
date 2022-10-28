package org.tetris.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tetris.domain.SuggestionsVO;
import org.tetris.mapper.SuggestionsMapper;


import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@AllArgsConstructor
@Log4j
public class SuggestionsServiceImpl implements SuggestionsService {

	
	@Autowired
	private SuggestionsMapper mapper;
	
	@Override
	public void register(SuggestionsVO suggestions) {
		
		log.info("register...." + suggestions);
		
		mapper.insert(suggestions);		
		/* mapper.insertSelectKey(suggestions); */

	}

	@Override
	public SuggestionsVO get(Long s_num) {
		
		log.info("get...." + s_num);
		
		return mapper.read(s_num);
	}

	@Override
	public boolean modify(SuggestionsVO suggestions) {
		
		log.info("modify..." + suggestions);
		
		return mapper.update(suggestions) == 1;
	}

	@Override
	public boolean remove(Long s_num) {
		
		log.info("remove... " + s_num);
		
		return mapper.delete(s_num) == 1;
	}

	@Override
	public List<SuggestionsVO> getList() {

		log.info("getList....");
		
		return mapper.getList();
	}

}
