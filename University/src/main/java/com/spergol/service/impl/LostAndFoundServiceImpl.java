package com.spergol.service.impl;

import java.util.Date;
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
	

	public LostAndFoundMapper getLostAndFoundMapper() {
		return lostAndFoundMapper;
	}


	public void setLostAndFoundMapper(LostAndFoundMapper lostAndFoundMapper) {
		this.lostAndFoundMapper = lostAndFoundMapper;
	}


	@Override
	public List<LostAndFound> selAllLAF() {
		// TODO �Զ����ɵķ������
		return lostAndFoundMapper.selAllLAF();
	}


	@Override
	public List<LostAndFound> selUserLAF(String userid) {
		// TODO �Զ����ɵķ������
		return lostAndFoundMapper.selUserLAF(userid);
	}


	@Override
	public List<LostAndFound> selSchoolLAF(int school) {
		// TODO �Զ����ɵķ������
		return lostAndFoundMapper.selSchoolLAF(school);
	}



	@Override
	public LostAndFound selLAFById(int id, String userid) {
		// TODO �Զ����ɵķ������
		return lostAndFoundMapper.selLAFById(id, userid);
	}


	@Override
	public int addLAF(LostAndFound LAF) {
		// TODO �Զ����ɵķ������
		return lostAndFoundMapper.addLAF(LAF);
	}


	@Override
	public int delLAF(int id) {
		// TODO �Զ����ɵķ������
		return lostAndFoundMapper.delLAF(id);
	}


	@Override
	public int updLAF(LostAndFound LAF) {
		// TODO �Զ����ɵķ������
		return lostAndFoundMapper.updLAF(LAF);
	}
	
	
}
