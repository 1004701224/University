package com.parking.controller;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.parking.datachange.ParkingDataChange;
import com.parking.interceptor.ParkingInterceptor;
import com.parking.pojo.Parking;
import com.parking.service.ParkingService;

import javassist.compiler.ast.NewExpr;
//主界面控制器
@Controller
public class ParkingController {
	@Resource
	private ParkingService ParkingServiceImpl;
	List<Parking> parking;
	@RequestMapping("main")
	private String main(HttpServletRequest req) {
		try {
			req.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
//		获取用户名，右上角显示
		String username =(String) req.getSession().getAttribute("username");
		System.out.println(username);
//		查询数据库的车辆信息，对其中的数据进行操作
		parking = ParkingServiceImpl.parking();
//		修改查询到的信息，按指定格式重新写入
		ParkingDataChange.outdataChange(parking);
		req.setAttribute("parking", parking);
		return "parking.jsp";
	}
	
//	车辆入场控制器
	@RequestMapping("in")
	private String parkingin(String name) {
		String date = ParkingDataChange.nowDate();
		if(ParkingServiceImpl.parkingadd(name, date)>0)
		return "main";
		else {
			return "parkingadd.jsp";
		}
	}
	
	
//	车辆出场控制器
	@RequestMapping("out")
	private String parkingout(int id,HttpServletRequest req) {
//		获取get中随URL传入的id值，判断出删除对象，对数据库删除操作，并打印记录到日志中
		for(int i = 0; i < parking.size(); i++) {
			if(parking.get(i).getId() == id) {
				if(ParkingServiceImpl.parkingdelete(id)>0) {
					Logger logger = Logger.getLogger(ParkingController.class);
					logger.warn(parking.get(i).toString());
				}
			}
		}
		return "main";
	}
	
//	车辆模糊查询控制器
	@RequestMapping("select")
	private String parkingselect(String name,HttpServletRequest req,HttpServletResponse resp) {
		System.out.println(name);
		parking = ParkingServiceImpl.parkings(name);
		ParkingDataChange.outdataChange(parking);
		req.setAttribute("parking", parking);
		return "parking.jsp";
	}
}
