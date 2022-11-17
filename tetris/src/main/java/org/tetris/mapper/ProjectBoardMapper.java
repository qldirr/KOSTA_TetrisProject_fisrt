package org.tetris.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.tetris.domain.UserVO;
import org.tetris.domain.project.BoardReplyVO;
import org.tetris.domain.project.ProjectBoardVO;
import org.tetris.domain.project.ProjectVO;

public interface ProjectBoardMapper {
	
	public List<UserVO> readProjectInfo(String pl_num);
	public ProjectVO readProject(Long pj_num);
	public List<ProjectBoardVO> getListProjectBoard(HashMap<String, Object> map);
	public void insertProjectBoard(ProjectBoardVO board);
	public void insertReply(BoardReplyVO reply);
	public List<BoardReplyVO> getListReply(@Param("pb_num") Long pb_num, @Param("pj_num") Long pj_num);
	public void deleteReply(Long pr_num);
	public int countTaskFinished(Long pj_num);
}
