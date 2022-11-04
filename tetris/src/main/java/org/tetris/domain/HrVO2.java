package org.tetris.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HrVO2 {

	//�����ٹ��ð� 
	private long workringHour;
	
	//�������
	private long working_day;
	
	//����
	private long late_day;
	
	//���
	private long skip_day;
	
	//�ް�
	private long holi_day;
	
	//�������ϼ�
	private long total_holiday;
	
	//��������ϼ�
	private long used_holiday;
	
	//�����ܿ��ϼ�
	private long left_holiday = total_holiday - used_holiday;
	
}

