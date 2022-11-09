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
		mapper.insertResCar(cb);

	}

	@Override
	public List<CarBookVO> listResCar() {
		log.info("list......");
		return mapper.getListResCar();
	}
	
	@Override
	public CarBookVO readResCar(Long cb_num){	
		log.info("readrescar.....");
		return mapper.readResCar(cb_num);
	}
	@Override
	public void carResApp(Long cb_num) {
		
	     mapper.carResApp(cb_num);
	}
	

}
