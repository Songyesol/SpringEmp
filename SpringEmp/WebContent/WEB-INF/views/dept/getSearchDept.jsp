<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>getSearchDept.jsp</title>
<style>
	table tr{text-align:center;}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#insertDeptBtn").on("click", function(){
			location.assign("insertDept");
		})
	})
</script>
</head>
<body>
<div align="center">
	<h2>부서 목록</h2>
	<form name="searchFrm2" action="getSearchDept">
		<input type="hidden" name="page" value="1">
		부서명 <input name="department_name" value=${deptVO.department_name }>
		매니저ID <input type="number" name="manager_id" value=${deptVO.manager_id }>
		<button>검색</button>
	</form>
	<table border="1">
		<tr>
			<th>DEPARTMENT ID</th>
			<th>DEPARTMENT NAME</th>
			<th>MANAGER ID</th>
			<th>MANAGER NAME</th>
			<th>CITY</th>
		</tr>
		<c:forEach items="${list }" var="dept">
		<tr>
			<td>${dept.department_id }</td>
			<td><a href="getDept?department_id=${dept.department_id }">${dept.department_name }</a></td>
			<td>${dept.manager_id }</td>
			<td>${dept.manager_name }</td>
			<td>${dept.city }</td>
		</tr>
		</c:forEach>
	</table>
	<my:paging paging="${paging }" />
	<script>
		function go_page(p){
			searchFrm2.page.value=p;
			searchFrm2.submit();
		}
	</script>
	<div>
		<button id="insertDeptBtn">부서등록</button>
	</div>
</div>
</body>
</html>