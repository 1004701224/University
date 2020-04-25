package com.spergol.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import com.spergol.pojo.Maps;

public interface MapsMapper {
//	�����ص�
	@Insert("insert into maps values(default,#{arg0},#{arg1},#{arg2})")
	int addMaps(String name,double latitude,double longitude);
	
//	�ص��ѯ
	@Select("select * from maps where id = (select related from words where words = #{arg0})")
	Maps selMaps(String name);
}
