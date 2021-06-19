<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%-- <%@page import="dbmanager.dao.Boardlistall"%>
<%@ page import="dbmanager.dto.Board" %>	 --%>

<%@ include file="../inc/header.jsp" %>

<div class="container" style="min-height: 1500px;">

	<script>
		
		$(document).ready(function() {
			$("#b1join").submit(function() {
				if($("#userid").val()=="") {
				alert("아이디를 만들어주세요.(Please input ID.)");
				$("#userid").focus();
				
				return false;
				}

				if($("#userpass").val()=="") {
				alert("비밀번호를 입력해주세요.(Please input password.)");
				$("#userpass").focus();
				
				return false;
				}
	
				if($("#userpassre").val()=="") {
				alert("비밀번호 확인 칸을 입력해주세요(Please input password again.)");
				$("#userpassre").focus();
				
				return false;
				}
		
				if($("#username").val()=="") {
				alert("이름을 입력해주세요.(Please input your name.)");
				$("#username").focus();
				
				return false;
				}
				if($("#useremail").val()=="") {
					alert("이메일을 입력해주세요.(Please input your email.)");
					$("#useremail").focus();
					return false;
				}
				if($(".result.r1").html() != "사용가능한 아이디입니다.(It is available.)") {
					//값은 우리가 밑에 넣었던 사용가능한 아이디입니다. 요런 값을 넣어야 함.
					alert("아이디중복 검사를 해주세요.(Please check your ID whether there are duplicate IDs.)");
					return false;
				}
			});
		});
		
		</script>



	<h3> 회원가입 ☆ </h3>
	<p> <strong class="required"> (*)</strong>은 필수입력사항입니다. </p>
	<form action="<%=request.getContextPath()%>/b1join.login" method="post" id="b1join">
	<!-- 서블릿 명령어 : b1join -->
	<!-- 서블릿 명령어 : b1join -->
	<!-- 서블릿 명령어 : b1join -->
	<!-- 서블릿 명령어 : b1join -->
	<fieldset class="joinfield if1">
	<legend>필수 입력 정보</legend>
		<div class="form-group">
			<label for="userid"><span class="glyphicon glyphicon-plus">ID</span></label>
			<div class="row"> <div class="col-sm-6">
			<input type="text" name="userid" id="userid" class="form-control"
			placeholder="아이디는 영문, 숫자 4~15자리 ">	
		</div>
		<div class="col-sm-6">	
		<input type="button" class="btn" value="중복확인" id="member_double">
		<span style="font-weigth:bold; color:blue" id="ok"></span>
		<p class="result r1"></p>
		</div>
	
		<script>
			$(function() {
				$("#member_double").click(function() {
					$(".result.r1").empty();
					$.ajax({url : "<%=request.getContextPath()%>/idcheck.login",  
						type:"get",
						dataType:"text",
						data : {"userid":$("#userid").val()}, //값을 넘기려면 이 과정이 필요.
						success : function(result){ //result는 string으로 받아짐.
							console.log(result);
						//숫자니까 ==하면 안된다고!!!
						//result값은 다른데 왜 밑에 것이 안 먹히지..?
							if(result==1) {
							$(".result.r1").html("이미 사용중인 아이디입니다.(It is already in use.)");
							$(".result.r1").css("color","red");
							}else {
							$(".result.r1").html("사용가능한 아이디입니다.(It is available.)");
							$(".result.r1").css("color","blue");
							}
							},
						error : function(str, textStatus, errorThrown) {
							$(".result.r1").html(textStatus + "(HTTP)" + str.status+"/"+ errorThrown);
						}
					})
				})
			})
		</script>
		</div>
		</div>
		<div class="form-group">
			<label for="userpass"><strong class="required">(*)</strong>PASSWORD</label>
			<input type="password" name="userpass" id="userpass" placeholder="영문, 숫자 조합 10자리 " class="form-control">
		</div>
		<div class="form-group">
			<label for="userpassre"><strong class="required">(*)</strong>PASSWORD 확인</label>
			<input type="password" name="userpassre" id="userpassre" class="form-control">
		</div>
		<div class="form-group">
			<label for="username"><strong class="required">(*)</strong>이름</label>
			<input type="text" name="username" id="username" class="form-control">
		</div>
		<div class="form-group">
			<label for="useremail"><strong class="required">(*)</strong>이메일</label>
			<input type="text" name="useremail" id="useremail" class="form-control">
		</div>
		
		<div class="form-group">
			<a href="javascript.history.go(-1)" class="form-control btn" title="이전으로 바로가기">이전(Cancel)</a>
		</div>
		<div class="form-group">
			<input type="submit" value="확인(Submit)" class="form-control btn" title="회원가입하기 버튼 바로 가기">
		</div>
	</fieldset>
	</form>

</div>
<%@ include file="../inc/footer.jsp" %>