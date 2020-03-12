package com.parking.datachange;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.parking.pojo.Parking;

public class ParkingDataChange {
	public static void dataChange(List<Parking> parking) {
		for(int i = 0; i < parking.size();i++) {
			int moneyflag = 0;
//			读取当前时间
			Date date = new Date();
//			获取返回list集合中的每一项数据加以修改
			Parking flag = parking.get(i);
//			按指定格式设置开始结束时间（以小时分钟秒各两位显示）
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
//			判断停车总时长（有小时显示小时，不足一小时从分钟开始显示），并计算出应缴金额
			String alltime = "";
//			停车未隔夜，按照当前时间减去停车时间计算
			if(nowhour-hour>0) {
				alltime += nowhour-hour+"小时";
				if(nowhour-hour<=1)
					moneyflag = 1;
				else if(nowhour-hour<=8)
					moneyflag = 2;
				else {
					moneyflag = 3;
				}
			}else if(nowhour-hour == 0){
				
			}else {
//				停车隔夜，当前时间+24后减去停入时间
				alltime += (nowhour+24)-hour+"小时";
				if((nowhour+24)-hour<=1)
					moneyflag = 1;
				else if((nowhour+24)-hour<=8)
					moneyflag = 2;
				else {
					moneyflag = 3;
				}
			}
			if(nowminute-minute>0) {
				alltime += (nowminute-minute)+"分钟";
			}else if(nowminute-minute == 0) {
				if(nowhour-hour>0) {
					alltime += (nowminute-minute)+"分钟";
				}
			}else {
				alltime += (nowminute+60)-minute+"分钟";
			}
			if(nowsecond-second>=0) {
				alltime += nowsecond-second+"秒";
			}else {
				alltime += (nowsecond+60)-second+"秒";
			}
//			依据停车时间计算所需金额
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
