package org.tetris.mapper;

import java.util.List;

import org.tetris.domain.reservation.CarInfoVO;

public interface CarInfoMapper {
	
    //등록
	public void insertCar(CarInfoVO car);
	//차 목록 
	public List<CarInfoVO> getListCar();
	//특정 차 조회
	public CarInfoVO readCar(String ca_num);

}
