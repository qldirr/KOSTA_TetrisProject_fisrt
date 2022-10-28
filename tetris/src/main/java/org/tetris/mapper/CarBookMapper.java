package org.tetris.mapper;

import java.util.List;

import org.tetris.domain.CarBookVO;

public interface CarBookMapper {
	
	public void insertResCar(CarBookVO cb);
    public List<CarBookVO> getListResCar();
    public List<CarBookVO> readResCar();


}
