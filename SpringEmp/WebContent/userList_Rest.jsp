<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>RESTful 웹서비스 클라이언트(JSON)</title>
<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="./resources/js/json.min.js"></script>
<script type="text/javascript" >
	$(function(){
		userList();

		userSelect();
		
		userDelete();
		
		userInsert();
	
		userUpdate();
		
		init();
	});
	
	//초기화
	function init() {
		//초기화 버튼 클릭
		$('#btnInit').on('click',function(){
			$('#form1').each(function(){
				this.reset();
			});
		});
	}//init
	
	//사용자 삭제 요청
	function userDelete() {
		//삭제 버튼 클릭
		$('body').on('click','#btnDelete',function(){
			if(! confirm('삭제하시겠습니까?')){
				return;
			}
			var tr = $(this).closest("tr");
			var id= $(this).closest("tr").find("td:first").text();
 			$.ajax({
 				url:'user/'+id,
 				method:'DELETE',
 				dataType:'json',				
 				contentType:'application/json', //보낼데이터 json ->@requestBody
 				success : function(response){
 					if(response == true){
 						tr.remove();
 					}
 				}
 			});
		}); //삭제 버튼 클릭
	}//userDelete
	
	//사용자 조회 요청
	function userSelect() {
		//조회 버튼 클릭
		$('body').on('click','#btnSelect',function(){
			var id = $(this).closest("tr").find("td:first").text();
 			$.ajax({
 				url:'user/'+id,
 				method:'GET',
 				contentType:'application/json',
 				dataType:'json',				
 				success : userSelectResult
		}); //조회 버튼 클릭
	})
	
	}//userSelect
	
	//사용자 조회 응답
	function userSelectResult(user) {
		$('input:text[name="id"]').val(user.id);
		$('input:text[name="name"]').val(user.name);
		$('input:text[name="password"]').val(user.password);
		$('select[name="role"]').val(user.role).attr("selected", "selected");
	}//userSelectResult
	
	//사용자 수정 요청
	function userUpdate() {
		//수정 버튼 클릭
		$('#btnUpdate').on('click',function(){
			
 			$.ajax({
 				url:'user',
 				method:'PUT',
 				data: JSON.stringify($("#form1").serializeObject()), //응답결과가 json json.parse
 				dataType:'json',				
 				contentType:'application/json', //보낼데이터 json ->@requestBody
 				success : function(response){
 					//폼필드 초기화 
 					document.form1.reset();
 					//tr태그 부분을 수정된 데이터로 교체 
					var tr = makeTr(response);
 					var oldTr = $("td:contains('"+response.id+"')").parent();
 					oldTr.replaceWith(tr);
 				}
 			});
		});//수정 버튼 클릭
	}//userUpdate
	
	//사용자 등록 요청
	function userInsert(){
		//등록 버튼 클릭
		$('#btnInsert').on('click',function(){
/* 			var param ={id: $("[name=id]").val() ,
						name: $("[name=name]").val(), 
						password: $("[name=password]").val(), 
						role: $("[name=role]").val()}; */
 			$.ajax({
 				url:'user',
 				method:'POST',
 				data: JSON.stringify($("#form1").serializeObject()), 
 				dataType:'json',				//응답결과가 json json.parse
 				contentType:'application/json', //보낼데이터 json ->@requestBody
 				success : function(response){
 					var tr = makeTr(response);
 					tr.appendTo('tbody');
 				}
 			
 			});
		});//등록 버튼 클릭
	}//userInsert
	
	//사용자 목록 조회 요청
	function userList() {
		$.ajax({
			url:'user',
			type:'GET',
			dataType:'json',
			error:function(xhr,status,msg){
				alert("상태값 :" + status + " Http에러메시지 :"+msg);
			},
			success:userListResult
		});
	}//userList
	
	//사용자 목록 조회 응답
	function userListResult(data) {
		$("tbody").empty();
		$.each(data,function(idx,item){
			var tr = makeTr(item);
			tr.appendTo('tbody');
		});//each
	}//userListResult
	
	//tr태그 생성해서 목록추가
	function makeTr(item){
		return $('<tr>')
		.append($('<td>').html(item.id))
		.append($('<td>').html(item.name))
		.append($('<td>').html(item.password))
		.append($('<td>').html(item.role))
		.append($('<td>').html('<button id=\'btnSelect\'>조회</button>'))
		.append($('<td>').html('<button id=\'btnDelete\'>삭제</button>'))
		.append($('<input type=\'hidden\' id=\'hidden_userId\'>').val(item.id));
	}
</script>
</head>
<body>
<div class="container">
	<form id="form1"  class="form-horizontal">
		<h2>사용자 등록 및 수정</h2>
		<div class="form-group">		
			<label >아이디:</label>
			<input type="text"  class="form-control" name="id" >
		</div>	
		<div class="form-group">
			<label>이름:</label>
			<input type="text"  class="form-control"  name="name" >
		</div>	
		<div class="form-group">
			<label>패스워드:</label>
			<input type="text"  class="form-control"  name="password" >
		</div>			
<!-- 		<div class="form-group">
			<label >성별:</label>
			<div class="radio">
				<label><input type="radio"  name="gender"  value="남">남</label>
			</div>
			<div class="radio">
				<label><input type="radio"  name="gender"  value="여">여</label>
			</div>	
		</div>	 -->    
		<div class="form-group">   
			<label>역할:</label>
				<select class="form-control" name="role">
					   		<option value="Admin">관리자</option>
					   		<option value="User">사용자</option>
				</select>
		</div>  
		<div class="btn-group">      
				<input type="button"  class="btn btn-primary" value="등록"  id="btnInsert" /> 
				<input type="button"  class="btn btn-primary" value="수정"  id="btnUpdate" />
				<input type="button"  class="btn btn-primary" value="초기화" id="btnInit" />
		</div>
	</form>
</div>		
<hr/>		
<div class="container">	
	<h2>사용자 목록</h2>
	<table class="table text-center">
		<thead>
		<tr>
			<th class="text-center">아이디</th>
			<th class="text-center">이름</th>
			<th class="text-center">성별</th>
			<th class="text-center">역할</th>
		</tr>
		</thead>
		<tbody></tbody>
	</table>
</div>	
</body>
</html>