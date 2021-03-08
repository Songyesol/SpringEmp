package com.yedam.emp.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yedam.emp.DeptVO;
import com.yedam.emp.EmpSearchVO;
import com.yedam.emp.EmpVO;
import com.yedam.emp.EmpValidation;
import com.yedam.emp.JobVO;
import com.yedam.emp.common.Paging;
import com.yedam.emp.service.DeptService;
import com.yedam.emp.service.EmpService;
import com.yedam.emp.service.JobService;


@Controller
public class EmpController {
	
	@Autowired EmpService empService;
	@Autowired DeptService deptService;
	@Autowired JobService jobService;
	
	@RequestMapping("/")
	public String main() {
		return "main";
	}
	
	//등록페이지로 
	@GetMapping("/insertEmp")
	public String insertEmp(EmpVO vo, DeptVO deptVO, JobVO jobVO,Model model) {
		deptVO.setStart(1);
		deptVO.setEnd(1000);
		model.addAttribute("deptList", deptService.getSearchDept(deptVO));
		model.addAttribute("jobList", jobService.getSearchJob(jobVO));
		return "/emp/insertEmp";
	}
	
	//등록처리
	//BindingResult는 앞에 입력한 클래스를 체크하기 떄문에 EmpVO 뒤에 입력하면 EmpVO를 체크함.
	@PostMapping("/insertEmp")
	public String insertEmpProc(@Valid EmpVO vo, BindingResult errors ,DeptVO deptVO,JobVO jobVO, Model model) {
		//입력값 검증(validation 따로 만들기)
//		EmpValidation empValidation = new EmpValidation();
//		empValidation.validate(vo, errors);
		
		if(errors.hasErrors()) {
			deptVO.setStart(1);
			deptVO.setEnd(1000);
			model.addAttribute("deptList", deptService.getSearchDept(deptVO));
			model.addAttribute("jobList", jobService.getSearchJob(jobVO));
			return "/emp/insertEmp"; //하나라도 에러가 있으면 다시 등록페이지로 이동
		} else { 
			empService.insertEmp(vo);
			return "redirect:getSearchEmp"; // 에러가 없다면 등록처리
		}
	}
	
	//수정페이지로 
	@GetMapping("/updateEmp")
	public String updateEmp(EmpVO vo, DeptVO deptVO, JobVO jobVO,Model model) {
		deptVO.setStart(1);
		deptVO.setEnd(1000);
		model.addAttribute("deptList", deptService.getSearchDept(deptVO));
		model.addAttribute("jobList", jobService.getSearchJob(jobVO));
		model.addAttribute("empVO", empService.getEmp(vo));
		return "/emp/updateEmp";
	}
	
	//수정처리
	@PostMapping("/updateEmp")
	public String updateEmpProc(EmpVO vo) {
		empService.updateEmp(vo);
		return "redirect:getSearchEmp";
	}
	
	@GetMapping("/deleteEmp")
	public String deleteEmp(EmpVO vo) {
		empService.deleteEmp(vo);
		return "redirect:getSearchEmp";
	}
	
	//단건조회 
	/*
	 * @PathVariable : GetMapping("/getEmp/{employee_id}")
	 * */
	@GetMapping("/getEmp")
	public String getEmp(Model model  
						//, @RequestParam(	value = "id" , 
						//					required = false, 
						//					\defaultValue = "100") String employee_id
						//, @PathVariable String employee_id
						, @ModelAttribute("vo") EmpVO vo
						) {
		//1.Request로부터 파라미터 받아서 값 넘기는 방법.
			//String employee_id = request.getParameter("employee_id");
			//EmpVO vo = new EmpVO();
			//vo.setEmployee_id(employee_id);
		//2.Spring에서 값 받는 방법	
		model.addAttribute("emp", empService.getEmp(vo));
		return "/emp/getEmp";
	}
	
	//검색조회
	@GetMapping("/getSearchEmp")
	public String getSearchEmp(EmpSearchVO vo , Paging paging, Model model) {
		//페이징
		paging.setPageUnit(5);	//한페이지 표시되는 레코드건수
		paging.setPageSize(3);  //페이지번호
		
		if(vo.getPage()==null) { //페이지가 안넘어오면 1로 설정하는 null체크
			vo.setPage(1);
		}
		vo.setStart(paging.getFirst());
		vo.setEnd(paging.getLast());
		paging.setTotalRecord(empService.getCount(vo));
		model.addAttribute("paging",paging); //따로 model을 하지 않더라도 command에 선언되어있다면 자동으로 앞글자를 소문자로 바꾸어서 전달됨.
		model.addAttribute("list",empService.getSearchEmp(vo));
		return "/emp/getSearchEmp";
	}
}
