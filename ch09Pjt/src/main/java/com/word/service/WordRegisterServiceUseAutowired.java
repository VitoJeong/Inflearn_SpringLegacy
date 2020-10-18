package com.word.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.word.WordSet;
import com.word.dao.WordDao;

public class WordRegisterServiceUseAutowired {
	
	@Autowired
	@Qualifier("useDao")
	private WordDao wordDao;
	
	public WordRegisterServiceUseAutowired() {
	}
	
	// @Autowired 사용시 스프링설정 xml파일에서 <context:annotation-config>필요
	// @Autowired
	public WordRegisterServiceUseAutowired(WordDao wordDao) {
		this.wordDao = wordDao;
	}
	
	public void register(WordSet wordSet) {
		String wordKey = wordSet.getWordKey();
		if(verify(wordKey)) {
			wordDao.insert(wordSet);
		} else {
			System.out.println("The word has already registered.");
		}
	}
	
	public boolean verify(String wordKey){
		WordSet wordSet = wordDao.select(wordKey);
		return wordSet == null ? true : false;
	}
	
	@Autowired
	@Qualifier("useDao")
	public void setWordDao(WordDao wordDao) {
		this.wordDao = wordDao;
	}
	
}