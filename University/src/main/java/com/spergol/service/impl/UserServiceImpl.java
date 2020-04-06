package com.spergol.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.spergol.mapper.UserMapper;
import com.spergol.pojo.User;
import com.spergol.service.UserService;

/*
 * 数据访问层实现类，在这里对数据访问层进行调用
 * 类前面使用@service注释，声明其为服务层，使用@resource
 * 注解进行依赖注入，形成mapper对象,调用数据连接层
 * 继承services接口，覆盖实现方法
 * 
 * */
@Service
public class UserServiceImpl implements UserService {
	@Resource
	private UserMapper userMapper;

//	生成get，set方法，使依赖注入生效
	public UserMapper getUserMapper() {
		return userMapper;
	}

	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	@Override
	public User selectUsers(String userid) {
		// TODO 自动生成的方法存根
		return userMapper.selectUsers(userid);
	}

	@Override
	public int addUsers(String userid, String username, int identify, String classes) {
		// TODO 自动生成的方法存根
		return userMapper.addUsers(userid, username, identify, classes);
	}

	@Override
	public int updUser(User user) {
		// TODO 自动生成的方法存根
		return userMapper.updUser(user);
	}


}
