package com.yedam.emp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.emp.JobVO;
import com.yedam.emp.service.JobService;

@Service
public class JobServiceImpl implements JobService {
	@Autowired JobMapper jobDAO; 
	
	@Override
	public void insertJob(JobVO vo) {
		jobDAO.insertJob(vo);
	}

	@Override
	public void updateJob(JobVO vo) {
		jobDAO.updateJob(vo);
	}

	@Override
	public void deleteJob(JobVO vo) {
		jobDAO.deleteJob(vo);
	}

	@Override
	public JobVO getJob(JobVO vo) {
		return jobDAO.getJob(vo);
	}

	@Override
	public List<JobVO> getSearchJob(JobVO vo) {
		return jobDAO.getSearchJob(vo);
	}

}
