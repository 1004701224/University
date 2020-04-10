package com.spergol.service;

import java.util.List;

import com.spergol.pojo.Procedures;

public interface ProceduresService {
	List<Procedures> selProcedures(String classes);
	int addProcedures(Procedures procedures);
	int updProcedures(Procedures procedures);
	int delProcedures(String userid,int id);
}
