package com.spergol.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.spergol.pojo.Classes;

public interface ClassesMapper {
//	�б������ѯ
	@Select("select * from classes")
	List<Classes> selCls();
}
