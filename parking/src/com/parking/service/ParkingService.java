package com.parking.service;

import java.util.List;

import com.parking.pojo.Parking;

public interface ParkingService {
	List<Parking>parking();
	List<Parking>parkings(String name);
}
