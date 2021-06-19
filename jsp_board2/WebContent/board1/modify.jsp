<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@  include  file="../inc/header.jsp" %>
<%@ page import="board.dto.Board" %>
<!-- Header -->
<!-- Header -->
<!-- Header -->
<!-- Header -->
<!-- Header -->
<!-- Header -->
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
		String bcontent=dto.getBcontent().replace("<br>", "\r\n");
		%> 

	<div class="container  myboard">
		<h3>QNA 수정하기</h3>	
		<form action="<%=request.getContextPath()%>/update.do?bno=<%=bno%>" method="post"  id="modify">
			<div class="form-group">
			  <label for="bname"  ><span class="glyphicon glyphicon-plus">NAME</span></label>
			  <input type="text" name="bname" id="bname" class="form-control" value="<%=bname%>" disabled > 
			</div>									
			<div class="form-group">
			  <label for="btitle"  ><span class="glyphicon glyphicon-plus">TITLE</span></label>
			  <input type="text" name="btitle" id="btitle" class="form-control" value="<%=btitle%>"> 
			</div>	
			<div class="form-group">
			  <label for="bcontent" ><span class="glyphicon glyphicon-plus">CONTENT</span></label>
			  <textarea name="bcontent" cols="60" rows="10"  id="bcontent" class="form-control" ><%=bcontent%></textarea>
			</div>	
			<div class="form-group  text-right">
					 <input type="submit"   value="수정"  class="btn"    >  
					 <input type="reset"   value="취소"   class="btn"    >  
					 <a href="<%=request.getContextPath()%>/list.do" class="btn">목록</a>
			</div>			
		</form>
		<script>
			$(function(){
				$("#modify").submit(function(){
					if($("#bpass").val() =="" )  { alert("빈칸입니다.\n확인부탁드려요."); $("#bpass").focus();     return false; }
			    });
			});
		</script>		
	</div>

<!-- Footer -->
<!-- Footer -->
<!-- Footer -->
<!-- Footer -->
<!-- Footer -->
<!-- Footer -->
<%@  include  file="../inc/footer.jsp" %>