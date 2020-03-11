package com.parking.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.parking.pojo.User;

public interface UserMapper {
//	查询数据库中管理员信息，登录使用
	@Select("select * from admin where name = #{0} and passwd =  #{1}")
	List<User> user(String name,String password);
	
//	向数据库中写入管理员信息，注册使用
	@Insert("insert into admin values(default,#{0},#{1})")
	int userregister(String name,String password);
	
//	从数据库中删除用户信息，离职使用
	@Delete("delete from admin where name = #{0}")
	int userdelete(String name);
	
//	修改用户密码
	@Update("update admin set passwd = #{1} where name = #{0}")
	int userupdate(String name,String password);
}
