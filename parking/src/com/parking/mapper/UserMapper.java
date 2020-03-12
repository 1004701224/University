package com.parking.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.parking.pojo.User;
//����Աmapper������mybatis����ע��
public interface UserMapper {
//	��ѯ���ݿ��й���Ա��Ϣ����¼ʹ��
	@Select("select * from admin where name = #{0} and passwd =  #{1}")
	List<User> user(String name,String password);
	
//	�����ݿ���д�����Ա��Ϣ��ע��ʹ��
	@Insert("insert into admin values(default,#{0},#{1})")
	int userregister(String name,String password);
	
//	�����ݿ���ɾ���û���Ϣ����ְʹ��
	@Delete("delete from admin where name = #{0}")
	int userdelete(String name);
	
//	�޸��û�����
	@Update("update admin set passwd = #{1} where name = #{0}")
	int userupdate(String name,String password);
}
