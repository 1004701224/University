package com.parking.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;

import com.parking.pojo.Parking;

public interface ParkingMapper {
	@Select("select * from parking")
	List<Parking> parking();

	@Select("select * from parking where name = #{0}")
	List<Parking> parkings(String name);
	
}
