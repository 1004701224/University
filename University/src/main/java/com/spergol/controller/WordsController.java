package com.spergol.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spergol.pojo.Words;
import com.spergol.service.WordsService;
import com.spergol.utils.Utils;

import net.sf.json.JSONObject;

@Controller
public class WordsController {
	@Resource
	private WordsService wordsServiceImpl;
	private JSONObject json = new JSONObject();

	//	模糊查询(本地测试通过)
	@RequestMapping("selWords")
	public void selWords(HttpServletRequest req,HttpServletResponse resp) {
        try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
        resp.setCharacterEncoding("UTF-8");
		String name = req.getParameter("name");
		String word = Utils.addChar(name, '%');
		List<Words> selWords = wordsServiceImpl.selWords(word);
		json.put("selwords", selWords);
		try {
			resp.getWriter().print(json);
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
//	增加热度(测试通过)
	@RequestMapping("hot")
	public void hot(HttpServletRequest req,HttpServletResponse resp) {
		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
		resp.setCharacterEncoding("UTF-8");
		String name = req.getParameter("name");
		Words selWord = wordsServiceImpl.selWord(name);
		if(selWord!=null) {
			selWord.setHot(selWord.getHot()+1);
			json.put("code", 1);
		}else {
			json.put("code", 0);
			return;
		}
		wordsServiceImpl.updWords(selWord);
		try {
			resp.getWriter().print(json);
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
//	修改数据

	
//	热度排序查询
	@ResponseBody
	@RequestMapping("selhot")
	public void selhot(HttpServletRequest req,HttpServletResponse resp) {
		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
		resp.setCharacterEncoding("UTF-8");
		List<Words> selHot = wordsServiceImpl.selHot();
		json.put("selhot", selHot);
		try {
			resp.getWriter().print(json);
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
