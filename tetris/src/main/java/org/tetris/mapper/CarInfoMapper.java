package org.tetris.mapper;

import java.util.List;

import org.tetris.domain.CarInfoVO;

public interface CarInfoMapper {
	

	public void insertCar(CarInfoVO car);
	public List<CarInfoVO> getListCar();

}
