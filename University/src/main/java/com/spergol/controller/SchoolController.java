package com.spergol.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spergol.pojo.School;
import com.spergol.service.SchoolService;

@Controller
public class SchoolController {
	@Resource
	private SchoolService schoolServiceImpl;
	
	@RequestMapping("selSchoolById")
	@ResponseBody
	public void selSchoolByUserId(HttpServletRequest req,HttpServletResponse resp) {
		String userid = req.getParameter("userid");
		List<School> school = schoolServiceImpl.selSchoolByUserId(userid);
		JSONObject json = new JSONObject();
		json.put("schoolname", school.get(1));
		try {
			resp.getWriter().print(json);
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		
	}
}
