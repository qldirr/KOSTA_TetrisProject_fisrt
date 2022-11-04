package org.tetris.service;

import java.util.List;

import org.tetris.domain.project.BoardAttachVO;
import org.tetris.domain.project.BoardReplyVO;
import org.tetris.domain.project.ProjectBoardVO;
import org.tetris.domain.project.ProjectVO;
import org.tetris.domain.user.UserVO;

public interface ProjectBoardService {

	public List<UserVO> getProjectInfo(Long pl_num);
	public List<ProjectBoardVO> getListProjectBoard(Long pj_num);
	public void registerProjectBoard(ProjectBoardVO board);
	public void registerReply(BoardReplyVO reply);
	public List<BoardReplyVO> getListBoardReply(Long pb_num, Long pj_num);
	public void removeReply(Long pr_num);
	public List<BoardAttachVO> getAttachList(Long pj_num);
}
