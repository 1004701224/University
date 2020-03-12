package com.parking.service;

import java.util.List;

import com.parking.pojo.User;
//管理员服务逻辑接口
public interface UserService {
//	查询管理员身份信息
	List<User> userselect(String name,String password);
//	添加管理员信息
	int userregister(String name,String password);
//	删除管理员信息
	int userdelete(String name);
//	更新管理员信息
	int userupdate(String name,String password);
}
