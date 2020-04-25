package com.spergol.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spergol.service.ClassesService;

import net.sf.json.JSONObject;

@Controller
public class ClassesController {

	@Resource
	private ClassesService classesServiceImpl;
	private JSONObject json = new JSONObject();
	
	@RequestMapping("selclasses")
	public void selClasses(HttpServletRequest req,HttpServletResponse resp) {
		   try {
				req.setCharacterEncoding("UTF-8");
			} catch (UnsupportedEncodingException e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
	        resp.setCharacterEncoding("UTF-8");
	        json.put("classes", classesServiceImpl.selCls());
	        try {
				resp.getWriter().print(json);
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
	}
}
