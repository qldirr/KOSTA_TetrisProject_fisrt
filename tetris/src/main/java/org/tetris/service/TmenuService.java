package org.tetris.service;

import java.util.List;

import org.tetris.domain.Criteria;
import org.tetris.domain.suggestions.SuggestionsVO;
import org.tetris.domain.tmenu.TmenuVO;

public interface TmenuService {

	public void regeister(TmenuVO tmenu);
	
	public TmenuVO get(Long t_num);
	
	public boolean modify(TmenuVO tmenu);
	
	public boolean remove(Long t_num);
	
	public List<TmenuVO> getList();


	

}


