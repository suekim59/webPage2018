<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../inc/header.jsp" %>

<%@ page import="javax.naming.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %> 
<%@ page import="memberdto.Members"%>

	<div class="container" style="min-height: 1500px;">

	<%
		request.setCharacterEncoding("utf-8");
        Members dto=new Members();
				
		dto =(Members)request.getAttribute("dto");
		
		System.out.println(dto);
		//여기서 session을 이용해서 userid를 가져온 다음에 
		String userid = dto.getUserid();
		String userpass = dto.getUserpass();
		String useremail = dto.getUseremail();
		String username = dto.getUsername();
	%>
	<h3>UPDATE YOUR INFORMATION</h3>

		<form action="<%=request.getContextPath()%>/m1update.login" method="post" id="modify">
		<!-- 서블릿 명령어 M1update -->
		<!-- 서블릿 명령어 M1update -->
		<!-- 서블릿 명령어 M1update -->
			<div class="form-group">
				<label for="userid"><span class="glyphicon glyphicon-plus">아이디(ID)</span></label>
				<input type="text" name="userid" id="userid" class="form-control" value="<%=userid%>" disabled>
				<input type="hidden" name="userid" id="userid" value="<%=userid%>">
			</div>
			<div class="form-group">
				<label for="username"><span class="glyphicon glyphicon-plus">이름(Name)</span></label>
				<input type="text" name="username" id="username" class="form-control" value="<%=username%>" >
			</div>
			<div class="form-group">
				<label for="userpass"><span class="glyphicon glyphicon-plus">비밀번호(Password)</span></label>
				<input type="text" name="userpass" id="userpass" class="form-control" value="<%=userpass%>" >
			</div>
			<div class="form-group">
				<label for="useremail"><span class="glyphicon glyphicon-plus">이메일(Email Address)</span></label>
				<input type="text" name="useremail" id="useremail" class="form-control" value="<%=useremail%>" >
	
			</div>
			<div class="form-group text-right">
				<input type="submit" value="수정(modify)" class="btn" >
				<input type="reset" value="취소(cancel)" class="btn">
				<a href="<%=request.getContextPath()%>/mypage.login" class="btn">마이페이지로 돌아가기(Go back to Mypage.)</a>
				<!-- 서블릿 명령어 Mypage -->
				<!-- 서블릿 명령어 Mypage -->
				<!-- 서블릿 명령어 Mypage -->
				
			</div>

		</form>
		
		<script>
		$(document).ready(function() {
			$("#modify").submit(function() {
				if($("#username").val()=="") 0{
				alert("빈칸입니다.(There is a blank.))");
				$("#username").focus();
				return false;
			}
				if($("#userpass").val()=="") 0{
					alert("빈칸입니다.(There is a blank.))");
					$("#userpass").focus();
					return false;
				}
				if($("#useremail").val()=="") 0{
					alert("빈칸입니다.(There is a blank.))");
					$("#useremail").focus();
					return false;
				}
			});
		});

		</script>


	</div>
<%@ include file="../inc/footer.jsp" %>