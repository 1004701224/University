package com.spergol.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.spergol.mapper.MapsMapper;
import com.spergol.pojo.Maps;
import com.spergol.service.MapsService;

@Service
public class MapsServiceImpl implements MapsService{

	@Resource
	private MapsMapper mapsMapper;

	@Override
	public int addMaps(String name, double latitude, double longitude) {
		// TODO �Զ����ɵķ������
		return mapsMapper.addMaps(name, latitude, longitude);
	}

	@Override
	public Maps selMaps(String name) {
		// TODO �Զ����ɵķ������
		return mapsMapper.selMaps(name);
	}
	
	
}
