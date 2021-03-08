package com.yedam.emp.controller;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yedam.emp.UserVO;
import com.yedam.emp.service.UserService;

@RestController
public class UserController {
	@Autowired UserService userService;
	
	//등록과 수정만 post / 삭제, 단건조회, 전체조회는 get
	//등록처리
	@PostMapping("/insertUser")
	public ResponseEntity<Object> insertUserProc(UserVO vo) throws JsonProcessingException {
		userService.insertUser(vo);
		UserVO userVO = userService.getUser(vo);
		if(userVO != null) {
			ObjectMapper mapper = new ObjectMapper(); //jackson 라이브러리에서 제공하는 json 변환 클래스
			return ResponseEntity.status(200).body(mapper.writeValueAsString(userVO));
		}else {
			return ResponseEntity.status(500).body("inner error"); //userService.getUser(vo);
		}
	}

	//수정처리
	@PostMapping("/updateUser")
	public UserVO updateUserProc(UserVO vo) {
		userService.updateUser(vo);
		return userService.getUser(vo);
	}
	
	//삭제처리
	@GetMapping(value="/deleteUser")
	public Map deleteUser(UserVO vo) {
		userService.deleteUser(vo);
		return Collections.singletonMap("result", Boolean.TRUE);
	}
	
	//단건조회
	@GetMapping("/getUser")
	public UserVO getUser(UserVO vo) {
		return userService.getUser(vo);
	}
	
	//전체조회
	@GetMapping("/getSearchUser")
	public List<UserVO> getSearchUser(UserVO vo){
		return userService.getSearchUser(vo);
	}
}
