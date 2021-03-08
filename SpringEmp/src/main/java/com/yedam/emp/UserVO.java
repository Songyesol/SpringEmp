package com.yedam.emp;


import lombok.Data;

@Data
public class UserVO {
	private String id; 
	private String password;
	private String name;
	private String role;
	private String currentPassword; //현재 pw값
	private String ckPassword; //pw변경시 일치확인용
}
