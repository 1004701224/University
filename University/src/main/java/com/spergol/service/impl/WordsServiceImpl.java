package com.spergol.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.spergol.mapper.WordsMapper;
import com.spergol.pojo.Words;
import com.spergol.service.WordsService;
@Service
public class WordsServiceImpl implements WordsService{

	@Resource
	private WordsMapper wordsMapper;

	@Override
	public List<Words> selWords(String name) {
		// TODO �Զ����ɵķ������
		return wordsMapper.selWords(name);
	}

	@Override
	public Words selWord(String name) {
		// TODO �Զ����ɵķ������
		return wordsMapper.selWord(name);
	}

	@Override
	public int updWords(Words words) {
		// TODO �Զ����ɵķ������
		return wordsMapper.updWords(words);
	}
	
	
}
