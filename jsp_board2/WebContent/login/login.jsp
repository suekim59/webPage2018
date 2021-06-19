<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%-- <%@page import="dbmanager.dao.Boardlistall"%>
<%@ page import="dbmanager.dto.Board" %>	 --%>

<%@ include file="../inc/header.jsp" %>

<div class="container" style="min-height: 1500px;">

		<script>
		
		$(document).ready(function() {
			$("#b1login").submit(function() {
				if($("#userid").val()=="") {
				alert("아이디를 입력해주세요.(Please input your ID.)");
				$("#userid").focus();
				
				return false;
				}

				if($("#userpass").val()=="") {
				alert("비밀번호를 입력해주세요.(Please input your password.)");
				$("#userpass").focus();
				
				return false;
			}
			});
		});
		
		</script>
		<%
		String remember="", userid="";
		String cookie=request.getHeader("Cookie");
		
		if(cookie !=null) {
			Cookie[] cookies=request.getCookies();
			for(int i=0; i<cookies.length;i++) {
				if(cookies[i].getName().equals("remember")) {
					remember=cookies[i].getValue();
				}
				if(cookies[i].getName().equals("userid")) {
					userid=cookies[i].getValue();
				}
			}
		}
		
		
		%>
		
		<%
		String id="", pass="";
		id=(String)session.getAttribute("id");
		pass=(String)session.getAttribute("pass");
		%>

	<h3> LOGIN </h3>
	<form action="<%=request.getContextPath()%>/b1login.login" method="post" id="b1login">
	<!-- 서블릿 명령어 : b1login -->
	<!-- 서블릿 명령어 : b1login -->
	<!-- 서블릿 명령어 : b1login -->
	<!-- 서블릿 명령어 : b1login -->
		<div class="form-group">
			<label for="userid"><span class="glyphicon glyphicon-plus">ID</span></label>
			<input type="text" name="userid" id="userid"  placeholder="Enter userid"
			<% if(remember.equals("remember")) { %> value="<%=userid%>" <% }%>
			class="form-control">	
		</div>
		<div class="form-group">
			<label for="userpass"><span class="glyphicon glyphicon-plus">PASSWORD</span></label>
			<input type="password" name="userpass" id="userpass" placeholder="Enter password"
			class="form-control">
		</div>
		<div class="form-group">
			<input type="checkbox" name="remember" id="remember" 
			<% if(remember.equals("remember")) { %> checked <% } %>
			>
			<label for="remember">아이디 저장하기(Save your ID.)</label>
		</div>
		
		<div class="form-group text-right">
			<input type="submit" value="로그인(login)" class="btn">
			<a href="join.jsp" class="btn" title="회원가입하기 바로가기" > 회원가입(join) </a>
		</div>
	
	</form>

</div>
<%@ include file="../inc/footer.jsp" %>


