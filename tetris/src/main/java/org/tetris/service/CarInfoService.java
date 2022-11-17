package org.tetris.service;

import java.util.List;

import org.tetris.domain.reservation.CarInfoVO;

public interface CarInfoService {
	
	//등록
	public void registerCar(CarInfoVO car);
	//목록
	public List<CarInfoVO> getListCar();
	//조회
	public CarInfoVO getCar(String ca_num);

}
