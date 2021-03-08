<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>employees.html</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	$(function(){
		//이메일 중복체크
		$("[name=emailBtn]").on("click",function(){

				$.ajax({
					url:"EmailCheck",
					data:{ email:$("[name=email]").val()} , //서버에 보낸 타입
					dataType:"xml" , //서버에서 넘겨준 결과타입
					success: function(result){ 
						/*//json
							if(result.email==true){
							$("#emailResult").html("<font color='blue'>사용가능</font>"); 
						}else{
							$("#emailResult").html("<font color='red'>사용불가능</font>");
						} */
						//xml
							$("#emailResult").html($(result).find("email").text());
						}
				});
		});
		
		//매니저 선택
 		$("[name=mgrbtn]").on("click",function(){
 			window.open("empSearch","emp","width=400,height=400");

		}); 
	});
</script>
<style>
	.error{color:red;}
</style>
</head>
<body>
<h3 id="top">사원등록</h3>
<form:form modelAttribute="empVO" action="insertEmp" method="post" name="frm">
	employee_id 	<form:input type="number" path="employee_id" /><form:errors path="employee_id" cssClass="error" /><br>
	first_name  	<form:input path="first_name" /><br>
	last_name   	<form:input path="last_name" />
					<form:errors path="last_name" cssClass="error" /><br>
	email       	<form:input type="email" path="email" />
					<form:errors path="email" cssClass="error" />
					<form:button type="button" name="emailBtn" >중복체크</form:button>
						<span id="emailResult"></span><br>
	phone_number	<form:input type="text" path="phone_number" /><form:errors path="phone_number" cssClass="error" /><br>
	hire_date   	<form:input type="date" path="hire_date"/><form:errors path="hire_date" cssClass="error" /><br>
	job_id 			<form:select path="job_id">
						<option value="">선택</option>
						<form:options 	items="${jobList }" 
										itemLabel="job_title" 
										itemValue="job_id"/>
					</form:select><br>
	department_id	<form:radiobuttons  items="${deptList }" 
										itemLabel="department_name" 
										itemValue="department_id" path="department_id" /><br>
	manager_id	   
	<form:input path="manager_id" />
	<input name="manager_name">
	<button type="button" name="mgrbtn">사원검색</button><br>	
	
	<button type="submit">등록</button>
	<button type="reset">초기화</button>
</form:form>

</body>
</html>
