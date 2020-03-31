package com.spergol.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.spergol.pojo.School;

public interface SchoolMapper {
	@Select("select * from school where id = (select school from user where userid = #{0})")
	List<School> selSchoolByUserId(String userid);
	
	@Select("select * from school where id in (select distinct school from user)" )
	List<School> selAllSchool();
}
