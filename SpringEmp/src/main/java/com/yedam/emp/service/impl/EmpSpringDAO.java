package com.yedam.emp.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.yedam.emp.EmpVO;

@Repository
public class EmpSpringDAO {

	@Autowired JdbcTemplate jdbc;
	
	private String INSERT_EMP="INSERT INTO EMPLOYEES(EMPLOYEE_ID, "
													+ "FIRST_NAME, "
													+ "LAST_NAME, "
													+ "EMAIL, "
													+ "PHONE_NUMBER, "
													+ "HIRE_DATE, "
													+ "JOB_ID ,"
													+ "DEPARTMENT_ID ,"
													+ "MANAGER_ID) "
													+"VALUES(?,?,?,?,?,?,?,?,?)";
	private String UPDATE_EMP="UPDATE EMPLOYEES "
										+ "SET FIRST_NAME=?, "
										+ "LAST_NAME=?, "
										+ "EMAIL=?, "
										+ "PHONE_NUMBER=?, "
										+ "HIRE_DATE=?, "
										+ "JOB_ID=?, "
										+ "DEPARTMENT_ID=?, "
										+ "MANAGER_ID=? "
										+ "WHERE EMPLOYEE_ID = ? ";
	private String DELETE_EMP="DELETE FROM EMPLOYEES WHERE EMPLOYEE_ID=?";
	private String GET_EMP= "SELECT        EMPLOYEE_ID, "
										+ "FIRST_NAME, "
										+ "LAST_NAME, "
										+ "EMAIL, "
										+ "PHONE_NUMBER, "
										+ "HIRE_DATE, "
										+ "JOB_ID, "
										+ "SALARY, "
										+ "COMMISSION_PCT, "
										+ "MANAGER_ID, "
										+ "DEPARTMENT_ID "
										+ "FROM EMPLOYEES "
										+ "WHERE EMPLOYEE_ID = ? ";
	private String GET_SEARCH_EMP= "SELECT     EMPLOYEE_ID, "
											+ "FIRST_NAME, "
											+ "LAST_NAME, "
											+ "EMAIL, "
											+ "PHONE_NUMBER, "
											+ "HIRE_DATE, "
											+ "JOB_ID, "
											+ "SALARY, "
											+ "COMMISSION_PCT, "
											+ "MANAGER_ID, "
											+ "DEPARTMENT_ID "
											+ "FROM EMPLOYEES "
											+ "ORDER BY EMPLOYEE_ID";
	
	//등록
	public int insertEmp(EmpVO vo) {
		int r = 0;
		r = jdbc.update(INSERT_EMP, vo.getEmployee_id(),
									vo.getFirst_name(),
									vo.getLast_name(),
									vo.getEmail(),
									vo.getPhone_number(),
									vo.getHire_date(),
									vo.getJob_id(),
									vo.getDepartment_id(),
									vo.getManager_id());
		return r;
	}
	
	//수정
	public int updateEmp(EmpVO vo) {
		int r = 0;
		r = jdbc.update(UPDATE_EMP , vo.getFirst_name(), 
									 vo.getLast_name(),
									 vo.getEmail(),
									 vo.getPhone_number(),
									 vo.getHire_date(),
									 vo.getJob_id(),
									 vo.getDepartment_id(),
									 vo.getManager_id(),
									 vo.getEmployee_id());	
		return r;
	}
	//삭제
	public int deleteEmp(EmpVO vo) {
		int r= 0;
		r = jdbc.update(DELETE_EMP, vo.getEmployee_id());
		return r;
	}
	
	//단건조회
	public EmpVO getEmp(EmpVO vo) {
		return jdbc.queryForObject(GET_EMP, new EmpRowMapper() , vo.getEmployee_id());
	}
	
	//검색/전체조회
	public List<EmpVO> getSearchEmp(EmpVO vo){
		return jdbc.query(GET_SEARCH_EMP, new EmpRowMapper());
	}
	
	//rowmapper
	class EmpRowMapper implements RowMapper<EmpVO> {

		@Override
		public EmpVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			EmpVO vo = new EmpVO();
			vo.setEmployee_id(rs.getString(1));
			vo.setFirst_name(rs.getString(2));
			vo.setLast_name(rs.getString(3));
			vo.setEmail(rs.getString(4));
			vo.setPhone_number(rs.getString(5));
			vo.setHire_date(rs.getDate(6));
			vo.setJob_id(rs.getString(7));
			vo.setSalary(rs.getInt(8));
			vo.setCommission_pct(rs.getString(9));
			vo.setManager_id(rs.getString(10));
			vo.setDepartment_id(rs.getString(11));
			return vo;
		}
		
	}
	
}
