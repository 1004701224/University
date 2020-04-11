package com.spergol.service;

import java.util.List;

import com.spergol.pojo.Words;

public interface WordsService {

	List<Words> selWords(String name);
	Words selWord(String name);
	int updWords(Words words);
}
