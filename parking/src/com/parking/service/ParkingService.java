package com.parking.service;

import java.util.List;

import com.parking.pojo.Parking;
//车辆信息服务逻辑接口
public interface ParkingService {
//	查询全部车辆信息
	List<Parking>parking();
//	按指定车牌号查询车辆信息
	List<Parking>parkings(String name);
}
