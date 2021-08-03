package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.PhoneDao;
import com.javaex.vo.PersonVo;

@Service
public class PhoneService {

	// 필드
	@Autowired
	private PhoneDao phoneDao;

	// 생성자

	// 메소드 - GS

	// 메소드 - 일반

	/*** 전화번호 1명 출력 ***/
	public PersonVo getPerson(int person_id) {

		return phoneDao.getPerson(person_id);
	}

}
