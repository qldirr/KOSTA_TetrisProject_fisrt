package org.tetris.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.tetris.domain.elecauth.ElecAuthVO;
import org.tetris.domain.elecauth.ElecLineVO;

public interface ElecAuthMapper {
	
	public void insertElecLine(@Param("l_num") String l_num, @Param("l_seq") String l_seq, @Param("e_id") String e_id);
	public void insertElecAuth(ElecAuthVO auth);
	public void updateElecLine(ElecAuthVO auth);
	public List<ElecLineVO> getListElecLine(String l_num);
	public List<ElecAuthVO> getListElecAuth(String e_id);
	public ElecAuthVO readElecAuth(Long el_num);
	public Long readRecentDoc(String e_id);
	public List<ElecAuthVO> getListUncheckedList(String e_id);
	public void updateElecStatus(ElecLineVO line);
	public List<ElecAuthVO> getListDisapproved(String e_id);
	public void updateElecProcess(@Param("el_status") String el_status, @Param("l_num") String l_num);
	public void updateElecAuth(ElecAuthVO auth);
	public void resetElecLine(String l_num);
	public Long countElecAuthStatus(String l_num);
	public void deleteElecAuth(Long el_num);
	
}
