package com.yedam.emp.service;

import java.util.List;

import com.yedam.emp.UserVO;

public interface UserService {

	//등록
	public void insertUser(UserVO vo);
	//수정
	public int updateUser(UserVO vo);
	//삭제
	public void deleteUser(UserVO vo);
	//단건조회
	public UserVO getUser(UserVO vo);
	//전체조회
	public List<UserVO> getSearchUser(UserVO vo);
	//로그인처리
	public boolean loginCheck(UserVO vo);
	//패스워드변경 
	public int updatePassword(UserVO vo);
	
}
