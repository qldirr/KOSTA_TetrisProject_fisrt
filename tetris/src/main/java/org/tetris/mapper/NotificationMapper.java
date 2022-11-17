package org.tetris.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.tetris.domain.Criteria;
import org.tetris.domain.notification.AlarmVO;

public interface NotificationMapper {
	
	public void insertNotification(AlarmVO alarm);
	public int countNotification(String e_id);
	public List<AlarmVO> getNotificationList(String e_id);
	public void updateNotiStatus(Long al_num);
	public List<AlarmVO> getTotalNotificationList(@Param("cri") Criteria cri, @Param("e_id") String e_id);
	public int countTotalNotification(String e_id);
	public void updateTotalNotiStatus(String e_id);

}
