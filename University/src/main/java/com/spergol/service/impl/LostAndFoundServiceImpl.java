package com.spergol.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.spergol.mapper.LostAndFoundMapper;
import com.spergol.pojo.LostAndFound;
import com.spergol.service.LostAndFoundService;
@Service
public class LostAndFoundServiceImpl implements LostAndFoundService{

	@Resource
	private LostAndFoundMapper lostAndFoundMapper;

	@Override
	public List<LostAndFound> selLAF() {
		// TODO �Զ����ɵķ������
		return lostAndFoundMapper.selLAF();
	}
	
}
