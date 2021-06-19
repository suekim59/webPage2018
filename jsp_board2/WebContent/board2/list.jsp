<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@  include  file="../inc/header.jsp" %> 
 <%@ page import="board.dto.Board2" %>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!-- 추가 필요 -->
 
<!-- Header -->
<!-- Header -->
<!-- Header -->
<!-- Header -->
<!-- Header -->
<!-- Header -->


	
	<div class="container panel panel-default">
	<h3 class="panel-heading">BOARD SEARCH</h3>
	<div>
		<p><input type="search" id="search2" class="form-control"
			placeholder="검색할 제목을 입력해주세요." title="검색어를 입력해주세요."/></p>
	</div>
	<div class="panel-body">
		<div class="result r2"></div>
		</div>
	</div>
	<script>
		$(function() {
			$("#search2").on("keyup",function() {
				$(".result.r2").empty();
				if($(this).val() == "") {
					return false;
				}
				var usersearch = $ (this).val();
				$(".result.r2").empty();
				$.ajax({url:"<%=request.getContextPath()%>/search2.do",
					type : "get",
					dataType : "text",
					data : {"btitle":usersearch },
					success : function(text) {
						console.log(text);
						$(".result.r2").append(text.trim());
					},
					error:function(khr,textStatus,errorThrown) {
						$(".result.r2").html(textStatus + "(HTTP-" + khr.status + "/" + errorThrown + ")" );
					}
				});
			});
		});
	
	</script>
	


	<div class="container" style="min-height: 796px">
		<h3>BOARD-BASIC</h3>
		<div class="text-right" style="min-height: 50px" >
					<a href="<%=request.getContextPath()%>/write_view2.do" class="btn">글쓰기</a>
		</div>
		<div class="row text-center">
			<c:forEach var="board" items="${boards2}" varStatus="status">
			<div class="col-sm-3" style="">
					<div class="thumbnail"  style="border-style:solid;"> <!--  갤러리 형식으로 보여줌. -->
						<p><span class='badge badge-danger'>${board.bhit}</span></p>
						<img src="/upload/${board.bfile}" alt="" width="50%" height="50%" /> 
						<!--  갤러리 이미지 크기를 다 동일하게 하려면 -->
						<p><strong>작성자 : ${board.bname}</strong></p>
						<p>제목 : ${board.btitle}</p>
						<p>날짜 : ${board.bdate}</p>
						<p><a href="detail2.do?bno=${board.bno}" class="btn">상세보기</a></p>
						</div>
						</div>
				</c:forEach>
					
			
		</div>
	</div> 

	<div class="row text-center">
		<p>
			<c:if test="${start_page!=1}">
				<a
					href="<%=request.getContextPath()%>/list2.do?pstartno=${(start_page-2)*10}">[이전]</a>
			</c:if>

			<c:forEach begin="${start_page}" end="${end_page}" varStatus="status">
				<c:if test="${pagetotal>end_page}">
					<c:set var="page" value="${pagetotal}"></c:set>

				</c:if>
				<c:choose>
					<c:when test=""></c:when>
					<c:when test="${status.index == current_page}">
						<a style="font-style: italic; color: maroon;"
							href="<%=request.getContextPath()%>/list2.do?pstartno=${(status.index-1)*10}">${status.index}</a>
					</c:when>
					<c:otherwise>
						<a
							href="<%=request.getContextPath()%>/list2.do?pstartno=${(status.index-1)*10}">${status.index}</a>
					</c:otherwise>
				</c:choose>
			</c:forEach>

			<c:if test="${pagetotal>end_page}">
				<a
					href="<%=request.getContextPath()%>/list2.do?pstartno=${end_page*10}">[다음]</a>
			</c:if>
		</p>
	</div>




<!-- Footer -->
<!-- Footer -->
<!-- Footer -->
<!-- Footer -->
<!-- Footer -->
<!-- Footer -->
<%@  include  file="../inc/footer.jsp" %>