package com.parking.pojo;
//������Ϣ��
public class Parking {
	private int id;
	private String name;
	private String begintime;
	private String endtime;
	private String alltime;
	private int money;
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
	public String getBegintime() {
		return begintime;
	}
	public void setBegintime(String begintime) {
		this.begintime = begintime;
	}
	public String getEndtime() {
		return endtime;
	}
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	public String getAlltime() {
		return alltime;
	}
	public void setAlltime(String alltime) {
		this.alltime = alltime;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	@Override
	public String toString() {
		return "�������������պţ�"+name+"  �볡ʱ�䣺"+begintime+"  ����ʱ�䣺"+endtime+"  ͣ����ʱ����"+alltime+"  Ӧ�ɽ�"+money+"Ԫ";
	}
	
}
