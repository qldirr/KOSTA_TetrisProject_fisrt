package org.tetris.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tetris.domain.Criteria;
import org.tetris.domain.notice.NoticeVO;
import org.tetris.mapper.NoticeMapper;
import org.tetris.mapper.SuggestionsMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@AllArgsConstructor
@Log4j
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	private NoticeMapper mapper;
	
	@Override
	public void register(NoticeVO notice) {
		
		log.info("register...." + notice);
		
		mapper.insert(notice);	

	}

	@Override
	public NoticeVO get(Long n_num) {

		log.info("get...." + n_num); 
		return mapper.read(n_num);
	}

	@Override
	public boolean modify(NoticeVO notice) {

		log.info("modify...." + notice);
		return mapper.update(notice) == 1;
	}

	@Override
	public boolean remove(Long n_num) {

		log.info("remove...." + n_num);
		return mapper.delete(n_num) ==1;
	}

	@Override
	public List<NoticeVO> getList() {
		log.info("getList.......");
		return mapper.getList();
	}

	@Override
	public List<NoticeVO> getList(Criteria cri) {//페이징 처리
		log.info("get List with criteria" + cri);
		return mapper.getListWithPaging(cri);
	}

}
