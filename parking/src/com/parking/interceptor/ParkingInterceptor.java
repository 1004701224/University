package com.parking.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
//��¼�жϿ�����
public class ParkingInterceptor implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object arg2) throws Exception {
//		��ȡ���ʴ�ҳ���ת��ҳ��URI�����ֱ�ӷ���login����������ʣ������ж��Ƿ��¼
		String uri = req.getRequestURI();
		if(uri.endsWith("login")||uri.endsWith("register")) {
			return true;
		}
//		��ȡsession�еĵ�¼������δ���ô˶���Ϊδ��¼��ҳ����ת����¼ҳ��
		Object users = req.getSession().getAttribute("users");
		if(users != null) {
			req.setCharacterEncoding("utf-8");
			res.setCharacterEncoding("utf-8");
//			session�д��ڵ�¼�����ѵ�¼�ɹ�������������controller�������أ����������ҳ�����
			return true;
		}
		else {
			res.sendRedirect("login.jsp");
			return false;
		}
	}

}
