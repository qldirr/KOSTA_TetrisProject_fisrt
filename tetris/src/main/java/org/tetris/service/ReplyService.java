package org.tetris.service;

import java.util.List;

import org.tetris.domain.Criteria;
import org.tetris.domain.suggestions.ReplyVO;

public interface ReplyService {

	public int regeister(ReplyVO vo);
	
	public ReplyVO get(Long r_num);
	
	public int modify(ReplyVO vo);
	
	public int remove(Long r_num);
	
	public List<ReplyVO> getList(Criteria cri, Long s_num);
}
