package com.yedam.emp;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor //인수가 없는 빈 생성자
@AllArgsConstructor //모든 객체가 들어간 생성자
public class EmpVO {
	//ctrl + shift + y = 소문자
	//ctrl + shift + x = 대문자
	//String은 @NotEmpty 나머지는 @NotNull
	
	
	@NotEmpty
	private String employee_id;
	private String first_name;
	@NotEmpty(message="last name null")
	private String last_name;
	@NotEmpty
	private String email;
	@NotEmpty
	private String phone_number;
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date hire_date;
	private String job_id;
	private Integer salary;
	private String commission_pct;
	private String manager_id;
	private String department_id;
	private String department_name;
	private String job_title;
	private int test;
	
}
