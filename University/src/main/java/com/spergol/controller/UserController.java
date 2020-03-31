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
 * ���Ŀ���������Ҫ�߼�������д���൱��servlet
 * ��ǰ��@controller����������Ϊ���Ŀ�����
 * ����ע��servicesImpl���������ݷ��ʲ�����
 * ÿһ������ǰʹ��@requestmapping���൱��servlet
 * ����������ʾһ��ģ��
 * ����ֵ����Ϊstring����ʾ��ת·��
 * ��������ת����requextmapping���@ResponseBody
 * ��ʱ�Ὣreturn���ݼӵ���Ӧͷ��
 * ��ģ��ֻ�������û��й��߼�
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
		
		//����΢�Ż�userID�ӿ�
		String getOpenIdUrl = "https://api.weixin.qq.com/sns/jscode2session?appid="+appid+"&secret="+secret+"&js_code=JSCODE&grant_type=authorization_code";
		int money = 0; 
		
		HttpClient httpClient = new DefaultHttpClient();
		HttpGet httpGet = new HttpGet(getOpenIdUrl);
		ResponseHandler<String> responseHandler = new BasicResponseHandler();
		String token = null;
		try {
			token = httpClient.execute(httpGet,responseHandler);
		} catch (ClientProtocolException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		System.out.println(token);
		/*
		 * token���ݸ�ʽ��ô��ȡ��
		 * û�����ݿ�洢�߼���userIDȡ�������޷����token
		 * */
		//String userid = 
		/*if(UserServiceImpl.addUsers(userid, username, money)>0) {
			try {
				resp.getWriter().print("1");
			} catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}else {
			try {
				resp.getWriter().print("0");
			} catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
		*/
		
	}
}
