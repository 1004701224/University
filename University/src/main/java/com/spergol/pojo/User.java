package com.spergol.pojo;

//对象基本类，需要和数据库交互的对象都存放于此
//创建基本类的时候，需要生成get，set方法，数据用private保护，数据类型
//即为从数据库中查出的类型

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
