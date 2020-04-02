package com.spergol.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpUtils;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spergol.pojo.User;
import com.spergol.service.UserService;

import net.sf.json.JSONObject;

/*
 * 中心控制器，主要逻辑在这里写，相当于servlet
 * 类前加@controller，声明此类为中心控制器
 * 依赖注入servicesImpl对象，与数据访问层连接
 * 每一个方法前使用@requestmapping，相当于servlet
 * 重命名，表示一个模块
 * 返回值必须为string，表示跳转路径
 * 若不想跳转，在requextmapping后加@ResponseBody
 * 此时会将return内容加到响应头中
 * 此模块只处理与用户有关逻辑
 * */
@Controller
public class UserController {
	
	@Resource
	private UserService UserServiceImpl;
	
	@RequestMapping("login")
	private void login(HttpServletRequest req,HttpServletResponse resp) {
		String code = req.getParameter("code");
		String appid = req.getParameter("appid");
		String secret = req.getParameter("secret");
		String username = req.getParameter("username");
        try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
        resp.setCharacterEncoding("UTF-8");
		
		
		//连接微信换userID接口
		String getOpenIdUrl = "https://api.weixin.qq.com/sns/jscode2session?appid="+appid+"&secret="+secret+"&js_code="+code+"&grant_type=authorization_code";
		int money = 0; 
		HttpClient httpClient = new DefaultHttpClient();
		HttpGet httpGetOpenId = new HttpGet(getOpenIdUrl);
		ResponseHandler<String> responseHandler = new BasicResponseHandler();
		String token = null;
		try {
			token = httpClient.execute(httpGetOpenId,responseHandler);
		} catch (ClientProtocolException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		System.out.println(token);
		JSONObject jObject = JSONObject.fromObject(token);
		String userid = jObject.getString("openid");
		req.getSession().setAttribute("userid", userid);
		
		
//		取到userID，判断用户是否存在
//		若存在，查出用户，返回值按前端要求返回
//		若不存在，新建用户，写入名称及userID
		User user = UserServiceImpl.selectUser(userid);
		if(user!=null) {
			try {
				resp.getWriter().println("用户已存在");
				resp.getWriter().println("用户名："+user.getName()+"剩余金额："+user.getMoney()+"所属学校"+user.getSchool());
				
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}else {
			if(UserServiceImpl.addUsers(userid, username, money)>0) {
				try {
					resp.getWriter().print("第一次登陆，注册成功！");
				} catch (IOException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}else {
				try {
					resp.getWriter().print("0");
				} catch (IOException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
			
		}
	}
	
	@RequestMapping("change")
	public void change(HttpServletRequest req,HttpServletResponse resp) {
		String userid = (String) req.getSession().getAttribute("userid");
		String username = req.getParameter("username");
		String school = req.getParameter("school");
		String money = req.getParameter("money");
		
		if(username != null && username != "") {
			if(UserServiceImpl.updusername(userid, username)>0) {
				try {
					resp.getWriter().println("1");
				} catch (IOException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}else {
				try {
					resp.getWriter().println("0");
				} catch (IOException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
			
		}else if(school != null && school != "") {
			if(UserServiceImpl.updschool(userid, Integer.parseInt(school))>0) {
				try {
					resp.getWriter().println("1");
				} catch (IOException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}else {
				try {
					resp.getWriter().println("0");
				} catch (IOException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
			
		}else if(money != null && money != "") {
			if(UserServiceImpl.updmoney(userid, Integer.parseInt(money))>0) {
				try {
					resp.getWriter().println("1");
				} catch (IOException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}else {
				try {
					resp.getWriter().println("0");
				} catch (IOException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
		}
	}
}
