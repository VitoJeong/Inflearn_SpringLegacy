package com.word.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.word.WordSet;
import com.word.dao.WordDao;

public class WordSearchServiceUseAutowired {
	
	// @Autowired 사용시 스프링설정 xml파일에서 <context:annotation-config>필요
	@Autowired
	@Qualifier("useDao")
	private WordDao wordDao;
	
	// 프로퍼티와 setter메서드에 autowired를 사용한다면 기본생성자 필요
	public WordSearchServiceUseAutowired() {}

	public WordSearchServiceUseAutowired(WordDao wordDao) {
		this.wordDao = wordDao;
	}
	
	public WordSet searchWord(String wordKey) {
		if(verify(wordKey)) {
			return wordDao.select(wordKey);
		} else {
			System.out.println("WordKey information is available.");
		}
		
		return null;
	}
	
	public boolean verify(String wordKey){
		WordSet wordSet = wordDao.select(wordKey);
		return wordSet != null ? true : false;
	}
	
	@Autowired
	@Qualifier("useDao")
	public void setWordDao(WordDao wordDao) {
		this.wordDao = wordDao;
	}
	
}