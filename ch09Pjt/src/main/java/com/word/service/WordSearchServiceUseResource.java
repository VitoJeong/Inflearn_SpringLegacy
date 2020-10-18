package com.word.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

import com.word.WordSet;
import com.word.dao.WordDao;

public class WordSearchServiceUseResource {
	
	// @Resource는 생성자 사용불가능
	//	-> 프로퍼티, 생성자에 사용가능 -> 기본생성자 필요!
	@Resource
	private WordDao wordDao;
	
	// 프로퍼티와 setter메서드에 autowired를 사용한다면 기본생성자 필요
	public WordSearchServiceUseResource() {}

	public WordSearchServiceUseResource(WordDao wordDao) {
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
	
	@Resource
	public void setWordDao(WordDao wordDao) {
		this.wordDao = wordDao;
	}
	
}