package com.parking.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.parking.mapper.ParkingMapper;
import com.parking.pojo.Parking;
import com.parking.service.ParkingService;
@Service
public class ParkingServiceImpl implements ParkingService{
	@Resource
	private ParkingMapper parkingmapper;
	public ParkingMapper getParkingmapper() {
		return parkingmapper;
	}
	public void setParkingmapper(ParkingMapper parkingmapper) {
		this.parkingmapper = parkingmapper;
	}
	@Override
	public List<Parking> parkings(String name) {
		return parkingmapper.parkings(name);
	}
	@Override
	public List<Parking> parking() {
		return parkingmapper.parking();
	}

}
