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
	
//	�û������ѯ������Ϣ
	@Select("select * from lostfound where userid = #{arg0}")
	List<LostAndFound> selUserLAF(String userid);
	
//	��ѧУ������ʾ��Ϣ
	@Select("select * from lostfound where school = #{arg0}")
	List<LostAndFound> selSchoolLAF(int school);
	
//	id,userid���ϲ�ѯָ����Ϣ
	LostAndFound selLAFById(@Param("id")int id,@Param("userid")String userid);
	
//	��������Ϣ
	@Insert("insert into lostfound values(default,#{LAF.username},#{LAF.userid},#{LAF.time},#{LAF.attentionnumber},"
			+ "#{LAF.telephone},#{LAF.name},#{LAF.lftime},#{LAF.map},"
			+ "#{LAF.flag},#{LAF.money},#{LAF.attention},#{school})")
	int addLAF(LostAndFound LAF);
	
//	ɾ����Ϣ
	@Delete("delete from lostfound where id = #{arg0}")
	int delLAF(int id);
	
//	�޸���Ϣ
	int updLAF(@Param("LAF") LostAndFound LAF);
}
