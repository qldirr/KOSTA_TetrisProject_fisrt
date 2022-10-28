package org.tetris.service;

import java.util.List;

import org.tetris.domain.CarInfoVO;

public interface CarInfoService {
	
	public void registerCar(CarInfoVO car);
	public List<CarInfoVO> getListCar();
	

}
