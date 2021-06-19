<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@  include  file="../inc/header.jsp" %>
<!-- Header -->
<!-- Header -->
<!-- Header -->
<!-- Header -->
<!-- Header -->
<!-- Header -->

	
	<% 
	int bno=Integer.parseInt(request.getParameter("bno"));
	String bcommand = request.getParameter("bcommand");
	%>

	<div class="container  myboard">
		<h3>QNA 비밀번호 확인</h3>
		<form action="<%=request.getContextPath()%>/pass.do?bno=<%=bno%>" method="post"   id="idcheck">
			<input type="hidden"  value="<%=bcommand%>"  id="bcommand"  name="bcommand" />
			<div class="form-group">
			  <label for="bpass"  ><span class="glyphicon glyphicon-plus">PASS</span></label>
			  <input type="password" name="bpass" id="bpass" class="form-control" > 
			</div>	
			<div class="form-group">
				<p>(*)수정, 삭제시 필수입니다.</p> 
			</div>													
			<div class="form-group  text-right">
					 <input type="submit"   value="확인"  class="btn"    >  
					 <input type="button"   id="reset" value="취소"  class="btn"    > 
			</div>	
		</form>
		<script>
			$(function(){
				$("#idcheck").submit(function(){
					if($("#bpass").val() ==""){
						alert("비밀번호를 입력하셔야합니다");
						$("#bpass").focus();
						return false;
					}
				});	
				$("#reset").click(function(){
					history.go(-1);
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