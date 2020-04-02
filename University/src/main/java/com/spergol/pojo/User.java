package com.spergol.pojo;

//对象基本类，需要和数据库交互的对象都存放于此
//创建基本类的时候，需要生成get，set方法，数据用private保护，数据类型
//即为从数据库中查出的类型

public class User {
	private String id;
	private String username;
	private int money;
	private int school;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return username;
	}
	public void setName(String name) {
		this.username = name;
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
