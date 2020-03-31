package com.spergol.service;

import java.util.List;
import com.spergol.pojo.School;

public interface SchoolService {
	List<School> selSchoolByUserId(String userid);
	List<School> selAllSchool();
}
