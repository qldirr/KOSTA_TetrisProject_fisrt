package org.tetris.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.tetris.domain.project.BoardReplyVO;
import org.tetris.domain.project.ProjectBoardVO;

public interface ProjectBoardMapper {
	
	public List<String> getProjectInfo(Long pl_num);
	public List<ProjectBoardVO> listProjectBoard(Long pl_num);
	public void insertProjectBoard(ProjectBoardVO board);
	public void insertReply(BoardReplyVO reply);
	public List<BoardReplyVO> listReply(@Param("pb_num") Long pb_num, @Param("pj_num") Long pj_num);
	public void deleteReply(Long pr_num);
}
