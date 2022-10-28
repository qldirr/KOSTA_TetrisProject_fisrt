package org.tetris.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.tetris.domain.CriteriaVO;
import org.tetris.domain.SuggestionsVO;

import jdk.jshell.SourceCodeAnalysis.Suggestion;

public interface SuggestionsMapper {

	//@Select("select * from Suggestions where s_num > 0")
	
	public List<SuggestionsVO> getList();
	
	///public List<SuggestionsVO> getListWithPaging(CriteriaVO cri);
	
	public void insert(SuggestionsVO suggestions);
	
	//public void insertSelectKey(SuggestionsVO suggestions);
	
	public SuggestionsVO read(long s_num);
	
	public int delete(long s_num);
	
	public int update(SuggestionsVO suggestions);
}
