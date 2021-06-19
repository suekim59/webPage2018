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
	
		<h3>QNA 수정하기</h3>	
		<form action="<%=request.getContextPath()%>/update2.do?bno=${dto.bno}&bfile=${dto.bfile}" method="post"  id="modify" enctype="multipart/form-data">
			<div class="form-group">
			  <label for="bname"  ><span class="glyphicon glyphicon-plus">NAME</span></label>
			  <input type="text" name="bname" id="bname" class="form-control" value="${dto.bname}" disabled > 
			</div>									
			<div class="form-group">
			  <label for="btitle"  ><span class="glyphicon glyphicon-plus">TITLE</span></label>
			  <input type="text" name="btitle" id="btitle" class="form-control" value="${dto.btitle}"> 
			</div>	
			<div class="form-group">
			  <label for="bcontent" ><span class="glyphicon glyphicon-plus">CONTENT</span></label>
			  <textarea name="bcontent" cols="60" rows="10"  id="bcontent" class="form-control" >${dto.bcontent}</textarea>
			</div>	
			<div class="form-group">
			<label for="uploadFile">File</label>
			<input type="file" name="uploadFile" id="uploadFile" class="form-control">
			</div>
			<div  class="panel-body"><img src="/upload/${dto.bfile}" alt="" height="20%"/></a>
			</div>	
			<div class="form-group  text-right">
					<%-- <input type="hidden" name="bfile" value="${dto.bfile}"> --%>
					 <input type="submit"   value="수정"  class="btn"    >  
					 <input type="reset"   value="취소"   class="btn"    >  
					 <a href="<%=request.getContextPath()%>/list2.do" class="btn">목록</a>
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