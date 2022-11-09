package org.tetris.service;

import java.util.List;

import org.tetris.domain.Criteria;
import org.tetris.domain.SuggestionsVO;

public interface SuggestionsService {

	public void register(SuggestionsVO suggestions);
	
	public SuggestionsVO get(Long s_num);
	
	public boolean modify(SuggestionsVO suggestions);
	
	public boolean remove(Long s_num);
	
	public List<SuggestionsVO> getList();
	
	public List<SuggestionsVO> getList(Criteria cri);
	
}
