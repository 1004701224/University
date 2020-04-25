package com.spergol.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.spergol.mapper.ClassesMapper;
import com.spergol.pojo.Classes;
import com.spergol.service.ClassesService;
@Service
public class ClassesServiceImpl implements ClassesService {
	@Resource
	private ClassesMapper classesMapper;

	@Override
	public List<Classes> selCls() {
		// TODO 自动生成的方法存根
		return classesMapper.selCls();
	}
	
	
}
