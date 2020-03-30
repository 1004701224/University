package com.spergol.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spergol.service.LostAndFoundService;

@Controller
public class LostAndFoundController {

	@Resource
	private LostAndFoundService lostAndFoundServiceImpl;
	
}
