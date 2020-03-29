package com.spergol.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.spergol.pojo.User;

/*
 * 数据连接层，在这里访问数据库进行交互
 * 使用时以@+标签的方式进行数据交互
 * */
public interface UserMapper {
	@Select("select * from university where id = #{0}")
	List<User> selectUsers(int id);
}
