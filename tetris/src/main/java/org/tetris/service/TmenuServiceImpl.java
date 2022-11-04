package org.tetris.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tetris.domain.TmenuVO;
import org.tetris.mapper.SuggestionsMapper;
import org.tetris.mapper.TmenuMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
@Service
@AllArgsConstructor
@Log4j
public class TmenuServiceImpl implements TmenuService {

	@Autowired
	private TmenuMapper mapper;	
	
	@Override
	public void regeister(TmenuVO tmenu) {
		log.info(tmenu);
		mapper.insert(tmenu);
	}

	@Override
	public TmenuVO get(Long t_num) {
		log.info(t_num);
		return mapper.read(t_num);
	}

	@Override
	public boolean modify(TmenuVO tmenu) {
		log.info("modify..." + tmenu);
		return mapper.update(tmenu) == 1;
	}

	@Override
	public boolean remove(Long t_num) {
		log.info("remove... " + t_num);
		return mapper.delete(t_num) == 1;
	}	
	
	
	@Override
	public List<TmenuVO> getList() {
		log.info("getList....");
		return mapper.getList();
	}



}











