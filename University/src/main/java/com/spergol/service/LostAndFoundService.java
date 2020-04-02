package com.spergol.service;

import java.util.Date;
import java.util.List;

import com.spergol.pojo.LostAndFound;

public interface LostAndFoundService {
	List<LostAndFound> selAllLAF();
	List<LostAndFound> selUserLAF(String userid);
	List<LostAndFound> selSchoolLAF(int school);
	LostAndFound selLAFById(int id,String userid);
	int addLAF(LostAndFound LAF);
	int delLAF(int id);
	int updLAF(LostAndFound LAF);
}
