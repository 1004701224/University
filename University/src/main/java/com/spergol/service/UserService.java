package com.spergol.service;
/*
 * 数据访问层，数据库通过这里与程序
 * 进行交互，每一个对象需要自己的对应
 * 访问接口，user接口只进行user的增删改查
 * 等数据访问，对其他对象的操作，请另建接口
 * */

import java.util.List;

import com.spergol.pojo.User;

public interface UserService {
	/*
	 * 命名时请按照规范以sel,add,del,upd开头
	 * */
	List<User> selectUser(String id);
	int addUsers(String userid,String username,int money,int school);
	int updmoney(String userid,int money);
	int updschool(String userid,int school);
	int updusername(String userid,String username);
}
