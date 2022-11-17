package org.tetris.mapper;

import java.util.List;
import java.util.Map;

import org.tetris.domain.calendar.CalendarVO;

public interface CalendarMapper {

	public List<CalendarVO> getList(String e_id);
	public void insertSelectKey(CalendarVO calendar);
	public CalendarVO read(int cl_num);
	public int delete(CalendarVO calendar);
	public int update(CalendarVO calendar);
	
}
