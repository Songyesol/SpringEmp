<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>insertOrder.jsp</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	$(function(){
		var count = 0;
		$("#addBtn").on("click", function(){
			count++;
			$("tr:last").clone().appendTo($("tbody")).children("td");
			$("tr:last").find("input").eq(0).attr("name","orgs["+count+"].no")
			$("tr:last").find("input").eq(1).attr("name","orgs["+count+"].cnt");
			
		})
	})
</script>
</head>

<body>

<h3>주문</h3>
<button type="button" id="addBtn">상품추가</button>
<form action="insertOrder" method="post">
	<table>
		<tr>
			<th>이름</th>
			<td><input name="name"></td>
		</tr>
		<tr>
			<th>전화번호</th>
			<td><input name="tel"></td>
		</tr>
		<tr>
			<th>배송지</th>
			<td><input name="addr"></td>
		</tr>
		<tr>
			<td>상품번호<input name="ords[0].no"></td>
			<td>주문수량<input name="ords[0].cnt"></td>
		</tr>
		
	</table>
	<button type="submit">주문하기</button>
</form>
</body>
</html>