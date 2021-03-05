<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>getSearchEmp.jsp</title>
<style>
	table{text-align:center}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	$(function(){
		$("#insertBtn").on("click", function(){
			//location.href="updateEmp?employee_id=${emp.employee_id }";
			location.assign("insertEmp");
		})
	})
</script>
</head>
<body>
<div align="center">
	<h3>사원목록</h3>
	<form action="getSearchEmp" name="searchFrm">
	<input type="hidden" name="page" value="1"> <!-- 검색결과에 대해서 페이징 -->
	부서 <input name="department_id" value=${empSearchVO.department_id }>
	job <input name="job_id" value=${empSearchVO.job_id }>
	name <input name="first_name" value=${empSearchVO.first_name }>
	<button>검색</button>
	</form>
		<table border="1">
			<tr>
				<th>사원이름</th>
				<th>이메일</th>
				<th>월급</th>
				<th>부서명</th>
				<th>업무</th>
			</tr>
			<c:forEach items="${list }" var="emp">
			<tr>
				<td><a href="getEmp?employee_id=${emp.employee_id }">${emp.last_name }</a></td>
				<td>${emp.email }</td>
				<td>${emp.salary }</td>
				<td>${emp.department_name }</td>
				<td>${emp.job_title }</td>
			</tr>
			</c:forEach>
		</table>
		<my:paging paging="${paging }"  />
		<script>
			function go_page(p){
				//location.href="getSearchEmp?page="+p;
				searchFrm.page.value=p;
				searchFrm.submit();
			}
		</script>
	<button id="insertBtn">사원등록</button>
</div>
</body>
</html>