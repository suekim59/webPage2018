<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="board.dto.Board"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 추가 필요 -->







<c:if test="${list1 !=null}">
	<table class="table table-stripped">
		<caption>MULTIBOARD</caption>
		<colgroup>
			<col style="width: 25%" />
			<col style="width: 20%" />
			<col style="width: 25%" />
			<col style="width: 10%" />
		</colgroup>
		<thead>
			<tr>
				<th scope="col">TITLE</th>
				<th scope="col">WRITER</th>
				<th scope="col">DATE</th>
				<th scope="col">HIT</th>
			</tr>
		</thead>
		<tbody>

			<c:forEach var="board" items="${list1}" varStatus="status">
				<tr>
					<td><a href="detail.do?bno=${board.bno}">${board.btitle}</a></td>
					<td>${board.bname}</td>
					<td>${board.bdate}</td>
					<td><span class='badge badge-danger'>${board.bhit}</span></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</c:if>













