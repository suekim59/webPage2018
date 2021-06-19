<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="javax.naming.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %> 
<%@ include file="../inc/header.jsp" %>
<div class="container" style="min-height: 1500px;">

	<%
	String userid=request.getParameter("userid");
	String mcommand=request.getParameter("mcommand");
	%>

		<h3> 비밀번호 확인 (Please input your password.) </h3>
		<form action="<%=request.getContextPath()%>/m1check.login?userid=<%=userid%>" method="post" id="Check">ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅏㅣㅑㅑ9
		<!-- 서블릿 명령어 -->
		<!-- 서블릿 명령어 -->
		<!-- 서블릿 명령어 -->
		
		<input type="hidden" name="mcommand" value="<%=mcommand%>" />
			<div class="form-group">
				<label for="userpass"><span class="glyphicon glyphicon-plus">PASS</span></label>
				<input type="password" name="userpass" id="userpass" class="form-control">
			</div>
			
			<div class="form-group text-right">
				<p>(*) 개인 정보 수정, 회원탈퇴 시 필수입니다.</p>
				<p>(*) It is mandatory to update your info or withdraw your account.</p>
			</div>
			<div class="form-group text-right">
				<input type="submit" value="확인(Next)" class="btn">
				<a href="<%=request.getContextPath()%>/mypage.login" class="btn" >취소(cancel)</a>
			<!-- 서블릿 명령어 -->
			<!-- 서블릿 명령어 -->
			<!-- 서블릿 명령어 -->
			<!-- 서블릿 명령어 -->
			
			</div>
	
	</form>

</div>
<%@ include file="../inc/footer.jsp" %>