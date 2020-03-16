package com.parking.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;

import com.parking.pojo.Parking;
//车辆信息mapper，交由mybatis进行注入
public interface ParkingMapper {
//	查询全部车辆信息
	@Select("select * from parking")
	List<Parking> parking();
//	按指定车牌号查询车辆信息（模糊查询）
	@Select("select * from parking where name like concat('%',#{0},'%')")
	List<Parking> parkings(String name);
	
//	车辆出场
	@Delete("delete from parking where id = #{0}")
	int parkingdelete(int id);
	
//	车辆入场
	@Insert("insert into parking values(default,#{0},#{1})")
	int parkingadd(String name,String date);
}
