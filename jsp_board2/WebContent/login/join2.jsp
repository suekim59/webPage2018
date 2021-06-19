<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="javax.naming.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %> 
<%@ page import="memberdto.Members" %>

	<%@ include file="../inc/header.jsp" %>

<div class="container" style="min-height: 1500px;">
	
	<% 
	request.setCharacterEncoding("utf-8");
	response.setCharacterEncoding("utf-8");
	response.setContentType("text/html;charset=utf-8");
	Members dto=(Members)request.getAttribute("dto");
	%>
		
		<%
	String userid=dto.getUserid();
	String userpass=dto.getUserpass();
	String useremail=dto.getUseremail();
	String userdate=dto.getUserdate();
	
	%> 

	<h3> FORM BASIC - JOIN </h3>
	<table class="table table-striped">
		<caption>회원가입을 축하합니다.(Congratulations.)</caption>
		<tr><td>아이디(ID)</td><td><%=userid%></td></tr>
		<tr><td>비밀번호(Password)</td><td><%=userpass%></td></tr>
		<tr><td>이메일(Email) </td><td><%=useremail%></td></tr>
		<tr><td>가입날짜 (Join date)</td><td><%=userdate%></td></tr>
	</table>
	
	<div class="form-group text-right">
	<a href="login/login.jsp" class="btn" title="로그인하러 이동하기(Move to login)">LOGIN</a>
	<%out.write("<meta http-equiv ='refresh' content='10;url=login/login.jsp'>"); %>
	<!--  경로 변경 -->
	<!--  경로 변경 -->
	<!--  경로 변경 -->
	<!--  경로 변경 -->
	
	</div>


</div>
<%@ include file="../inc/footer.jsp" %>

