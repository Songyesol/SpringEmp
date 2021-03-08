<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.error{color:red;}
</style>
</head>
<body>
	<div align="center">
		<h3>패스워드 변경</h3>
		<form:form modelAttribute="userVO" action="changePassword" method="post">
			현재 패스워드		<form:input type="password" path="currentPassword" />
							<form:errors path="currentPassword" cssClass="error" /><br>
			변경할 패스워드		<form:input type="password" path="password" />
							<form:errors path="password" cssClass="error" /><br>
			변경할 패스워드 확인	<form:input type="password" path="ckPassword" />
							<form:errors path="ckPassword" cssClass="error" /><br>
			<form:button type="submit">변경</form:button>
		</form:form>
	</div>
</body>
</html>