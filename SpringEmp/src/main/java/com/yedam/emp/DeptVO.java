package com.yedam.emp;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor //인수가 없는 빈 생성자
@AllArgsConstructor
public class DeptVO {
	private int department_id;
	private String department_name;
	private Integer manager_id;
	private int location_id;
	private String city;
	private String manager_name;
	//페이징vo 추가
	private int start;
	private int end;
	private Integer page;
	/*  //page를 Integer타입으로 선언한 이유?
	 * int로 넘기면 해당 값을 넘기지 않았을때 null값이 안넘어가서 400번 에러가 나고 Integer로 넘기면 null로 잡아서 에러 발생
	 * 안함.
	 */
	
}
