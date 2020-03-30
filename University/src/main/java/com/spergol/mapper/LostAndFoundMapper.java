package com.spergol.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.spergol.pojo.LostAndFound;

public interface LostAndFoundMapper {
	@Select("select * from lost&found")
	List<LostAndFound> selLAF();
}
