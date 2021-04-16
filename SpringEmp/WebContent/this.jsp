<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>this</title>
</head>
<body>
	<h3>this</h3>
	<div>window객체가 나타난다. 기본적으로 this는 window이기 때문이다. 사실 참 어려운게, 꼭 window라고만 말할 수는 없다. this는 객체 내부, 객체 메서드 호출시, 생성자 new 호출시, 명시적 bind시에 따라 바뀌기 때문이다.
	<br>call과 apply의 유일한 차이점은, 첫 번째 인자(this를 대체할 값)를 제외하고, 실제 say에 필요한 parameter를 입력하는 방식이다. call과는 다르게 apply함수는 두 번째 인자부터 모두 배열에 넣어야 한다.
	</div>
	
	<div id="divFunc" onclick="divHandler()">divFunc</div>
<!-- 	<div id="divFunc" onclick="divHandler(a,b)">divFunc</div> -->
	<div id="divFuncCall" onclick="divHandler.call(this)">divFuncCall</div>
<!-- 	<div id="divFuncCall" onclick="divHandler.call(this,a,b)">divFuncCall</div> -->
	<div id="divEvent">divEvent</div>
	<div id="divPerson" onclick="person.fullName()">divPerson</div>
	<div id="divApply" onclick="person.fullName.apply(this)">divApply</div>
<!-- 	<div id="divApply" onclick="person.fullName.apply(this,[a,b])">divApply</div> -->
	<div id="divAjax">divApply</div>
	<script>
		var methodThis;
		var aloneThis = this;
		var functionThis;
		var divHandlerThis;
		var eventThis;
		var callThis;

		function functionThisTest() {
			functionThis = this; //event.target
			console.log('event.target',event.target);
			console.log('functionThis',functionThis);
		}

		function divHandler() {
			divHandlerThis = this;
			console.log('event.target',event.target);
			console.log('divHandlerThis',divHandlerThis);
		}
		
		divEvent.addEventListener("click", function() {
			eventThis = this;
			console.log('event.target',event.target);
			console.log('eventThis',eventThis);
		})

		
/* 		$("divAjax").on("click", function(){
		var obj = this; //ajax 함수의 this 는 ajax 이기 때문에 
			$.ajax({
				url : '',
				success : function(){
					this
				}
			});
		}) */
		// Create an object:
		var person = {
			firstName : "John",
			lastName : "Doe",
			id : 5566,
			fullName : function() {
				methodThis = this;
				console.log('methodThis',methodThis);
				return this.firstName + " " + this.lastName;
			}
		};
		
		console.log('aloneThis',aloneThis);
		functionThisTest();		
		person.fullName();
	</script>
</body>
</html>
