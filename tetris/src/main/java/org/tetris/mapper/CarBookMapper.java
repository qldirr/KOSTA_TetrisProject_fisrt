package org.tetris.mapper;

import java.util.List;

import org.tetris.domain.CarBookVO;

public interface CarBookMapper {
	
	//예약등록
	public void insertResCar(CarBookVO cb);
	//예약 목록 확인
    public List<CarBookVO> getListResCar();
    //내 예약내역 조회
    public CarBookVO readResCar(Long cb_num);   
    //차량예약 승인
    public void carResApp(Long cb_num);


}