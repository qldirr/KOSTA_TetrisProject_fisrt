package org.tetris.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tetris.domain.project.BoardAttachVO;
import org.tetris.domain.project.BoardReplyVO;
import org.tetris.domain.project.ProjectBoardVO;
import org.tetris.mapper.BoardAttachMapper;
import org.tetris.mapper.ProjectBoardMapper;
import org.tetris.mapper.ProjectMapper;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Service
@NoArgsConstructor
@AllArgsConstructor
public class ProjectBoardServiceImpl implements ProjectBoardService {

	@Autowired
	private ProjectBoardMapper mapper;
	
	@Autowired
	private BoardAttachMapper attachMapper;
	
	@Override
	public List<String> getProjectInfo(Long pl_num) {
		return mapper.getProjectInfo(pl_num);
	}

	@Override
	public List<ProjectBoardVO> listProjectBoard(Long pl_num) {
		return mapper.listProjectBoard(pl_num);
	}
	
	
	@Transactional
	@Override
	public void insertProjectBoard(ProjectBoardVO board) {
		mapper.insertProjectBoard(board);
		if(board.getAttachList() == null || board.getAttachList().size() <= 0) {
			return;
		}
		
		board.getAttachList().forEach(attach->{
			attach.setPb_num(board.getPb_num());
			attachMapper.insert(attach);
		});
	}

	@Override
	public void insertReply(BoardReplyVO reply) {
		mapper.insertReply(reply);
		
	}

	@Override
	public List<BoardReplyVO> listBoardReply(Long pb_num, Long pj_num) {
		return mapper.listReply(pb_num, pj_num);
	}

	@Override
	public void deleteReply(Long pr_num) {
		mapper.deleteReply(pr_num);
	}

	@Override
	public List<BoardAttachVO> getAttachList(Long pj_num) {
		return attachMapper.findByPbnum(pj_num);
	}
	
}
