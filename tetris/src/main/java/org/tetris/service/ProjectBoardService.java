package org.tetris.service;

import java.util.List;

import org.tetris.domain.project.BoardAttachVO;
import org.tetris.domain.project.BoardReplyVO;
import org.tetris.domain.project.ProjectBoardVO;

public interface ProjectBoardService {

	public List<String> getProjectInfo(Long pl_num);
	public List<ProjectBoardVO> listProjectBoard(Long pl_num);
	public void insertProjectBoard(ProjectBoardVO board);
	public void insertReply(BoardReplyVO reply);
	public List<BoardReplyVO> listBoardReply(Long pb_num, Long pj_num);
	public void deleteReply(Long pr_num);
	public List<BoardAttachVO> getAttachList(Long pj_num);
}
