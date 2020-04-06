package com.spergol.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.spergol.pojo.User;

/*
 * 数据连接层，在这里访问数据库进行交互
 * 使用时以@+标签的方式进行数据交互
 * */
public interface UserMapper {
//	用户信息查询
	@Select("select * from user where userid = #{arg0}")
	User selectUsers(String userid);
	
//	用户首次登录使用
	@Insert("insert into user values(#{arg0},#{arg1},#{arg2},#{arg3})")
	int addUsers(String userid,String username,int identify,String classes);
	
//	用户信息修改
	int updUser(User user);
	
}
