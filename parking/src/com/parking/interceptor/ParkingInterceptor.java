package com.parking.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
//登录判断控制器
public class ParkingInterceptor implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object arg2) throws Exception {
//		获取访问此页面的转发页面URI，如果直接访问login，则允许访问，否则判断是否登录
		String uri = req.getRequestURI();
		if(uri.endsWith("login")||uri.endsWith("register")) {
			return true;
		}
//		调取session中的登录对象，若未设置此对象，为未登录，页面跳转到登录页面
		Object users = req.getSession().getAttribute("users");
		if(users != null) {
//			session中存在登录对象，已登录成功，拦截器不对controller进行拦截，允许进行主页面访问
			return true;
		}
		else {
			res.sendRedirect("login.jsp");
			return false;
		}
	}

}
