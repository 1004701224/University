package com.parking.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.parking.mapper.UserMapper;
import com.parking.pojo.User;
import com.parking.service.UserService;
@Service
public class UserServiceImpl implements UserService{
	@Resource
	private UserMapper usermapper;
	public UserMapper getUsermapper() {
		return usermapper;
	}
	public void setUsermapper(UserMapper usermapper) {
		this.usermapper = usermapper;
	}
	@Override
	public List<User> userselect(String name, String password) {
		return usermapper.user(name, password);
	}
	@Override
	public int userregister(String name, String password) {
		return usermapper.userregister(name, password);
	}
	@Override
	public int userdelete(String name) {
		return usermapper.userdelete(name);
	}
	@Override
	public int userupdate(String name, String password) {
		return usermapper.userupdate(name, password);
	}

}
