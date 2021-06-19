<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@  include  file="../inc/header.jsp" %>
<%@ page import="board.dto.Board" %>
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
		<p><input type="search" id="search1" class="form-control"
			placeholder="검색할 제목을 입력해주세요." title="검색어를 입력해주세요."/></p>
	</div>
	<div class="panel-body">
		<div class="result r1"></div>
		</div>
	</div>
	<script>
		$(function() {
			$("#search1").on("keyup",function() {
				$(".result.r1").empty();
				
				if($(this).val() == "") {
					return false;
				}
				var usersearch = $ (this).val();
				$(".result.r1").empty();
				$.ajax({url:"<%=request.getContextPath()%>/search1.do",
					ttpe : "get",
					dataType : "text",
					data : {"btitle":usersearch },
					success : function(text) {
						console.log(text);
						$(".result.r1").append(text.trim());
					},
					error:function(khr,textStatus,errorThrown) {
						$(".result.r1").html(textStatus + "(HTTP-" + khr.status + "/" + errorThrown + ")" );
					}
				});
			});
		});
	
	</script>
	
	
	
<!--  보드 시작!!!!!!!!!!!!!!!!!!  -->			
	<div class="container  myboard">
		<h3> BOARD - BASIC </h3>
		<table class="table table-stripped">
			<caption>MULTIBOARD</caption>
			<colgroup>
				<col style="width:15%"/><col style="width:40%"/><col style="width:10%"/>
				<col style="width:25%"/><col style="width:10%"/>
			</colgroup>
			<thead>
				<tr>
					<th scope="col">NAME</th><th scope="col">TITLE</th><th scope="col">WRITER</th>
					<th scope="col">DATE</th><th scope="col">HIT</th> 
				</tr>
			</thead>
			<tbody>
	 		<% 
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			/* Board board=(Board)request.getAttribute("list");
			Board listcount=(Board)request.getAttribute("listcount"); */
			
			ArrayList <Board> list=new ArrayList<Board>();
			
			if(request.getAttribute("list1")!=null) {
				list.addAll((ArrayList<Board>)request.getAttribute("list1"));
			}else {
				out.println("null");
			}
			
			Iterator<Board> iter=list.iterator();
			int all=(int)request.getAttribute("listcount1");
			while(iter.hasNext()){
				Board rset=iter.next();
				/* String btitle=rset.getBtitle();
				String bname=rset.getBname();
				String bdate=rset.getBdate();
				int bhit=rset.getBhit(); */
				
				out.println("<tr><td>"+(all--)+"</td>"+
				"<td><a href='"+ request.getContextPath()+"/detail.do?bno="+rset.getBno()+"'>"
				+rset.getBtitle()+"</a></td>"+
				"<td>"+rset.getBname()+"</td>"
				+"<td>"+rset.getBdate()+"</td>"+
				"<td>"+rset.getBhit()+"</td></tr>");
			}
			
			%>  
			
			
			
			
			
				<c:if test="${pagetotal > end_page}">
				<c:set var="test" value="${endpage*onepagelimit}"/>
				<a href="list.do?pstartno=${next}">다음</a>
				</c:if>
				
				
				
			</tbody>
				
			<tfoot>
				<tr  class="text-right">
					<td colspan="5" ><a href="<%=request.getContextPath()%>/write_view.do" class="btn">글쓰기</a> </td>
				</tr>
			</tfoot>
		</table>
	</div><!-- CONTAINER END -->

<!-- Footer -->
<!-- Footer -->
<!-- Footer -->
<!-- Footer -->
<!-- Footer -->
<!-- Footer -->
<%@  include  file="../inc/footer.jsp" %>