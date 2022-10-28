package org.tetris.mapper;

import java.util.List;
import java.util.Map;

import org.tetris.domain.CalendarVO;

public interface CalendarMapper {

	public List<CalendarVO> getList();
	public void insertSelectKey(CalendarVO calendar);
	public CalendarVO read(int cl_num);
	public int delete(int cl_num);
	public int update(CalendarVO calendar);
	
}
