package com.spergol.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.spergol.pojo.Procedures;

public interface ProceduresMapper {
	//��ѯѧԺȫ����Ϣ
	@Select("select * from procedures where classes = #{arg0}")
	List<Procedures> selProcedures(String classes);
	
	//�½���Ϣ
	@Insert("insert into procedures values(default,#{username},#{userid},#{text},#{localname},"
			+ "#{latitude},#{longitude},#{classes})")
	int addProcedures(Procedures procedures);
	
//	   �޸���Ϣ
	int updProcedures(Procedures procedures);
	
//	  ɾ����Ϣ
	@Delete("delete from procedures where userid = #{arg0} and id = #{arg1} ")
	int delProcedures(String userid,int id);
}
