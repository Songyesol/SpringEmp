package com.yedam.emp;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class UserValidation implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return true;
	}

	@Override
	public void validate(Object target, Errors errors) {
		UserVO vo = (UserVO) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "currentPassword", null , "현재 비밀번호를 입력하세요.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", null , "변경할 비밀번호를 입력하세요.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ckPassword", null , "비밀번호 확인을 입력하세요.");
		
		if(!(vo.getPassword().equals(vo.getCkPassword()))) {
			errors.rejectValue("password", null, "입력값이 일치하지 않습니다.");
			errors.rejectValue("ckPassword", null, "입력값이 일치하지 않습니다.");
		}
	}

}
