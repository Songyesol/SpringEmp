<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>getEmp.jsp</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<script>
	$(function(){
		$("#updateBtn").on("click", function(){
			//location.href="updateEmp?employee_id=${emp.employee_id }";
			location.assign("updateEmp?employee_id=${emp.employee_id }");
		})
		$("#deleteBtn").on("click", function(){
			var result = confirm("해당 사원을 삭제하시겠습니까?");
			if(result){
				location.assign("deleteEmp?employee_id=${emp.employee_id }");
			} else {
				//no...
			}
		})
	})
</script>
</head>
<body>
파라미터 : ${vo }
<hr>
사번 :   ${emp.employee_id } <br>
이름 : 	${emp.first_name }  ${emp.last_name } <br>
이메일 : 	${emp.email } <br>
급여 : 	${emp.salary } <br>
부서 : 	${emp.department_id } <br>
<button id="updateBtn">수정</button>
<button id="deleteBtn">삭제</button>
<a href="getSearchEmp">목록으로</a>
</body>
</html>