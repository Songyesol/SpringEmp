package com.yedam.emp.service.impl;

import java.util.List;

import com.yedam.emp.UserVO;

public interface UserMapper {

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
	
}
