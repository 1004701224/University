package com.parking.service.impl;
//����Ա�����߼�ʵ����
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.parking.mapper.UserMapper;
import com.parking.pojo.User;
import com.parking.service.UserService;
@Service
public class UserServiceImpl implements UserService{
//	�������Աmapper������Springע����Ϣ
	@Resource
	private UserMapper usermapper;
//	����get��set����������Spring����
	public UserMapper getUsermapper() {
		return usermapper;
	}
	public void setUsermapper(UserMapper usermapper) {
		this.usermapper = usermapper;
	}
//	����Ա��Ϣ��ѯ����
	@Override
	public List<User> userselect(String name, String password) {
		return usermapper.user(name, password);
	}
//	����Աע��
	@Override
	public int userregister(String name, String password) {
		return usermapper.userregister(name, password);
	}
//	����Աɾ����Ϣ
	@Override
	public int userdelete(String name) {
		return usermapper.userdelete(name);
	}
//	����Ա��Ϣ����
	@Override
	public int userupdate(String name, String password) {
		return usermapper.userupdate(name, password);
	}

}
