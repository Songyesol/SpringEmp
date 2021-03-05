package com.yedam.emp;

import lombok.Data;

@Data
public class EmpSearchVO extends EmpVO{

	//paging과 관련된 vo추가
	Integer page = 1;
	int start = 1;
	int end = 10;
}
