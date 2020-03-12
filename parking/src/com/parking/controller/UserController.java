package com.parking.controller;

//管理员登录控制器
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
	// 建立userservice对象，使用byname依赖注入方式，从数据库中查出管理员信息验证身份
	@Resource
	private UserService userServiceImpl;
	// 建立user对象方便数据转发
	private User users;

	@RequestMapping("login")
	private String login(String name, String password, String num, HttpServletRequest req) {
		System.out.println(name + " " + password);
		String number = (String)req.getSession().getAttribute("number");
		
//		浏览器访问的时候会存在缓存，导致num变量为空报错
		// 由登录页面传入用户名，密码，验证码信息，进行比对，验证码非空测试
		if (num != "" && num != null) {
			// 验证码非空，比对验证码输入是否有误
			if (number.equals(num)) {
				// 验证码输入正确，判断用户名、密码非空
				if (name != "" && password != "") {
					// 用户名密码非空，从数据库中查出用户名密码信息存入user中
					List<User> user = userServiceImpl.userselect(name, password);
					if (!user.isEmpty()) {
						// 用户名密码正确，成功从数据库中查出用户信息，将此信息设置到session中，方便主页面调用，跳转到主页面
						users = user.get(0);
						req.getSession().setAttribute("username", users.getName());
//						将用户信息设置到session中，设置登录状态，防止拦截器拦截
						req.getSession().setAttribute("users", users);
						return "main";
					} else {
						// 用户名密码不正确，返回登录页面
						System.out.println("用户名或密码错误");
						return "login.jsp";
					}
				} else {
					// 用户名密码未填写完整，返回登录页面
					System.out.println("用户名或密码为空");
					return "login.jsp";
				}

			} else {
//				验证码输入错误，返回登录页面
				System.out.println("验证码错误");
				return "login.jsp";
			}
		} else {
//			验证码未填写完整，返回登录页面
			System.out.println("验证码为空");
			return "login.jsp";
		}
	}

//	管理员注册
	@RequestMapping("register")
	private String register(String name, String password, String key, String num, HttpServletRequest req) {
//		提取注册页面中设置在session中的验证码
		String number = (String) req.getSession().getAttribute("number");
//		验证码非空
		if (num != "") {
//			判断验证码是否匹配
			if (num.equals(number)) {
//			判断授权码是否匹配
				if (key.equals("0000")) {
//				判断用户名密码是否为空
					if (name != "" && password != "") {
						if (userServiceImpl.userregister(name, password) > 0) {
//						信息完全，注册成功,跳转到登录页面
							System.out.println("注册成功！欢迎您，" + name);
							return "login.jsp";
						} else {
//						未知原因,注册失败
							System.out.println("注册失败！请联系管理员");
							return "register.jsp";
						}
					} else {
//						用户名密码为空，跳转到注册页面，前端可以对此进行限制，压缩后台代码
						System.out.println("用户名密码为空");
						return "register.jsp";
					}
				} else {
//					授权码错误，前端限制范围
					System.out.println("授权码错误！无法注册");
					return "register.jsp";
				}
			} else {
				System.out.println("验证码错误");
				return "register.jsp";
			}
		} else {
			// 验证码为空，可以前端限制
			System.out.println("验证码为空");
			return "register.jsp";
		}
	}

//	用户注销
	@RequestMapping("delete")
	private String delete(String name, HttpServletRequest req) {
//		读取登录后存于session中的name信息，判断当前注销用户
		name = (String) req.getSession().getAttribute("username");
//		执行删除指令
		if (userServiceImpl.userdelete(name) > 0) {
			System.out.println("账号删除成功");
			return "login.jsp";
		} else {
			System.out.println("账号删除失败，请重试");
			return "delete.jsp";
		}
	}

//	用户修改信息
	@RequestMapping("update")
	private String update(String password, HttpServletRequest req) {
//		获取session中存储的用户名信息
		String name = (String) req.getSession().getAttribute("username");
//		信息修改成功，返回登录页面
		if (userServiceImpl.userupdate(name, password) > 0) {
			System.out.println("密码修改成功，请重新登录");
			return "login.jsp";
		} else {
//			信息修改失败，返回修改页面
			System.out.println("信息修改失败，请重试");
			return "update.jsp";
		}
	}
}
