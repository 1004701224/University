package com.spergol.utils;

public class Utils {

//	�ַ��������ַ������࣬�����ַ����������ַ�,ÿ��һ�ַ�����һ��
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
