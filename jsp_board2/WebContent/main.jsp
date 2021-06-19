<%@page import="java.util.Iterator"%>
<%@page import="board.dto.Board"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 추가 필요 -->
<%@  include file="../inc/header.jsp"%>


<div id="myCarousel" class="carousel slide">
	<!-- Indicators -->
	<ol class="carousel-indicators">
		<li class="item1 active"></li>
		<li class="item2"></li>
		<li class="item3"></li>
		<li class="item4"></li>
		<li class="item5"></li>
	</ol>

	<!-- Wrapper for slides -->
	<div class="carousel-inner" role="listbox">

		<div class="item active">
			<img src="<%=request.getContextPath()%>/images/avengers1.jpg" alt=""
				width="460" height="345">
			<div class="carousel-caption">
				<h3>avengers1</h3>
			</div>
		</div>

		<div class="item">
			<img src="<%=request.getContextPath()%>/images/avengers2.jpg" alt="">
			<div class="carousel-caption">
				<h3>avengers2</h3>
			</div>
		</div>

		<div class="item">
			<img src="<%=request.getContextPath()%>/images/avengers3.jpg" alt="">
			<div class="carousel-caption">
				<h3>avengers3</h3>
			</div>
		</div>

		<div class="item">
			<img src="<%=request.getContextPath()%>/images/avengers4.jpg" alt="">
			<div class="carousel-caption">
				<h3>avengers4</h3>
			</div>
		</div>

		<div class="item">
			<img src="<%=request.getContextPath()%>/images/avengers5.jpg" alt="">
			<div class="carousel-caption">
				<h3>avengers5</h3>
			</div>
		</div>

	</div>

	<!-- Left and right controls -->
	<a class="left carousel-control" href="#myCarousel" role="button">
		<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
		<span class="sr-only">Previous</span>
	</a> <a class="right carousel-control" href="#myCarousel" role="button">
		<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
		<span class="sr-only">Next</span>
	</a>
</div>

<script>
	$(document).ready(function() {
		// Activate Carousel
		$("#myCarousel").carousel();

		// Enable Carousel Indicators
		$(".item1").click(function() {
			$("#myCarousel").carousel(0);
		});
		$(".item2").click(function() {
			$("#myCarousel").carousel(1);
		});
		$(".item3").click(function() {
			$("#myCarousel").carousel(2);
		});
		$(".item4").click(function() {
			$("#myCarousel").carousel(3);
		});

		// Enable Carousel Controls
		$(".left").click(function() {
			$("#myCarousel").carousel("prev");
		});
		$(".right").click(function() {
			$("#myCarousel").carousel("next");
		});
	});
</script>


<!-- end 넘기기   -->
<!-- end 넘기기   -->
<!-- end 넘기기   -->
<!-- end 넘기기   -->
<!-- end 넘기기   -->

<div  class="container-fluid  myboard">
<div class="row" >
	<div class="col-sm-6 ">
	  <div class="row">
		<h3 class="col-sm-6">Gallery Board </h3>
		<div class="form-group col-sm-6 myright">
			<a href="<%=request.getContextPath()%>/write_view2.do" class="btn">글쓰기</a>
		</div>
	   </div>	
		<div class=" text-center row">
			<c:forEach var="board" items="${boards2}" varStatus="status">
				<div class="col-sm-3" style="">
					<div class="thumbnail" style="border-style: solid;">
						<!--  갤러리 형식으로 보여줌. -->
						<p>
							<span class='badge badge-danger'>${board.bhit}</span>
						</p>
						<img src="/upload/${board.bfile}" alt="" width="50%" height="50%" />
						<!--  갤러리 이미지 크기를 다 동일하게 하려면 -->
						<p>
							<strong>작성자 : ${board.bname}</strong>
						</p>
						<p>제목 : ${board.btitle}</p>
						<p>날짜 : ${board.bdate}</p>
						<p>
							<a href="detail2.do?bno=${board.bno}" class="btn">상세보기</a>
						</p>
					</div>
				</div>

			</c:forEach>
		</div>
	</div>


	<!-- 보드2 게시판 -->

	<%-- <div class="container" style="min-height: 796px">
		<h3>BOARD-BASIC</h3>
		
		<div class="row text-center">
			<c:forEach var="board" items="${list2}" varStatus="status">
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
					<div class="text-right">
					<a href="<%=request.getContextPath()%>/write_view2.do" class="btn">글쓰기</a>
					</div>
			
		</div>
	</div>  --%>




	<div class="col-sm-6">
		<div class=" ">
			<h3>BOARD - BASIC</h3>
			<table class="table table-stripped">
				<caption>MULTIBOARD</caption>
				<colgroup>
					<col style="width: 15%" />
					<col style="width: 40%" />
					<col style="width: 10%" />
					<col style="width: 25%" />
					<col style="width: 10%" />
				</colgroup>
				<thead>
					<tr>
						<th scope="col">NAME</th>
						<th scope="col">TITLE</th>
						<th scope="col">WRITER</th>
						<th scope="col">DATE</th>
						<th scope="col">HIT</th>
					</tr>
				</thead>
				<tbody>
					<%
						request.setCharacterEncoding("utf-8");
						response.setCharacterEncoding("utf-8");
						response.setContentType("text/html;charset=utf-8");
						/* Board board=(Board)request.getAttribute("list");
						Board listcount=(Board)request.getAttribute("listcount"); */

						ArrayList<Board> list = new ArrayList<Board>();

						if (request.getAttribute("list1") != null) {
							list.addAll((ArrayList<Board>) request.getAttribute("list1"));
						} else {
							out.println("null");
						}

						Iterator<Board> iter = list.iterator();
						int all = (int) request.getAttribute("listcount1");
						while (iter.hasNext()) {
							Board rset = iter.next();
							/* String btitle=rset.getBtitle();
							String bname=rset.getBname();
							String bdate=rset.getBdate();
							int bhit=rset.getBhit(); */

							out.println("<tr><td>" + (all--) + "</td>" + "<td><a href='" + request.getContextPath()
									+ "/detail.do?bno=" + rset.getBno() + "'>" + rset.getBtitle() + "</a></td>" + "<td>"
									+ rset.getBname() + "</td>" + "<td>" + rset.getBdate() + "</td>" + "<td>" + rset.getBhit()
									+ "</td></tr>");
						}
					%>

				</tbody>
				<tfoot>
					<tr class="text-right">
						<td colspan="5"><a
							href="<%=request.getContextPath()%>/write_view.do" class="btn">글쓰기</a>
						</td>
					</tr>
				</tfoot>
			</table>
		</div>
	</div>
	
	
	</div>
</div>





<%@  include file="../inc/footer.jsp"%>
