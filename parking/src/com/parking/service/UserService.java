package com.parking.service;

import java.util.List;

import com.parking.pojo.User;
//����Ա�����߼��ӿ�
public interface UserService {
//	��ѯ����Ա�����Ϣ
	List<User> userselect(String name,String password);
//	��ӹ���Ա��Ϣ
	int userregister(String name,String password);
//	ɾ������Ա��Ϣ
	int userdelete(String name);
//	���¹���Ա��Ϣ
	int userupdate(String name,String password);
}
