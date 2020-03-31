package com.spergol.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

import com.spergol.service.UserService;

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
		System.out.println(code);
		System.out.println(appid);
		System.out.println(secret);
		
		//连接微信换userID接口
		String getOpenIdUrl = "https://api.weixin.qq.com/sns/jscode2session?appid="+appid+"&secret="+secret+"&js_code=JSCODE&grant_type=authorization_code";
		int money = 0; 
		
		HttpClient httpClient = new DefaultHttpClient();
		HttpGet httpGet = new HttpGet(getOpenIdUrl);
		ResponseHandler<String> responseHandler = new BasicResponseHandler();
		String token = null;
		try {
			token = httpClient.execute(httpGet,responseHandler);
		} catch (ClientProtocolException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		System.out.println(token);
		/*
		 * token数据格式怎么提取？
		 * 没做数据库存储逻辑，userID取不到，无法拆分token
		 * */
		//String userid = 
		/*if(UserServiceImpl.addUsers(userid, username, money)>0) {
			try {
				resp.getWriter().print("1");
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
		*/
		
	}
}
