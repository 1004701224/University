package com.spergol.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.spergol.pojo.User;

/*
 * �������Ӳ㣬������������ݿ���н���
 * ʹ��ʱ��@+��ǩ�ķ�ʽ�������ݽ���
 * */
public interface UserMapper {
//	�û���Ϣ��ѯ
	@Select("select * from user where userid = #{arg0}")
	User selectUsers(String userid);
	
//	�û��״ε�¼ʹ��
	@Insert("insert into user values(#{arg0},#{arg1},#{arg2},#{arg3})")
	int addUsers(String userid,String username,int identify,String classes);
	
//	�û���Ϣ�޸�
	int updUser(User user);
	
}
