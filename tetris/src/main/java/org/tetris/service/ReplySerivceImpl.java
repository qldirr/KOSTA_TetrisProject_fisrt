package org.tetris.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tetris.domain.Criteria;
import org.tetris.domain.ReplyVO;
import org.tetris.mapper.NoticeMapper;
import org.tetris.mapper.ReplyMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@AllArgsConstructor
@Log4j
public class ReplySerivceImpl implements ReplyService {

	@Autowired
	private ReplyMapper mapper;
	
	@Override
	public int regeister(ReplyVO vo) {
		log.info("register..." +  vo);
		return mapper.insert(vo);
	}

	@Override
	public ReplyVO get(Long r_num) {
		log.info("get..." +  r_num);
		return mapper.read(r_num);
	}

	@Override
	public int modify(ReplyVO vo) {
		log.info("modify...." +  vo);
		return mapper.update(vo);
	}

	@Override
	public int remove(Long r_num) {
		log.info("remove..." +  r_num);
		return mapper.delete(r_num);
	}

	@Override
	public List<ReplyVO> getList(Criteria cri, Long s_num) {
		log.info("get reply list of a suggestions..." +  s_num);
		return mapper.getListWithPaging(cri, s_num);
	}

}
