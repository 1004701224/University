package com.spergol.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.spergol.pojo.User;

/*
 * �������Ӳ㣬������������ݿ���н���
 * ʹ��ʱ��@+��ǩ�ķ�ʽ�������ݽ���
 * */
public interface UserMapper {
	@Select("select * from university where id = #{0}")
	List<User> selectUsers(int id);
}
