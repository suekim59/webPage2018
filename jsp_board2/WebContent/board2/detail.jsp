<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@  include  file="../inc/header.jsp" %>

<%@ page import="board.dto.Board2" %>
<!-- Header -->
<!-- Header -->
<!-- Header -->
<!-- Header -->
<!-- Header -->
<!-- Header -->
	<div class="container  myboard">
	
			<h3>QNA 상세보기</h3>
				 
					<%-- <input type="hidden" name="bno" value="${dto.bno}"> --%>
					
					<div class="panel ">
					  <div  class="panel-heading"> <span class="glyphicon glyphicon-plus">HIT</span></div>
					  <div  class="panel-body">${dto.bhit} </div>
					</div>						
					<div class="panel"  >
					  <div  class="panel-heading"><span class="glyphicon glyphicon-plus">NAME</span></div>
					  <div  class="panel-body">${dto.bname} </div>
					</div>	
					<div class="panel"  >
					  <div  class="panel-heading"><span class="glyphicon glyphicon-plus">TITLE</span></div>
					  <div  class="panel-body">${dto.btitle} </div>
					</div>	
					<div class="panel"  >
					  <div  class="panel-heading"> <span class="glyphicon glyphicon-plus">CONTENT</span></div>
					  <div  class="panel-body">${dto.bcontent} </div>
					</div>	
					<div class="panel"  >
					  <div  class="panel-heading"> <span class="glyphicon glyphicon-plus">FILE</span></div>
					  <div  class="panel-body"><img src="/upload/${dto.bfile}" alt=""/></div>
					</div>						
					<div class="row  text-right"    >
					
						<a href="<%=request.getContextPath()%>/pass_view2.do?bno=${dto.bno}&bcommand=update_view2.do"   class="btn" >수정</a> 
						 <a href="<%=request.getContextPath()%>/pass_view2.do?bno=${dto.bno}&bcommand=delete2.do"   class="btn" >삭제</a>
						 <a href="<%=request.getContextPath()%>/list2.do"  class="btn" >목록보기</a> 
					</div>	
	</div>
<!-- Footer -->
<!-- Footer -->
<!-- Footer -->
<!-- Footer -->
<!-- Footer -->
<!-- Footer -->
<%@  include  file="../inc/footer.jsp" %>