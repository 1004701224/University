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
public class UserServiceImpl implements UserService{
	@Resource
	private UserMapper userMapper;

	@Override
	public List<User> selectUser(int id) {
		// TODO �Զ����ɵķ������
		return userMapper.selectUsers(id);
	}
	
	
}
