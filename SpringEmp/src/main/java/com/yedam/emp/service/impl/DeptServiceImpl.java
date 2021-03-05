package com.yedam.emp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.emp.DeptVO;
import com.yedam.emp.service.DeptService;

@Service
public class DeptServiceImpl implements DeptService {
	
	//@Autowired DeptSpringDAO deptDAO;
	@Autowired DeptMapper deptDAO;
		
	public int insertDept(DeptVO vo) {
		return deptDAO.insertDept(vo);
	}

	public int updateDept(DeptVO vo) {
		return deptDAO.updateDept(vo);
	}

	public DeptVO getDept(DeptVO vo) {
		return deptDAO.getDept(vo);
	}

	public List<DeptVO> getSearchDept(DeptVO vo) {
		return deptDAO.getSearchDept(vo);
	}

	public int getCount(DeptVO vo) {
		return deptDAO.getCount(vo);
	}

}
