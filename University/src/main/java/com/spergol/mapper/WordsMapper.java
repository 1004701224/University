package com.spergol.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.spergol.pojo.Maps;
import com.spergol.pojo.Words;

public interface WordsMapper {

//	模糊查询
	@Select("select * from words where words like #{arg0}")
	List<Words> selWords(String name);
	
//	精确查询
	@Select("select * from words where words = #{arg0}")
	Words selWord(String name);
	
//	数据修改
	int updWords(Words words);
}
