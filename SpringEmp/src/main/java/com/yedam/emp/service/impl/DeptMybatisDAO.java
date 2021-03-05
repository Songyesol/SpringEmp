package com.yedam.emp.service.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.yedam.emp.DeptVO;

public class DeptMybatisDAO {

	@Autowired SqlSessionTemplate sqlSession;
	//등록
	public int insertDept(DeptVO vo) {
		int r = 0;
		sqlSession.insert("com.yedam.emp.service.impl.DeptMapper.insertDept", vo);
		return r;
	}
	//수정
	public int updateDept(DeptVO vo) {
		int r = 0;
		sqlSession.update("com.yedam.emp.service.impl.DeptMapper.updateDept", vo);
		return r;
	}

	//단건조회
	public DeptVO getDept(DeptVO vo) {
		return sqlSession.selectOne("com.yedam.emp.service.impl.DeptMapper.getDept", vo);
	}
	
	//검색/전체조회
	public List<DeptVO> getSearchEmp(DeptVO vo){
		return sqlSession.selectList("com.yedam.emp.service.impl.DeptMapper.getSearchDept",vo);
	}
}
