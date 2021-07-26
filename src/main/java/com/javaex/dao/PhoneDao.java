package com.javaex.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	// 전화번호 등록 버전 2
	public void insert2(String name, String hp, String company) {

		Map<String, Object> personMap = new HashMap<String, Object>();
		personMap.put("name", name);
		personMap.put("hp", hp);
		personMap.put("company", company);

		sqlSession.insert("phonebook.insert2", personMap);
	}

	// 전화번호 삭제
	public void delete(int person_no) {

		sqlSession.delete("phonebook.delete", person_no);
	}

	// 전화번호 1명 출력
	public PersonVo getPerson(int person_id) {

		// 받아올 데이터(전화번호 1명)를 Vo로 묶는다.
		PersonVo personVo = sqlSession.selectOne("phonebook.selectOne", person_id);

		return personVo;
	}

	// 전화번호 1명 출력 버전 2
	public Map<String, Object> getPerson2(int person_id) {

		// 받아올 데이터(전화번호 1명)를 Map으로 묶는다.
		Map<String, Object> personMap = sqlSession.selectOne("phonebook.selectOne2", person_id);


		return personMap;
	}

	// 전화번호 수정
	public void update(PersonVo personVo) {

		sqlSession.update("phonebook.update", personVo);

	}

}
