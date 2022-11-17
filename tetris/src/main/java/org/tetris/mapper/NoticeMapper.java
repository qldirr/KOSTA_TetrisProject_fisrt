package org.tetris.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.tetris.domain.Criteria;
import org.tetris.domain.notice.NoticeVO;
import org.tetris.domain.suggestions.SuggestionsVO;

public interface NoticeMapper {

	//@Select("select * from notice where n_num > 0")
	
	public List<NoticeVO> getList();
	
	public List<NoticeVO> getListWithPaging(Criteria cri);
	
	public void insert(NoticeVO notice);
	
	
	
	public NoticeVO read(long n_num);
	
	public int delete(long n_num);
	
	public int update(NoticeVO notice);

}
