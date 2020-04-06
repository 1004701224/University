package com.spergol.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.spergol.mapper.UserMapper;
import com.spergol.pojo.User;
import com.spergol.service.UserService;

/*
 * ���ݷ��ʲ�ʵ���࣬����������ݷ��ʲ���е���
 * ��ǰ��ʹ��@serviceע�ͣ�������Ϊ����㣬ʹ��@resource
 * ע���������ע�룬�γ�mapper����,�����������Ӳ�
 * �̳�services�ӿڣ�����ʵ�ַ���
 * 
 * */
@Service
public class UserServiceImpl implements UserService {
	@Resource
	private UserMapper userMapper;

//	����get��set������ʹ����ע����Ч
	public UserMapper getUserMapper() {
		return userMapper;
	}

	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	@Override
	public User selectUsers(String userid) {
		// TODO �Զ����ɵķ������
		return userMapper.selectUsers(userid);
	}

	@Override
	public int addUsers(String userid, String username, int identify, String classes) {
		// TODO �Զ����ɵķ������
		return userMapper.addUsers(userid, username, identify, classes);
	}

	@Override
	public int updUser(User user) {
		// TODO �Զ����ɵķ������
		return userMapper.updUser(user);
	}


}
