package com.spergol.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.spergol.pojo.Procedures;

public interface ProceduresMapper {
	//查询学院全部信息
	@Select("select * from procedures where classes = #{arg0}")
	List<Procedures> selProcedures(String classes);
	
	//新建信息
	@Insert("insert into procedures values(default,#{username},#{userid},#{text},#{localname},"
			+ "#{latitude},#{longitude},#{classes})")
	int addProcedures(Procedures procedures);
	
//	   修改信息
	int updProcedures(Procedures procedures);
	
//	  删除信息
	@Delete("delete from procedures where userid = #{arg0} and id = #{arg1} ")
	int delProcedures(String userid,int id);
}
