<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>updateDept.jsp</title>
</head>
<body>
<div align="center">
<h2>부서수정</h2>
	<form action="updateDept" method="post" name="frmDept" >
		department_id 		<input type="number" name="department_id" value="${deptVO.department_id }" readonly><br>
		department_name  	<input name="department_name" value="${deptVO.department_name }"><br>
		manager_id   		<input type="number" name="manager_id" value="${deptVO.manager_id }"><button type="button" name="mgrbtn">사원검색</button><br>
		location_id       	<input type="number" name="location_id" value="${deptVO.location_id }"> <br>
		<button type="submit">등록</button>
		<button type="reset">초기화</button>
	</form>
</div>
</body>
</html>