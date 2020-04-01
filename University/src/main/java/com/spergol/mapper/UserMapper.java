package com.spergol.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
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
	List<User> selectUsers(String id);
	
//	用户首次登录使用
	@Insert("insert into user values(#{arg0},#{arg1},#{arg2},default)")
	int addUsers(String userid,String username,int money);
	
//	用户余额修改(以下三个应该可以写成一条)
	@Update("update user set money = #{1} where userid = #{0}")
	int updmoney(String userid,int money);
	
//	用户学校修改
	@Update("update user set school = #{1} where userid = #{0}")
	int updschool(String userid,int school);
	
//	用户名修改
	@Update("update user set money = #{1} where userid = #{0}")
	int updusername(String userid,String username);
	
}
