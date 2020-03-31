package com.spergol.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.spergol.mapper.SchoolMapper;
import com.spergol.pojo.School;
import com.spergol.service.SchoolService;
@Service
public class SchoolServiceImpl implements SchoolService{
	@Resource
	private SchoolMapper schoolMapper;

	public SchoolMapper getSchoolMapper() {
		return schoolMapper;
	}

	public void setSchoolMapper(SchoolMapper schoolMapper) {
		this.schoolMapper = schoolMapper;
	}

	@Override
	public List<School> selSchoolByUserId(String userid) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public List<School> selAllSchool() {
		// TODO 自动生成的方法存根
		return null;
	}
	
}
