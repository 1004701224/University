package com.spergol.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spergol.pojo.Maps;
import com.spergol.service.MapsService;
import com.spergol.utils.Utils;

import net.sf.json.JSONObject;

@Controller
public class MapsController {

	@Resource
	private MapsService mapsServiceImpl;
	private JSONObject json = new JSONObject();
	
//	��ӵص�
	@RequestMapping("addMaps")
	public void addMaps(HttpServletRequest req,HttpServletResponse resp) {
		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO �Զ����ɵ� catch ��
			e1.printStackTrace();
		}
		resp.setCharacterEncoding("UTF-8");
		String name = req.getParameter("name");
		System.out.println();
		double latitude = Double.parseDouble(req.getParameter("latitude"));
		double longitude = Double.parseDouble(req.getParameter("longitude"));
		mapsServiceImpl.addMaps(name, latitude, longitude);
	}
	
//	�ص��ȴʲ�ѯ
	@RequestMapping("selMaps")
	public void selMaps(HttpServletRequest req,HttpServletResponse resp) {
		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO �Զ����ɵ� catch ��
			e1.printStackTrace();
		}
		resp.setCharacterEncoding("UTF-8");
		String words = req.getParameter("words");
		Maps selMaps = mapsServiceImpl.selMaps(words);
		json.put("location", selMaps);
		try {
			resp.getWriter().print(json);
			System.out.println(selMaps.toString());
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
}
