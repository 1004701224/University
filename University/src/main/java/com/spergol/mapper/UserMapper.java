package com.spergol.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
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
	List<User> selectUsers(String id);
	
//	�û��״ε�¼ʹ��
	@Insert("insert into user values(#{arg0},#{arg1},#{arg2},default)")
	int addUsers(String userid,String username,int money);
	
//	�û�����޸�(��������Ӧ�ÿ���д��һ��)
	@Update("update user set money = #{1} where userid = #{0}")
	int updmoney(String userid,int money);
	
//	�û�ѧУ�޸�
	@Update("update user set school = #{1} where userid = #{0}")
	int updschool(String userid,int school);
	
//	�û����޸�
	@Update("update user set money = #{1} where userid = #{0}")
	int updusername(String userid,String username);
	
}
