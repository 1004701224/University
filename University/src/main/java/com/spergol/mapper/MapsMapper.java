package com.spergol.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import com.spergol.pojo.Maps;

public interface MapsMapper {

	@Select("select * from maps where name like #{arg0}")
	List<Maps> selMaps(String name);
}
