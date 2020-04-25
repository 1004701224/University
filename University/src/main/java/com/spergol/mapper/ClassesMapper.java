package com.spergol.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.spergol.pojo.Classes;

public interface ClassesMapper {
//	列表整体查询
	@Select("select * from classes")
	List<Classes> selCls();
}
