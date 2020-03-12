package com.parking.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;

import com.parking.pojo.Parking;
//������Ϣmapper������mybatis����ע��
public interface ParkingMapper {
//	��ѯȫ��������Ϣ
	@Select("select * from parking")
	List<Parking> parking();
//	��ָ�����ƺŲ�ѯ������Ϣ
	@Select("select * from parking where name = #{0}")
	List<Parking> parkings(String name);
	
}
