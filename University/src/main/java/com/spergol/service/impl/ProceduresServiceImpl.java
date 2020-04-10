package com.spergol.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.spergol.mapper.ProceduresMapper;
import com.spergol.pojo.Procedures;
import com.spergol.service.ProceduresService;
@Service
public class ProceduresServiceImpl implements ProceduresService{
	@Resource
	private ProceduresMapper proceduresMapper;
	
	
	
	public ProceduresMapper getProceduresMapper() {
		return proceduresMapper;
	}



	public void setProceduresMapper(ProceduresMapper proceduresMapper) {
		this.proceduresMapper = proceduresMapper;
	}



	@Override
	public List<Procedures> selProcedures(String classes) {
		// TODO 自动生成的方法存根
		return proceduresMapper.selProcedures(classes);
	}



	@Override
	public int addProcedures(Procedures procedures) {
		// TODO 自动生成的方法存根
		return proceduresMapper.addProcedures(procedures);
	}



	@Override
	public int updProcedures(Procedures procedures) {
		// TODO 自动生成的方法存根
		return proceduresMapper.updProcedures(procedures);
	}



	@Override
	public int delProcedures(String userid, int id) {
		// TODO 自动生成的方法存根
		return proceduresMapper.delProcedures(userid, id);
	}
	
	
	
}
