package org.tetris.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.tetris.controller.TmenuController;
import org.tetris.domain.SuggestionsVO;
import org.tetris.domain.TmenuVO;


public interface TmenuMapper {

	//@Select("select * from tmenu where t_num > 0")
	public List<TmenuVO> getList();	
	
	

	public void insert(TmenuVO tmenu);	
	
	
	
	public TmenuVO read(long t_num);

	public int delete(long t_num);
	
	public int update(TmenuVO tmenu);	
	
}
