package com.yedam.emp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.emp.EmpSearchVO;
import com.yedam.emp.EmpVO;
import com.yedam.emp.service.EmpService;

@Service
public class EmpServiceImpl implements EmpService {

	
	//@Autowired EmpMybatisDAO empDAO;
	@Autowired EmpMapper empDAO;
	
	//@Transactional
	public int insertEmp(EmpVO vo) {
		//empDAO.insertEmp(vo); //트랜잭션이 지정되지않으면 자동커밋
		return empDAO.insertEmp(vo); //uk에러 발생, 트랜잭션이 지정된 경우 모든쿼리 rollback
	}

	public int updateEmp(EmpVO vo) {
		return empDAO.updateEmp(vo);
	}

	public int deleteEmp(EmpVO vo) {
		return empDAO.deleteEmp(vo);
	}

	public EmpVO getEmp(EmpVO vo) {
		return empDAO.getEmp(vo);
	}

	public List<EmpVO> getSearchEmp(EmpSearchVO vo) {
		System.out.println("mybatis list 실행");
		return empDAO.getSearchEmp(vo);
	}

	public int getCount(EmpSearchVO vo) {
		return empDAO.getCount(vo);
	}

	@Override
	public EmpVO getTest(EmpVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

}
