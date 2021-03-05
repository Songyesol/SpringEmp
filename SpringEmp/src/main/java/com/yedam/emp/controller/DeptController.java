package com.yedam.emp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yedam.emp.DeptVO;
import com.yedam.emp.common.Paging;
import com.yedam.emp.service.DeptService;

@Controller
public class DeptController {

	@Autowired DeptService deptService;
	
	
	//등록폼으로 
	@GetMapping("/insertDept")
	public String insertDept(DeptVO vo) {
		return "dept/insertDept";
		
	}
	
	//등록처리
	@PostMapping("/insertDept")
	public String insertDeptProc(DeptVO vo) {
		deptService.insertDept(vo);
		return "redirect:getSearchDept";
	}
	
	//수정 폼으로
	@GetMapping("/updateDept")
	public String updateDept(DeptVO vo, Model model) {
		model.addAttribute("deptVO", deptService.getDept(vo));
		return "dept/updateDept";
	}
	
	//수정처리 
	@PostMapping("/updateDept")
	public String updateDeptProc(DeptVO vo) {
		deptService.updateDept(vo);
		return "redirect:getSearchDept";
	}
	
	//단건조회
	@GetMapping("/getDept")
	public String getDept(DeptVO vo, Model model) {
		model.addAttribute("deptVO", deptService.getDept(vo));
		return "dept/getDept";
	}
	//전체조회
	@RequestMapping("/getSearchDept")
	public String getSearchDept(DeptVO vo,Paging paging, Model model) {
		paging.setPageUnit(10);
		paging.setPageSize(3);
		if(vo.getPage()==null) {
			vo.setPage(1);
		}
		vo.setStart(paging.getFirst());
		vo.setEnd(paging.getLast());
		paging.setTotalRecord(deptService.getCount(vo));
		model.addAttribute("list", deptService.getSearchDept(vo));
		return "dept/getSearchDept";
	}
}
