package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.PersonVo;

@Repository
public class PhoneDao {

	// 필드
	@Autowired
	private SqlSession sqlSession;

	// 전체 리스트 가져오기
	public List<PersonVo> getPersonList() {

		// DB에 요청하여 리스트 가져오기.
		List<PersonVo> personList = sqlSession.selectList("phonebook.selectList");

		return personList;
	}

	// 전화번호 등록
	public void insert(PersonVo personVo) {

		sqlSession.insert("phonebook.insert", personVo);

	}

}
