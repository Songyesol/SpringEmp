package com.yedam.emp.service.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yedam.emp.EmpVO;

@Repository
public class EmpMybatisDAO {

	@Autowired SqlSessionTemplate sqlSession;
		//등록
		public int insertEmp(EmpVO vo) {
			int r = 0;
			sqlSession.insert("com.yedam.emp.service.impl.EmpMapper.insertEmp", vo);
			return r;
		}
		//수정
		public int updateEmp(EmpVO vo) {
			int r = 0;
			sqlSession.update("com.yedam.emp.service.impl.EmpMapper.updateEmp", vo);
			return r;
		}
		//삭제
		public int deleteEmp(EmpVO vo) {
			int r = 0;
			sqlSession.delete("com.yedam.emp.service.impl.EmpMapper.deleteEmp", vo);
			return r;
		}
		//단건조회
		public EmpVO getEmp(EmpVO vo) {
			return sqlSession.selectOne("com.yedam.emp.service.impl.EmpMapper.getEmp", vo);
		}
		
		//검색/전체조회
		public List<EmpVO> getSearchEmp(EmpVO vo){
			return sqlSession.selectList("com.yedam.emp.service.impl.EmpMapper.getSearchEmp",vo);
		}
		
		public EmpVO getTest(EmpVO vo) {
			return sqlSession.selectOne("com.yedam.emp.service.impl.EmpMapper.getTest",vo);
		}
		
}
