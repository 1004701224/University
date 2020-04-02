package com.spergol.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spergol.pojo.LostAndFound;
import com.spergol.service.LostAndFoundService;

@Controller
public class LostAndFoundController {

	@Resource
	private LostAndFoundService lostAndFoundServiceImpl;
	
//	+关注控制器
	@RequestMapping("attention")
	public void attention(HttpServletRequest req,HttpServletResponse resp) {
		String userid = (String) req.getSession().getAttribute("userid");
		int id = Integer.parseInt(req.getParameter("id"));
		int flag;
		LostAndFound message = lostAndFoundServiceImpl.selLAFById(id, userid);
		LostAndFound newmessage = new LostAndFound();
		if(message == null) {
			flag = 0;
		}
		else {
			flag = 1;
		}
//		未关注,加关注
		if(flag == 0) {
			message = lostAndFoundServiceImpl.selLAFById(id, "");
			newmessage.setId(message.getId());
			newmessage.setAttentionnumber(message.getAttentionnumber()+1);
			newmessage.setattention(message.getattention()+userid+"&");
			lostAndFoundServiceImpl.updLAF(newmessage);
		}else {
//		已关注，取关
			newmessage.setId(message.getId());
			newmessage.setAttentionnumber(message.getAttentionnumber()-1);
			String[] str = message.getattention().split("&");
			for(int i = 0; i < str.length; i++) {
				if(str[i].equals(userid)) {
					str[i] = ""; 
				}
				newmessage.setattention(newmessage.getattention()+str[i]+"&");
			}
		}
		
	}
}
