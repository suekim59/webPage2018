<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="javax.naming.*"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.sql.*"%>
<%@ page import="memberdto.Members"%>

<%@ include file="../inc/header.jsp"%>

<div class="container" style="min-height: 1500px;">

	<%
	
	request.setCharacterEncoding("utf-8");
	response.setCharacterEncoding("utf-8");
	response.setContentType("text/html;charset=utf-8");
	
        Members dto=new Members();
				
		dto =(Members)request.getAttribute("dto");
		
		System.out.println(dto);
		//여기서 session을 이용해서 userid를 가져온 다음에 
		String userid = dto.getUserid();
		String userpass = dto.getUserpass();
		String useremail = dto.getUseremail();
		String username = dto.getUsername();
		
	%>
	<h3>M Y P A G E</h3>
	<table class="table table-striped">
		<caption>MYPAGE</caption>
		<tr>
			<td>아이디(ID)</td>
			<td><%=userid%></td>
		</tr>
		<tr>
			<td>비밀번호(Password)</td>
			<td><%=userpass%></td>
		</tr>
		<tr>
			<td>이름(Name)</td>
			<td><%=username%></td>
		</tr>
		<tr>
			<td>이메일(Email)</td>
			<td><%=useremail%></td>
		</tr>
	</table>

	<div class="form-group text-right">
		<a href="login/m1pass.jsp?userid=<%=userid%>&mcommand=M1update" class="btn">개인정보
			수정(Update your Info)</a> <a
			href="login/m1pass.jsp?userid=<%=userid%>&mcommand=M1delete" class="btn">회원탈퇴(Withdrawal
			your account)</a>
	</div>

</div>
<%@ include file="../inc/footer.jsp"%>

