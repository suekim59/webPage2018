<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


</head>
<body>



	<div class="container">
		<h3>js parameter</h3>
		<p><input type="button" value="para1" id="para1" /></p>
		<p><input type="button" value="dog1" id="dog1" /></p>
		<p><input type="button" value="cat1" id="cat1" /></p>
		<p><input type="button" value="car" id="car" /></p>
		<p><input type="button" value="plus" id="plus" /></p>


		<script>
			$(function() {
				$("#para1").click(function() {
					alert('홍길동');
				});
				$("#dog1").click(function() {
					drink1();
				});
				$("#cat1").click(function() {
					drink1();
				});
				$("#dog1").click(function() {
					drink2("클라우드");
				});
				$("#cat1").click(function() {
					drink2("사이다");
				});
			});
			function drink1() {
				alert("마시자");
			}
			function drink2(menu) {
				alert(menu + " 마시자!");
			}
			
		
		// #002. car버튼을 클릭하면 마이카 붕붕붕~!
		$(function(){
			$("#car").click(function(){ mycar(); });
		});
		function mycar(){ alert('마이카 붕붕붕~!'); }
		
		// #002. plus버튼을 클릭하면 plus(10,20) 로출 - 10 + 20 = 30 알림창
		$(function(){
			$("#plus").click(function(){ plus(10,20); });
		});
		function plus(num1,num2){ alert(num1+"+"+num2+"="+(num1+num2)); }
		
	</script>
	</div>
</body>
</html>
		