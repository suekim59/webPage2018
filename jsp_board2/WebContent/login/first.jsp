<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../inc/header.jsp" %>
<div class="container" style="min-height: 1500px;">

	<%if(session.getAttribute("userid") !=null)  {%>
	<%
		//HttpSession session=request.getSession();
		String userid=(String)session.getAttribute("userid");
	        %>
	<h3> <%=userid%>님 환영합니다! </h3>
	<h3> <%=userid%>, Welcome !</h3>
	<% } else {%>
	<h3>환영합니다!</h3>
	<h3>Welcome!</h3>
	<%}%>

</div>	
<%@ include file="../inc/footer.jsp" %>

