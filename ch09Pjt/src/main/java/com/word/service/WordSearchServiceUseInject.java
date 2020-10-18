package com.word.service;

import javax.inject.Inject;
import javax.inject.Named;

import com.word.WordSet;
import com.word.dao.WordDao;

public class WordSearchServiceUseInject {
	
	// @Autowired 사용시 스프링설정 xml파일에서 <context:annotation-config>필요
	@Inject
	@Named(value="wordDao1")
	private WordDao wordDao;
	
	// 프로퍼티와 setter메서드에 autowired를 사용한다면 기본생성자 필요
	public WordSearchServiceUseInject() {}

	public WordSearchServiceUseInject(WordDao wordDao) {
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
	
	@Inject
	@Named(value="wordDao1")
	public void setWordDao(WordDao wordDao) {
		this.wordDao = wordDao;
	}
	
}