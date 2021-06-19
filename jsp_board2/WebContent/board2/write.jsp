<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@  include  file="../inc/header.jsp" %>
	<div class="container  myboard">
	
		<h3>QNA 글작성</h3>
		<form action="<%=request.getContextPath()%>/write2.do" method="post"  id="write" enctype="multipart/form-data">
			<div class="form-group">
			  <label for="bname"  ><span class="glyphicon glyphicon-plus">NAME</span></label>
			  <input type="text" name="bname" id="bname" class="form-control" > 
			</div>
			<div class="form-group">
			  <label for="bpass"  ><span class="glyphicon glyphicon-plus">PASS</span></label>
			  <input type="password" name="bpass" id="bpass" class="form-control" > 
			</div>										
			<div class="form-group">
			  <label for="btitle"  ><span class="glyphicon glyphicon-plus">TITLE</span></label>
			  <input type="text" name="btitle" id="btitle" class="form-control" > 
			</div>	
			<div class="form-group">
			  <label for="bcontent" ><span class="glyphicon glyphicon-plus">CONTENT</span></label>
			  <textarea name="bcontent"  cols="60" rows="10" id="bcontent" class="form-control"></textarea>
			</div>	
			<div class="form-group">
			<label for="uploadFile">파일업로드</label>
			<input type="file" name="uploadFile" id="uploadFile" class="form-control">
			</div>
			<div class="form-group  text-right">
					 <input type="submit"   value="글쓰기"  class="btn"    >  
					 <input type="reset"   value="취소"  class="btn"    >   
					 <a href="<%=request.getContextPath()%>/list2.do"   class="btn"   >목록보기</a>
			</div>	
		</form>
		<script>
			$(function(){
				$("#write").submit(function(){
					if($("#bname").val() =="" )  { alert("빈칸입니다.\n확인부탁드려요."); $("#bname").focus();     return false; }
					if($("#bpass").val() =="" )  { alert("빈칸입니다.\n확인부탁드려요."); $("#bpass").focus();     return false; }
					if($("#btitle").val() =="")  { alert("빈칸입니다.\n확인부탁드려요."); $("#btitle").focus();    return false; }
					if($("#bcontent").val() ==""){ alert("빈칸입니다.\n확인부탁드려요."); $("#bcontent").focus();  return false; }
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