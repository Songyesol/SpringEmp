package com.yedam.emp.service;

import java.util.List;

import com.yedam.emp.JobVO;

public interface JobService {
	//등록
	public void insertJob(JobVO vo);
	//수정
	public void updateJob(JobVO vo);
	//삭제
	public void deleteJob(JobVO vo);
	//단건조회
	public JobVO getJob(JobVO vo);
	//전체조회
	public List<JobVO> getSearchJob(JobVO vo);
}
