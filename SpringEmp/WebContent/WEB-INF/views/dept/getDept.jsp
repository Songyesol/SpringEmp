<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>getDept.jsp</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#updateDeptBtn").on("click", function(){
			location.assign("updateDept?department_id=${deptVO.department_id }");
		})
	})
</script>
</head>
<body>
<h3>부서 상세보기</h3>
부서번호 : ${deptVO.department_id } <br>
부서명 : ${deptVO.department_name } <br>
매니저 사원번호 : ${deptVO.manager_id } <br>
지역번호 : ${deptVO.location_id } <br>
<button id="updateDeptBtn">수정</button>
<a href="getSearchDept">목록으로</a>
</body>
</html>