package com.parking.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;

import com.parking.pojo.Parking;
//车辆信息mapper，交由mybatis进行注入
public interface ParkingMapper {
//	查询全部车辆信息
	@Select("select * from parking")
	List<Parking> parking();
//	按指定车牌号查询车辆信息
	@Select("select * from parking where name = #{0}")
	List<Parking> parkings(String name);
	
}
