package com.spergol.utils;

public class Utils {

//	字符串插入字符工具类，传入字符串，插入字符,每隔一字符插入一次
	public static String addChar(String string,char letter) {
		char[] strings = new char[string.length()*2+1];
		for(int i = 0; i < strings.length;i++) {
			strings[i] = '%';
			i++;
			if(i < strings.length)
				strings[i] = string.charAt((i-1)/2); 
		}
		return new String(strings);
	}
}
