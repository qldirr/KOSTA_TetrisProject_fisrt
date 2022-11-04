package org.tetris.service;

import java.util.List;

import org.tetris.domain.CarBookVO;


public interface CarBookService {
	public void registerRseCar(CarBookVO car);
	public List<CarBookVO> listResCar();
	public CarBookVO readResCar(Long cb_num);
	public void carResApp(Long cb_num);

}
