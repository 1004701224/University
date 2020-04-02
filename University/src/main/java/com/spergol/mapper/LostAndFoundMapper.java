package com.spergol.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.spergol.pojo.LostAndFound;

public interface LostAndFoundMapper {
	@Select("select * from lostfound")
	List<LostAndFound> selAllLAF();
	
//	用户主体查询发布信息
	@Select("select * from lostfound where userid = #{arg0}")
	List<LostAndFound> selUserLAF(String userid);
	
//	按学校区域显示信息
	@Select("select * from lostfound where school = #{arg0}")
	List<LostAndFound> selSchoolLAF(int school);
	
//	id,userid联合查询指定信息
	LostAndFound selLAFById(@Param("id")int id,@Param("userid")String userid);
	
//	创建新信息
	@Insert("insert into lostfound values(default,#{LAF.username},#{LAF.userid},#{LAF.time},#{LAF.attentionnumber},"
			+ "#{LAF.telephone},#{LAF.name},#{LAF.lftime},#{LAF.map},"
			+ "#{LAF.flag},#{LAF.money},#{LAF.attention},#{school})")
	int addLAF(LostAndFound LAF);
	
//	删除信息
	@Delete("delete from lostfound where id = #{arg0}")
	int delLAF(int id);
	
//	修改信息
	int updLAF(@Param("LAF") LostAndFound LAF);
}
