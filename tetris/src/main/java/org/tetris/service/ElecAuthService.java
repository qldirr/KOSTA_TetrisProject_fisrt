package org.tetris.service;

import java.util.List;

import org.tetris.domain.elecauth.ElecAuthVO;
import org.tetris.domain.elecauth.ElecLineVO;

public interface ElecAuthService {
	
	public void registerElecLine(String l_num,  String l_seq, String e_id);
	public void registerElecAuth(ElecAuthVO auth);
	public void modifyElecLine(ElecAuthVO auth);
	public List<ElecLineVO> getListElecLine(String l_num);
	public List<ElecAuthVO> getListElecAuth(String e_id);
	public ElecAuthVO getElecAuth(Long el_num);
	public Long getRecentDoc(String e_id);
	public List<ElecAuthVO> getListUncheckedList(String e_id);
	public void modifyElecLine(ElecLineVO line);
	public List<ElecAuthVO> getListDisapproved(String e_id);
	public void modifyElecProcess(String el_status, String l_num);
	public void modifyElecAuth(ElecAuthVO auth);
	public void resetElecLine(String l_num);
	public Long checkElecAuthStatus(String l_num);
	public void removeElecAuth(Long el_num);
	public List<ElecAuthVO> sendList(String e_id);
	public List<ElecAuthVO> getList(String e_id);
	public int countListUncheckedList(String e_id);
	public int countListProceeding(String e_id);
	public int countListDisapproved(String e_id);
}
