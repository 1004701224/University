package com.spergol.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spergol.pojo.Words;
import com.spergol.service.WordsService;
import com.spergol.utils.Utils;

@Controller
public class WordsController {
	@Resource
	private WordsService wordsServiceImpl;
	

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
		for(int i = 0; i < selWords.size();i++) {
			System.out.println(selWords.get(i).toString());
		}
	}
	
//	增加热度(测试通过)
	@RequestMapping("hot")
	public void hot(HttpServletRequest req,HttpServletResponse resp) {
		String name = req.getParameter("name");
		Words selWord = wordsServiceImpl.selWord(name);
		if(selWord!=null) {
			selWord.setHot(selWord.getHot()+1);
		}else {
			System.out.println("数据不存在");
			return;
		}
		wordsServiceImpl.updWords(selWord);
	}
	
//	修改数据

}
