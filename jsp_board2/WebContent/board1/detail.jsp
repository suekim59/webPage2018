<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@  include  file="../inc/header.jsp" %>
<%@ page import="board.dto.Board" %>
<!-- Header -->
<!-- Header -->
<!-- Header -->
<!-- Header -->
<!-- Header -->
<!-- Header -->
	<div class="container  myboard">
	<%
	request.setCharacterEncoding("utf-8");
	response.setCharacterEncoding("utf-8");
	response.setContentType("text/html;charset=utf-8");
	Board dto=(Board)request.getAttribute("dto");
	%>
	
	<%
	int bno=dto.getBno();
	int bhit=dto.getBhit();
	String bname=dto.getBname();
	String btitle=dto.getBtitle();
	String bcontent=dto.getBcontent();
	%> 
	
	
			<h3>QNA 상세보기</h3>
				 
					<input type="hidden" name="bId" value="">
					<div class="panel ">
					  <div  class="panel-heading"> <span class="glyphicon glyphicon-plus">HIT</span></div>
					  <div  class="panel-body"><%=bhit%> </div>
					</div>						
					<div class="panel"  >
					  <div  class="panel-heading"><span class="glyphicon glyphicon-plus">NAME</span></div>
					  <div  class="panel-body"><%=bname%> </div>
					</div>	
					<div class="panel"  >
					  <div  class="panel-heading"><span class="glyphicon glyphicon-plus">TITLE</span></div>
					  <div  class="panel-body"><%=btitle%> </div>
					</div>	
					<div class="panel"  >
					  <div  class="panel-heading"> <span class="glyphicon glyphicon-plus">CONTENT</span></div>
					  <div  class="panel-body"><%=bcontent %> </div>
					</div>	
					<div class="row  text-right"    >
						 <a href="<%=request.getContextPath()%>/pass_view.do?bno=<%=bno%>&bcommand=update_view.do"   class="btn" >수정</a> 
						 <a href="<%=request.getContextPath()%>/pass_view.do?bno=<%=bno%>&bcommand=delete.do"   class="btn" >삭제</a>
						 <a href="<%=request.getContextPath()%>/list.do"  class="btn" >목록보기</a> 
					</div>	
	</div>
<!-- Footer -->
<!-- Footer -->
<!-- Footer -->
<!-- Footer -->
<!-- Footer -->
<!-- Footer -->
<%@  include  file="../inc/footer.jsp" %>