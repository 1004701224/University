package com.spergol.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spergol.pojo.Procedures;
import com.spergol.service.ProceduresService;

import net.sf.json.JSONObject;

@Controller
public class ProceduresController {

	@Resource
	private ProceduresService proceduresServiceImpl;

//	创建信息(本地测试通过)
	@RequestMapping("add")
	public void add(HttpServletRequest req, HttpServletResponse resp) {
		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		resp.setCharacterEncoding("UTF-8");
		String userid = (String) req.getSession().getAttribute("userid");
		int flag = (int) req.getSession().getAttribute("flag");
		String username = (String) req.getSession().getAttribute("username");
		String text = req.getParameter("text");
		String localname = req.getParameter("localname");
		double latitude = Double.parseDouble(req.getParameter("latitude"));
		double longitude = Double.parseDouble(req.getParameter("longitude"));
		String classes = (String) req.getSession().getAttribute("classes");
		System.out.println(classes);
		Procedures procedures = new Procedures();
		procedures.setUserid(userid);
		procedures.setUsername(username);
		procedures.setText(text);
		procedures.setLocalname(localname);
		procedures.setLatitude(latitude);
		procedures.setLongitude(longitude);
		procedures.setClasses(classes);
		System.out.println(latitude + "  " + longitude);
		if (flag == 1) {
			if (proceduresServiceImpl.addProcedures(procedures) > 0) {
				try {
					resp.getWriter().println("数据写入成功");
				} catch (IOException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			} else {
				try {
					resp.getWriter().println("数据写入失败");
				} catch (IOException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}

		} else {
			try {
				resp.getWriter().println("对不起，您没有修改权限");
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}

	}

//	读取信息(本地测试通过)
	@RequestMapping("main")
	public void main(HttpServletRequest req, HttpServletResponse resp) {
		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
		resp.setCharacterEncoding("UTF-8");
		String userid = (String) req.getSession().getAttribute("userid");
		String username = (String) req.getSession().getAttribute("username");
		String classes = (String) req.getSession().getAttribute("classes");
		List<Procedures> procedures = proceduresServiceImpl.selProcedures(classes);
		JSONObject json = new JSONObject();
		json.put("procedures", procedures);
		try {
			resp.getWriter().print(json);
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}	
	}
	
//	修改信息(本地测试通过)
	@RequestMapping("changeProcedures")
	public void change(HttpServletRequest req,HttpServletResponse resp) {
		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
		resp.setCharacterEncoding("UTF-8");
		String userid = (String) req.getSession().getAttribute("userid");
		String username = (String) req.getSession().getAttribute("username");
		String classes = (String) req.getSession().getAttribute("classes");
		int id = Integer.parseInt(req.getParameter("id"));
		String text = req.getParameter("text");
		String localname = req.getParameter("localname");
		String latitude1 = req.getParameter("latitude");
		String longitude1 = req.getParameter("longitude");
		double latitude = 0;
		double longitude = 0;
		if(latitude1!=null && !latitude1.equals(""))
			latitude = Double.parseDouble(latitude1);
		if(longitude1!=null && !longitude1.equals(""))
			longitude = Double.parseDouble(longitude1);
		Procedures procedures = new Procedures();
		procedures.setUserid(userid);
		procedures.setUsername(username);
		procedures.setClasses(classes);
		procedures.setId(id);
		procedures.setText(text);
		procedures.setLocalname(localname);
		procedures.setLatitude(latitude);
		procedures.setLongitude(longitude);
		if (proceduresServiceImpl.updProcedures(procedures)>0) {
			try {
				resp.getWriter().println("修改成功！");
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}else {
			try {
				resp.getWriter().println("修改失败！");
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}

//	删除信息(本地测试通过)
	@RequestMapping("delete")
	public void delete(HttpServletRequest req,HttpServletResponse resp) {
		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
		resp.setCharacterEncoding("UTF-8");
		String userid = (String) req.getSession().getAttribute("userid");
		int id = Integer.parseInt(req.getParameter("id"));
		if (proceduresServiceImpl.delProcedures(userid, id)>0) {
			try {
				resp.getWriter().print("删除成功！");
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}else {
			try {
				resp.getWriter().print("删除失败！");
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}
}
