package com.spergol.pojo;

//对象基本类，需要和数据库交互的对象都存放于此
//创建基本类的时候，需要生成get，set方法，数据用private保护，数据类型
//即为从数据库中查出的类型

public class User {
	private int id;
	private String name;
	private String password;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
