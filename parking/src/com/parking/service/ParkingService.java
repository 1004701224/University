package com.parking.service;

import java.util.List;

import com.parking.pojo.Parking;
//������Ϣ�����߼��ӿ�
public interface ParkingService {
//	��ѯȫ��������Ϣ
	List<Parking>parking();
//	��ָ�����ƺŲ�ѯ������Ϣ
	List<Parking>parkings(String name);
//	��������
	int parkingdelete(int id);
//	�����볡
	int parkingadd(String name,String date);
}
