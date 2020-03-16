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
//�����������
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
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
//		��ȡ�û��������Ͻ���ʾ
		String username =(String) req.getSession().getAttribute("username");
		System.out.println(username);
//		��ѯ���ݿ�ĳ�����Ϣ�������е����ݽ��в���
		parking = ParkingServiceImpl.parking();
//		�޸Ĳ�ѯ������Ϣ����ָ����ʽ����д��
		ParkingDataChange.outdataChange(parking);
		req.setAttribute("parking", parking);
		return "parking.jsp";
	}
	
//	�����볡������
	@RequestMapping("in")
	private String parkingin(String name) {
		String date = ParkingDataChange.nowDate();
		if(ParkingServiceImpl.parkingadd(name, date)>0)
		return "main";
		else {
			return "parkingadd.jsp";
		}
	}
	
	
//	��������������
	@RequestMapping("out")
	private String parkingout(int id,HttpServletRequest req) {
//		��ȡget����URL�����idֵ���жϳ�ɾ�����󣬶����ݿ�ɾ������������ӡ��¼����־��
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
	
//	����ģ����ѯ������
	@RequestMapping("select")
	private String parkingselect(String name,HttpServletRequest req,HttpServletResponse resp) {
		System.out.println(name);
		parking = ParkingServiceImpl.parkings(name);
		ParkingDataChange.outdataChange(parking);
		req.setAttribute("parking", parking);
		return "parking.jsp";
	}
}
