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
		// TODO �Զ����ɵķ������
		return proceduresMapper.selProcedures(classes);
	}



	@Override
	public int addProcedures(Procedures procedures) {
		// TODO �Զ����ɵķ������
		return proceduresMapper.addProcedures(procedures);
	}



	@Override
	public int updProcedures(Procedures procedures) {
		// TODO �Զ����ɵķ������
		return proceduresMapper.updProcedures(procedures);
	}



	@Override
	public int delProcedures(String userid, int id) {
		// TODO �Զ����ɵķ������
		return proceduresMapper.delProcedures(userid, id);
	}
	
	
	
}
