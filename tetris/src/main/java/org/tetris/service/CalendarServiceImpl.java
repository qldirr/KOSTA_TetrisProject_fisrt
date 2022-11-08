package org.tetris.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tetris.domain.CalendarVO;
import org.tetris.mapper.CalendarMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class CalendarServiceImpl implements CalendarService {

	@Autowired
	private CalendarMapper mapper;
	
	@Override
	public void register(CalendarVO calendar) {
		log.info("register.."+calendar);
		mapper.insertSelectKey(calendar);

	}

	
	@Override
	public CalendarVO get(int cl_num) {
		log.info("get..."+cl_num);
		return mapper.read(cl_num);
	}

	@Override
	public boolean modify(CalendarVO calendar) {
		log.info("modify..."+calendar);
		return mapper.update(calendar)==1;
	}

	@Override
	public boolean remove(CalendarVO calendar) {
		log.info("remove..."+calendar);
		return mapper.delete(calendar)==1;
	
	}

	@Override
	public List<CalendarVO> getList(String e_id) {
		log.info("getlist...");
		return mapper.getList(e_id);
	}

	

}
