package com.spergol.service;

import java.util.List;

import com.spergol.pojo.Maps;

public interface MapsService {

	int addMaps(String name,double latitude,double longitude);
	Maps selMaps(String name);
}
