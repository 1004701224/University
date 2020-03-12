package com.parking.controller;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.parking.datachange.ParkingDataChange;
import com.parking.pojo.Parking;
import com.parking.service.ParkingService;
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
		ParkingDataChange.dataChange(parking);
		req.setAttribute("parking", parking);
		return "parking.jsp";
	}
	
//	��������������
	@RequestMapping("out")
	private String parkingout(int id,HttpServletRequest req) {
//		��ȡget����URL�����idֵ���жϳ�ɾ�����󣬶����ݿ�ɾ������������ӡ��¼����־��
		for(int i = 0; i < parking.size(); i++) {
			if(parking.get(i).getId() == id) {
				System.out.println(parking.get(i).toString());
			}
		}
		return "main";
	}
	
//	����ģ����ѯ������
	@RequestMapping("select")
	private String parkingselect(String name,HttpServletRequest req,HttpServletResponse resp) {
		System.out.println(name);
		parking = ParkingServiceImpl.parkings(name);
		ParkingDataChange.dataChange(parking);
		req.setAttribute("parking", parking);
		return "parking.jsp";
	}
}
