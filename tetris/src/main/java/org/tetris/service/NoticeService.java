package org.tetris.service;

import java.util.List;

import org.tetris.domain.Criteria;
import org.tetris.domain.NoticeVO;
import org.tetris.domain.SuggestionsVO;

public interface NoticeService {

	public void register(NoticeVO notice);
	
	public NoticeVO get(Long n_num);
	
	public boolean modify(NoticeVO notice);
	
	public boolean remove(Long n_num);
	
	public List<NoticeVO> getList();
	
	public List<NoticeVO> getList(Criteria cri);	
}
