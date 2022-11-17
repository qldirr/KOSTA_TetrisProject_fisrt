package org.tetris.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tetris.domain.notification.AlarmVO;
import org.tetris.domain.Criteria;
import org.tetris.mapper.NotificationMapper;
import org.tetris.mapper.ProjectMapper;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Service
@NoArgsConstructor
@AllArgsConstructor
public class NotificationServiceImpl implements NotificationService {

	@Autowired
	private NotificationMapper mapper;
	
	@Override
	public void registerNotification(AlarmVO alarm) {
		mapper.insertNotification(alarm);
	}

	@Override
	public int countNotification(String e_id) {
		return mapper.countNotification(e_id);
	}

	@Override
	public List<AlarmVO> readNotificationList(String e_id) {
		return mapper.getNotificationList(e_id);
	}

	@Override
	public void modifyNotiStatus(Long al_num) {
		mapper.updateNotiStatus(al_num);
	}

	@Override
	public List<AlarmVO> readTotalNotificationList(Criteria cri, String e_id) {
		return mapper.getTotalNotificationList(cri, e_id);
	}

	@Override
	public int countTotalNotification(String e_id) {
		return mapper.countTotalNotification(e_id);
	}

	@Override
	public void modifyTotalNotiStatus(String e_id) {
		mapper.updateTotalNotiStatus(e_id);
	}

}
