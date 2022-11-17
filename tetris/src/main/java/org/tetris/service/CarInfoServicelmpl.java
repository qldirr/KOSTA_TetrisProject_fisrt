package org.tetris.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tetris.domain.reservation.CarInfoVO;
import org.tetris.mapper.CarInfoMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@AllArgsConstructor
@Log4j
public class CarInfoServicelmpl implements CarInfoService {
	
	@Autowired
	private CarInfoMapper mapper;

	@Override
	public void registerCar(CarInfoVO car) {
		log.info("register....."+car);
		mapper.insertCar(car);

	}

	@Override
	public List<CarInfoVO> getListCar() {
		log.info("getList.....");
		return mapper.getListCar();
	}
	
	@Override
	public CarInfoVO getCar(String ca_num) {
		log.info("getcar.....");	
		return mapper.readCar(ca_num);		
	}
	



}
