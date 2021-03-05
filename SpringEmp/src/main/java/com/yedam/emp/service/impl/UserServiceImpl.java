package com.yedam.emp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.emp.UserVO;
import com.yedam.emp.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired UserMapper userDAO;
	
	
	public void insertUser(UserVO vo) {
		userDAO.insertUser(vo);
	}

	public void updateUser(UserVO vo) {
		userDAO.updateUser(vo);
	}

	public void deleteUser(UserVO vo) {
		userDAO.deleteUser(vo);
	}

	public UserVO getUser(UserVO vo) {
		return userDAO.getUser(vo);
	}

	public List<UserVO> getSearchUser(UserVO vo) {
		return userDAO.getSearchUser(vo);
	}

}
