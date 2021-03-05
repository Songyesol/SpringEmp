package com.yedam.emp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.yedam.emp.OrderMasterVO;


@Controller
public class OrderController {
	
	//주문폼으로
	@GetMapping("/insertOrder") 
	public String insertOrderFrm(OrderMasterVO vo) {
		return "order/insertOrder";
	}
	
	//주문등록
	@PostMapping("/insertOrder")
	public String insertOrder(OrderMasterVO vo) {
		System.out.println(vo);
		//master table에 등록 
		//detail (주문상세) list 수 만큼 등록
		return "redirect:/";
	}
	
}
