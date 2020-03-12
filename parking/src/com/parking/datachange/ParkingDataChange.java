package com.parking.datachange;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.parking.pojo.Parking;

public class ParkingDataChange {
	public static void dataChange(List<Parking> parking) {
		for(int i = 0; i < parking.size();i++) {
			int moneyflag = 0;
//			��ȡ��ǰʱ��
			Date date = new Date();
//			��ȡ����list�����е�ÿһ�����ݼ����޸�
			Parking flag = parking.get(i);
//			��ָ����ʽ���ÿ�ʼ����ʱ�䣨��Сʱ���������λ��ʾ��
			String begin = flag.getBegintime();
			int hour = Integer.parseInt(begin.substring(0, 2));
			int minute = Integer.parseInt(begin.substring(2, 4));
			int second = Integer.parseInt(begin.substring(4, 6));
			SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
			int nowhour = Integer.parseInt(df.format(date).substring(0,2));
			int nowminute = Integer.parseInt(df.format(date).substring(3,5));
			int nowsecond = Integer.parseInt(df.format(date).substring(6,8));
			String begintime = String.format("%1$02d", hour)+":"+String.format("%1$02d", minute)+":"+String.format("%1$02d", second);
			String endtime = String.format("%1$02d", nowhour)+":"+String.format("%1$02d", nowminute)+":"+String.format("%1$02d", nowsecond);
//			�ж�ͣ����ʱ������Сʱ��ʾСʱ������һСʱ�ӷ��ӿ�ʼ��ʾ�����������Ӧ�ɽ��
			String alltime = "";
//			ͣ��δ��ҹ�����յ�ǰʱ���ȥͣ��ʱ�����
			if(nowhour-hour>0) {
				alltime += nowhour-hour+"Сʱ";
				if(nowhour-hour<=1)
					moneyflag = 1;
				else if(nowhour-hour<=8)
					moneyflag = 2;
				else {
					moneyflag = 3;
				}
			}else if(nowhour-hour == 0){
				
			}else {
//				ͣ����ҹ����ǰʱ��+24���ȥͣ��ʱ��
				alltime += (nowhour+24)-hour+"Сʱ";
				if((nowhour+24)-hour<=1)
					moneyflag = 1;
				else if((nowhour+24)-hour<=8)
					moneyflag = 2;
				else {
					moneyflag = 3;
				}
			}
			if(nowminute-minute>0) {
				alltime += (nowminute-minute)+"����";
			}else if(nowminute-minute == 0) {
				if(nowhour-hour>0) {
					alltime += (nowminute-minute)+"����";
				}
			}else {
				alltime += (nowminute+60)-minute+"����";
			}
			if(nowsecond-second>=0) {
				alltime += nowsecond-second+"��";
			}else {
				alltime += (nowsecond+60)-second+"��";
			}
//			����ͣ��ʱ�����������
			switch (moneyflag) {
			case 1:
				flag.setMoney(3);
				break;
			case 2:
				flag.setMoney(15);
				break;
			case 3:
				flag.setMoney(30);
				break;
			default:
				flag.setMoney(0);
				break;
			}
			flag.setBegintime(begintime);
			flag.setEndtime(endtime);
			flag.setAlltime(alltime);
		}
	}

}
