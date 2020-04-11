package com.spergol.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spergol.pojo.Maps;
import com.spergol.service.MapsService;
import com.spergol.utils.Utils;

@Controller
public class MapsController {

	@Resource
	private MapsService mapsServiceImpl;
	
//	添加地点
	@RequestMapping("addMaps")
	public void addMaps(HttpServletRequest req,HttpServletResponse resp) {
		String name = req.getParameter("name");
		System.out.println();
		double latitude = Double.parseDouble(req.getParameter("latitude"));
		double longitude = Double.parseDouble(req.getParameter("longitude"));
		mapsServiceImpl.addMaps(name, latitude, longitude);
	}
	
//	地点热词查询
	@RequestMapping("selMaps")
	public void selMaps(HttpServletRequest req,HttpServletResponse resp) {
		String words = req.getParameter("words");
		Maps selMaps = mapsServiceImpl.selMaps(words);
	}
}
