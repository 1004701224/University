package com.parking.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;

import com.parking.pojo.Parking;
//������Ϣmapper������mybatis����ע��
public interface ParkingMapper {
//	��ѯȫ��������Ϣ
	@Select("select * from parking")
	List<Parking> parking();
//	��ָ�����ƺŲ�ѯ������Ϣ��ģ����ѯ��
	@Select("select * from parking where name like concat('%',#{0},'%')")
	List<Parking> parkings(String name);
	
//	��������
	@Delete("delete from parking where id = #{0}")
	int parkingdelete(int id);
	
//	�����볡
	@Insert("insert into parking values(default,#{0},#{1})")
	int parkingadd(String name,String date);
}
