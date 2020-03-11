package com.parking.service;

import java.util.List;

import com.parking.pojo.User;

public interface UserService {
	List<User> userselect(String name,String password);
	int userregister(String name,String password);
	int userdelete(String name);
	int userupdate(String name,String password);
}
