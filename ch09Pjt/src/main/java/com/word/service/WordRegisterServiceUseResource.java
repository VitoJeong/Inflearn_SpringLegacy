package com.word.service;

import javax.annotation.Resource;


import com.word.WordSet;
import com.word.dao.WordDao;

public class WordRegisterServiceUseResource {
	
	// @Resource는 생성자 사용불가능
	//	-> 프로퍼티, 생성자에 사용가능 -> 기본생성자 필요!
	@Resource
	private WordDao wordDao;
	
	public WordRegisterServiceUseResource() {}
	
	public WordRegisterServiceUseResource(WordDao wordDao) {
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
	
	@Resource
	public void setWordDao(WordDao wordDao) {
		this.wordDao = wordDao;
	}
	
}