package com.spergol.pojo;

//��������࣬��Ҫ�����ݿ⽻���Ķ��󶼴���ڴ�
//�����������ʱ����Ҫ����get��set������������private��������������
//��Ϊ�����ݿ��в��������

public class User {
	private String id;
	private String name;
	private int money;
	private int school;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public int getSchool() {
		return school;
	}
	public void setSchool(int school) {
		this.school = school;
	}
	
}
