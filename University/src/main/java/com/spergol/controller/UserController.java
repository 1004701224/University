package com.spergol.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
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
	@ResponseBody
	private String login() {
		System.out.println("123");
		return "456";
	}
}
