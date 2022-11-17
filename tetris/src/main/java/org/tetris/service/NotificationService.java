package org.tetris.service;

import java.util.List;

import org.tetris.domain.notification.AlarmVO;
import org.tetris.domain.Criteria;

public interface NotificationService {
	
	public void registerNotification(AlarmVO alarm);
	public int countNotification(String e_id);
	public List<AlarmVO> readNotificationList(String e_id);
	public void modifyNotiStatus(Long al_num);
	public List<AlarmVO> readTotalNotificationList(Criteria cri, String e_id);
	public int countTotalNotification(String e_id);
	public void modifyTotalNotiStatus(String e_id);
}
