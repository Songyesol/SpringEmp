package com.yedam.emp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yedam.emp.JobVO;
import com.yedam.emp.service.JobService;

@Controller
public class JobController {

		@Autowired JobService jobService;
		
		@RequestMapping("/getSearchJob")
		public String getSearchJob(JobVO vo,Model model) {
			model.addAttribute("list",jobService.getSearchJob(vo));
			return "emp/getSearchEmp";
		}
}
