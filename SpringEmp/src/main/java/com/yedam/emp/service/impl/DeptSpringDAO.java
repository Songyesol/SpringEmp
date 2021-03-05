package com.yedam.emp.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.yedam.emp.DeptVO;

@Repository
public class DeptSpringDAO {
	
@Autowired JdbcTemplate jdbc;

private String INSERT_DEPT = "INSERT INTO DEPARTMENTS( department_id, "
													+ "department_name,"
													+ "manager_id,"
													+ "location_id ) "
													+ "VALUES(?,?,?,?)";
private String UPDATE_DEPT = "UPDATE DEPARTMENTS "
									+ "SET "
									+ "DEPARTMENT_NAME= ?, "
									+ "MANAGER_ID= ?, "
									+ "LOCATION_ID= ? "
									+ "WHERE DEPARTMENT_ID = ? ";
private String GET_DEPT = "SELECT * FROM DEPARTMENTS WHERE DEPARTMENT_ID=?";
private String GET_SEARCH_DEPT = "SELECT * FROM DEPARTMENTS ORDER BY DEPARTMENT_ID ASC";

//등록
public int insertDept(DeptVO vo) {
	int r=0;
	r = jdbc.update(INSERT_DEPT, vo.getDepartment_id(),
							 vo.getDepartment_name(),
							 vo.getManager_id(),
							 vo.getLocation_id());
	return r;
}
//수정
public int updateDept(DeptVO vo) {
	int r=0;
	r = jdbc.update(UPDATE_DEPT, vo.getDepartment_name(),
							 vo.getManager_id(),
							 vo.getLocation_id(),
							 vo.getDepartment_id());
	return r;
}

//단건조회
public DeptVO getDept(DeptVO vo) {
	return jdbc.queryForObject(GET_DEPT, new DeptRowMapper(), vo.getDepartment_id());
}

//전체조회 
public List<DeptVO> getSearchDept(DeptVO vo){
	return jdbc.query(GET_SEARCH_DEPT, new DeptRowMapper());
}

//RowMapper
class DeptRowMapper implements RowMapper<DeptVO> {

	@Override
	public DeptVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		DeptVO vo = new DeptVO();
		vo.setDepartment_id(rs.getInt("department_id"));
		vo.setDepartment_name(rs.getString("department_name"));
		vo.setManager_id(rs.getInt("manager_id"));
		vo.setLocation_id(rs.getInt("location_id"));
		return vo;
	}
	
}
}
