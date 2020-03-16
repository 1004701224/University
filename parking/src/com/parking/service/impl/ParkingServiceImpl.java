package com.parking.service.impl;
//������Ϣ�����߼�ʵ����
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.parking.mapper.ParkingMapper;
import com.parking.pojo.Parking;
import com.parking.service.ParkingService;
@Service
public class ParkingServiceImpl implements ParkingService{
//	��������mapper���󣬽���Spring����ע��
	@Resource
	private ParkingMapper parkingmapper;
	public ParkingMapper getParkingmapper() {
		return parkingmapper;
	}
	public void setParkingmapper(ParkingMapper parkingmapper) {
		this.parkingmapper = parkingmapper;
	}
//	������Ϣģ����ѯ
	@Override
	public List<Parking> parkings(String name) {
		return parkingmapper.parkings(name);
	}
//	������Ϣȫ����ʾ
	@Override
	public List<Parking> parking() {
		return parkingmapper.parking();
	}
	@Override
	public int parkingdelete(int id) {
		return parkingmapper.parkingdelete(id);
	}
	@Override
	public int parkingadd(String name, String date) {
		return parkingmapper.parkingadd(name, date);
	}

}
