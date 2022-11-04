package org.tetris.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tetris.domain.elecauth.ElecAuthVO;
import org.tetris.domain.elecauth.ElecLineVO;
import org.tetris.mapper.BoardAttachMapper;
import org.tetris.mapper.ElecAuthMapper;
import org.tetris.mapper.ProjectBoardMapper;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Service
@NoArgsConstructor
@AllArgsConstructor
public class ElecAuthServiceImpl implements ElecAuthService {

	@Autowired
	private ElecAuthMapper mapper;
	
	@Override
	public void registerElecLine(String l_num,  String l_seq, String e_id) {
		mapper.insertElecLine(l_num, l_seq, e_id);
	}

	@Override
	public void registerElecAuth(ElecAuthVO auth) {
		mapper.insertElecAuth(auth);
		
	}

	@Override
	public void modifyElecLine(ElecAuthVO auth) {
		mapper.updateElecLine(auth);
		
	}

	@Override
	public List<ElecLineVO> getListElecLine(String l_num) {
		return mapper.getListElecLine(l_num);
	}

	@Override
	public List<ElecAuthVO> getListElecAuth(String e_id) {
		return mapper.getListElecAuth(e_id);
	}

	@Override
	public ElecAuthVO getElecAuth(Long el_num) {
		return mapper.readElecAuth(el_num);
	}

	@Override
	public Long getRecentDoc(String e_id) {
		return mapper.readRecentDoc(e_id);
	}

	@Override
	public List<ElecAuthVO> getListUncheckedList(String e_id) {
		return mapper.getListUncheckedList(e_id);
	}

	@Override
	public void modifyElecLine(ElecLineVO line) {
		mapper.updateElecStatus(line);
		
	}

	@Override
	public List<ElecAuthVO> getListDisapproved(String e_id) {
		return mapper.getListDisapproved(e_id);
	}

	@Override
	public void modifyElecProcess(String el_status, String l_num) {
		mapper.updateElecProcess(el_status, l_num);
	}

	@Override
	public void modifyElecAuth(ElecAuthVO auth) {
		mapper.updateElecAuth(auth);
	}
	
	@Override
	public void resetElecLine(String l_num) {
		mapper.resetElecLine(l_num);
	}

	@Override
	public Long checkElecAuthStatus(String l_num) {
		return mapper.countElecAuthStatus(l_num);
	}

	@Override
	public void removeElecAuth(Long el_num) {
		mapper.deleteElecAuth(el_num);
	}


}
