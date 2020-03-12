package com.parking.service.impl;
//管理员服务逻辑实现类
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.parking.mapper.UserMapper;
import com.parking.pojo.User;
import com.parking.service.UserService;
@Service
public class UserServiceImpl implements UserService{
//	定义管理员mapper对象，由Spring注入信息
	@Resource
	private UserMapper usermapper;
//	生成get，set方法，交由Spring管理
	public UserMapper getUsermapper() {
		return usermapper;
	}
	public void setUsermapper(UserMapper usermapper) {
		this.usermapper = usermapper;
	}
//	管理员信息查询方法
	@Override
	public List<User> userselect(String name, String password) {
		return usermapper.user(name, password);
	}
//	管理员注册
	@Override
	public int userregister(String name, String password) {
		return usermapper.userregister(name, password);
	}
//	管理员删除信息
	@Override
	public int userdelete(String name) {
		return usermapper.userdelete(name);
	}
//	管理员信息更新
	@Override
	public int userupdate(String name, String password) {
		return usermapper.userupdate(name, password);
	}

}
