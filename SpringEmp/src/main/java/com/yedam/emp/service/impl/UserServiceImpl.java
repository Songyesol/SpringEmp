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

	public int updateUser(UserVO vo) {
		return userDAO.updateUser(vo);
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

	@Override
	public boolean loginCheck(UserVO vo) {
		//단건조회
		UserVO userVO = userDAO.getUser(vo);
		//id가 일치하는지
		if(userVO == null) {
			return false;
		}
		//pw 일치여부 체크 (
		if(userVO.getPassword().equals(vo.getPassword())) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int updatePassword(UserVO vo) {
		//단건조회
		UserVO userVO = userDAO.getUser(vo);
		//기존의 패스워드(userVO) 와 currentPassword에 입력한 값이 일치하는지 확인.
		if(userVO.getPassword().equals(vo.getCurrentPassword())) {
			//일치하면 패스워드 업데이트
			return userDAO.updateUser(vo);
		}else {
			return 0;
		}
		
	}
	

}
