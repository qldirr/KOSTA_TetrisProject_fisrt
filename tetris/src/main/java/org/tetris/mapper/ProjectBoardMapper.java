package org.tetris.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.tetris.domain.project.BoardReplyVO;
import org.tetris.domain.project.ProjectBoardVO;
import org.tetris.domain.project.ProjectVO;
import org.tetris.domain.user.UserVO;

public interface ProjectBoardMapper {
	
	public List<UserVO> readProjectInfo(Long pl_num);
	public List<ProjectBoardVO> getListProjectBoard(Long pj_num);
	public void insertProjectBoard(ProjectBoardVO board);
	public void insertReply(BoardReplyVO reply);
	public List<BoardReplyVO> getListReply(@Param("pb_num") Long pb_num, @Param("pj_num") Long pj_num);
	public void deleteReply(Long pr_num);
}
