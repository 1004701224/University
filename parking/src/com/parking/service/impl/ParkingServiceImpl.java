package com.parking.service.impl;
//车辆信息服务逻辑实现类
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.parking.mapper.ParkingMapper;
import com.parking.pojo.Parking;
import com.parking.service.ParkingService;
@Service
public class ParkingServiceImpl implements ParkingService{
//	建立车辆mapper对象，交由Spring进行注入
	@Resource
	private ParkingMapper parkingmapper;
	public ParkingMapper getParkingmapper() {
		return parkingmapper;
	}
	public void setParkingmapper(ParkingMapper parkingmapper) {
		this.parkingmapper = parkingmapper;
	}
//	车辆信息模糊查询
	@Override
	public List<Parking> parkings(String name) {
		return parkingmapper.parkings(name);
	}
//	车辆信息全部显示
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
