package org.tetris.mapper;

import java.util.List;

import org.tetris.domain.project.BoardAttachVO;

public interface BoardAttachMapper {
	
	public void insert(BoardAttachVO attach);
	
	public void delete(String uuid);
	
	public List<BoardAttachVO> findByPbnum(Long pj_num);

}
