package com.spergol.controller;

import java.io.IOException;
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
		json.put("location", selMaps);
		try {
			resp.getWriter().print(json);
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
