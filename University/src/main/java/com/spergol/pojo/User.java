package com.spergol.pojo;

//��������࣬��Ҫ�����ݿ⽻���Ķ��󶼴���ڴ�
//�����������ʱ����Ҫ����get��set������������private��������������
//��Ϊ�����ݿ��в��������

public class User {
	private String userid;
	private String username;
	private int identify;
	private String classes;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getIdentify() {
		return identify;
	}

	public void setIdentify(int identify) {
		this.identify = identify;
	}

	public String getClasses() {
		return classes;
	}

	public void setClasses(String classes) {
		this.classes = classes;
	}

}
