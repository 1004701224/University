package com.parking.controller;

//����Ա��¼������
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.websocket.Session;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.parking.pojo.User;
import com.parking.service.UserService;

@Controller
public class UserController {
	// ����userservice����ʹ��byname����ע�뷽ʽ�������ݿ��в������Ա��Ϣ��֤���
	@Resource
	private UserService userServiceImpl;
	// ����user���󷽱�����ת��
	private User users;

	@RequestMapping("login")
	private String login(String name, String password, String num, HttpServletRequest req) {
		System.out.println(name + " " + password);
		String number = (String)req.getSession().getAttribute("number");
		
//		��������ʵ�ʱ�����ڻ��棬����num����Ϊ�ձ���
		// �ɵ�¼ҳ�洫���û��������룬��֤����Ϣ�����бȶԣ���֤��ǿղ���
		if (num != "" && num != null) {
			// ��֤��ǿգ��ȶ���֤�������Ƿ�����
			if (number.equals(num)) {
				// ��֤��������ȷ���ж��û���������ǿ�
				if (name != "" && password != "") {
					// �û�������ǿգ������ݿ��в���û���������Ϣ����user��
					List<User> user = userServiceImpl.userselect(name, password);
					if (!user.isEmpty()) {
						// �û���������ȷ���ɹ������ݿ��в���û���Ϣ��������Ϣ���õ�session�У�������ҳ����ã���ת����ҳ��
						users = user.get(0);
						req.getSession().setAttribute("username", users.getName());
//						���û���Ϣ���õ�session�У����õ�¼״̬����ֹ����������
						req.getSession().setAttribute("users", users);
						return "main";
					} else {
						// �û������벻��ȷ�����ص�¼ҳ��
						System.out.println("�û������������");
						return "login.jsp";
					}
				} else {
					// �û�������δ��д���������ص�¼ҳ��
					System.out.println("�û���������Ϊ��");
					return "login.jsp";
				}

			} else {
//				��֤��������󣬷��ص�¼ҳ��
				System.out.println("��֤�����");
				return "login.jsp";
			}
		} else {
//			��֤��δ��д���������ص�¼ҳ��
			System.out.println("��֤��Ϊ��");
			return "login.jsp";
		}
	}

//	����Աע��
	@RequestMapping("register")
	private String register(String name, String password, String key, String num, HttpServletRequest req) {
//		��ȡע��ҳ����������session�е���֤��
		String number = (String) req.getSession().getAttribute("number");
//		��֤��ǿ�
		if (num != "") {
//			�ж���֤���Ƿ�ƥ��
			if (num.equals(number)) {
//			�ж���Ȩ���Ƿ�ƥ��
				if (key.equals("0000")) {
//				�ж��û��������Ƿ�Ϊ��
					if (name != "" && password != "") {
						if (userServiceImpl.userregister(name, password) > 0) {
//						��Ϣ��ȫ��ע��ɹ�,��ת����¼ҳ��
							System.out.println("ע��ɹ�����ӭ����" + name);
							return "login.jsp";
						} else {
//						δ֪ԭ��,ע��ʧ��
							System.out.println("ע��ʧ�ܣ�����ϵ����Ա");
							return "register.jsp";
						}
					} else {
//						�û�������Ϊ�գ���ת��ע��ҳ�棬ǰ�˿��ԶԴ˽������ƣ�ѹ����̨����
						System.out.println("�û�������Ϊ��");
						return "register.jsp";
					}
				} else {
//					��Ȩ�����ǰ�����Ʒ�Χ
					System.out.println("��Ȩ������޷�ע��");
					return "register.jsp";
				}
			} else {
				System.out.println("��֤�����");
				return "register.jsp";
			}
		} else {
			// ��֤��Ϊ�գ�����ǰ������
			System.out.println("��֤��Ϊ��");
			return "register.jsp";
		}
	}

//	�û�ע��
	@RequestMapping("delete")
	private String delete(String name, HttpServletRequest req) {
//		��ȡ��¼�����session�е�name��Ϣ���жϵ�ǰע���û�
		name = (String) req.getSession().getAttribute("username");
//		ִ��ɾ��ָ��
		if (userServiceImpl.userdelete(name) > 0) {
			System.out.println("�˺�ɾ���ɹ�");
			return "login.jsp";
		} else {
			System.out.println("�˺�ɾ��ʧ�ܣ�������");
			return "delete.jsp";
		}
	}

//	�û��޸���Ϣ
	@RequestMapping("update")
	private String update(String password, HttpServletRequest req) {
//		��ȡsession�д洢���û�����Ϣ
		String name = (String) req.getSession().getAttribute("username");
//		��Ϣ�޸ĳɹ������ص�¼ҳ��
		if (userServiceImpl.userupdate(name, password) > 0) {
			System.out.println("�����޸ĳɹ��������µ�¼");
			return "login.jsp";
		} else {
//			��Ϣ�޸�ʧ�ܣ������޸�ҳ��
			System.out.println("��Ϣ�޸�ʧ�ܣ�������");
			return "update.jsp";
		}
	}
}
