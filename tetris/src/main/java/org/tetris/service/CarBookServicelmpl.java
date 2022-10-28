package org.tetris.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tetris.domain.CarBookVO;
import org.tetris.mapper.CarBookMapper;


import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@AllArgsConstructor
@Log4j


public class CarBookServicelmpl implements CarBookService {
	
	@Autowired
	private CarBookMapper mapper;

	@Override
	public void registerRseCar(CarBookVO cb) {
		log.info("register....."+cb);
		mapper.insertResCar(null);

	}

	@Override
	public List<CarBookVO> listResCar() {
		log.info("list......");
		return mapper.getListResCar();
	}

}
