<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="javax.naming.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<!-- 연동을 위한 파일!!!! -->

	<%
	Context initContext=new InitialContext();
	Context envContext=(Context)initContext.lookup("java:/comp/env");
	DataSource ds=(DataSource) envContext.lookup("jdbc/bigdata3");
	Connection conn=ds.getConnection();
	out.println("DBCP 연동 성공");
	
	%>

	

