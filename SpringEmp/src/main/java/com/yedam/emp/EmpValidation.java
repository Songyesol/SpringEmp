package com.yedam.emp;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class EmpValidation implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return true;
	}

	@Override
	public void validate(Object target, Errors errors) {
		EmpVO emp = (EmpVO)target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "employee_id", null , "Empty employee_id is now allowed.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "last_name", null , "Empty last_name is now allowed.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "hire_date", null , "Empty hire_date is now allowed.");
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", null , "Empty email is now allowed.");
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors, "department_id", null , "Empty department_id is now allowed.");
		
		if(emp.getEmail() == null || ! emp.getEmail().isEmpty()) 
			errors.rejectValue("email", null, "email not null");
		if(emp.getDepartment_id() == null || ! emp.getDepartment_id().isEmpty()) 
			errors.rejectValue("department_id", null, "department_id not null");
	}


}
