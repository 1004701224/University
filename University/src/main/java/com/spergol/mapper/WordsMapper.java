package com.spergol.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.spergol.pojo.Maps;
import com.spergol.pojo.Words;

public interface WordsMapper {

//	ģ����ѯ
	@Select("select * from words where words like #{arg0}")
	List<Words> selWords(String name);
	
//	��ȷ��ѯ
	@Select("select * from words where words = #{arg0}")
	Words selWord(String name);
	
//	�����޸�
	int updWords(Words words);
}
