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

//	�û���¼ע�ᣬ��֤�ɹ���ǰ��ע������cookie��userID
	@RequestMapping("login")
	private void login(HttpServletRequest req, HttpServletResponse resp) {
		String code = req.getParameter("code");
		String appid = req.getParameter("appid");
		String secret = req.getParameter("secret");
		String username = req.getParameter("username");
		String classes = req.getParameter("classes");
		int identify = Integer.parseInt(req.getParameter("identify"));
		String password = req.getParameter("password");
        try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO �Զ����ɵ� catch ��
			e1.printStackTrace();
		}
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");
		// ����΢�Ż�userID�ӿ�
		String getOpenIdUrl = "https://api.weixin.qq.com/sns/jscode2session?appid=" + appid + "&secret=" + secret
				+ "&js_code=" + code + "&grant_type=authorization_code";
		int money = 0;
		HttpClient httpClient = new DefaultHttpClient();
		HttpGet httpGetOpenId = new HttpGet(getOpenIdUrl);
		ResponseHandler<String> responseHandler = new BasicResponseHandler();
		String token = null;
		try {
			token = httpClient.execute(httpGetOpenId, responseHandler);
		} catch (ClientProtocolException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		JSONObject jObject = JSONObject.fromObject(token);
		String userid = jObject.getString("openid");
		req.getSession().setAttribute("userid", userid);

//		ȡ��userID���ж��û��Ƿ����
//		�����ڣ�����û�������ֵ��ǰ��Ҫ�󷵻�
//		�������ڣ��½��û���д�����Ƽ�userID
		User user = UserServiceImpl.selectUsers(userid);
		if (user != null) {
			try {
				resp.getWriter().println("�û��Ѵ���");
				resp.getWriter().println("�û�����" + user.getUsername() + "����Ժϵ��" + user.getClasses() + "���" + user.getIdentify());

			} catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		} else {
			if (identify == 1 && password!=null && password.equals("123456")) {
				if (UserServiceImpl.addUsers(userid, username, identify, classes) > 0) {
					try {
						resp.getWriter().print("��ʦ��һ�ε�½��ע��ɹ���");
					} catch (IOException e) {
						// TODO �Զ����ɵ� catch ��
						e.printStackTrace();
					}
				} else {
					try {
						resp.getWriter().print("0");
					} catch (IOException e) {
						// TODO �Զ����ɵ� catch ��
						e.printStackTrace();
					}
				}
			}else if (identify == 0) {
				if (UserServiceImpl.addUsers(userid, username, identify, classes) > 0) {
					try {
						resp.getWriter().print("ѧ����һ�ε�½��ע��ɹ���");
					} catch (IOException e) {
						// TODO �Զ����ɵ� catch ��
						e.printStackTrace();
					}
				} else {
					try {
						resp.getWriter().print("0");
					} catch (IOException e) {
						// TODO �Զ����ɵ� catch ��
						e.printStackTrace();
					}
				}
				
			} else {
				try {
					resp.getWriter().println("��Ȩ�����");
				} catch (IOException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
			}
		}

	}

//	�û���Ϣ�޸ģ���֤�ɹ�
	@RequestMapping("change")
	public void change(HttpServletRequest req, HttpServletResponse resp) {
		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO �Զ����ɵ� catch ��
			e1.printStackTrace();
		}
		resp.setCharacterEncoding("UTF-8");
		String userid = (String) req.getSession().getAttribute("userid");
		String username = req.getParameter("username");
		String identify = req.getParameter("identify");
		String classes = req.getParameter("classes");
		System.out.println(userid+"ִ�������޸�");
		User user = new User();
		if(identify!=null && !identify.equals("")) {
			user.setIdentify(Integer.parseInt(identify));
		}
		user.setUserid(userid);
		user.setUsername(username);
		user.setClasses(classes);
		if(UserServiceImpl.updUser(user)>0) {
			try {
				resp.getWriter().println("�����޸ĳɹ���");
			} catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
	}

}
