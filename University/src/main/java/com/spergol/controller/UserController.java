package com.spergol.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
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
	@ResponseBody
	private String login() {
		System.out.println("123");
		return "456";
	}
}
