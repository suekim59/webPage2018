<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head><meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>



</head>
<body>
		<div class="result r5">
	<script>
	//파싱하고 링크 걸기
		$(function() {
			$.ajax({
				url : "naver_search",    //naver_search 서블릿으로 이동
				type : "get",
				dataType : "json",  
				success:function(naverdata) {
					//naverdata라는 이름으로 가지고 오는 것
					
					/* console.log(naverdata);
					console.log(naverdata.items);
					console.log(naverdata.items[0]); */
					
					var items=naverdata.items;
					//배열로 넣는 것.
					
					for(var i=0;i<items.length;i++) {
						
						var tr=$("<tr>");
						var title=$("<td>").html(items[i].title);
						var link=$("<td>").html("<a href='"+items[i].link+"'>"+items[i].link);
						var description=$("<td>").html(items[i].description);
						var bloggername=$("<td>").html(items[i].bloggername);
						var bloggerlink=$("<td>").html("<a href='"+items[i].bloggerlink+"'>"+items[i].bloggerlink);
						
						tr.append(title).append(link).append(description).append(bloggername).append(bloggerlink);
						
						$(".result.r5 tbody").append(tr);
						
					}
					
					
				},
				error : function() {
					
				}
				
			});
			
		});
	
	</script>
	<table class="table table-striped">
		<thead>
			<tr><th></th></tr>
		</thead>
		<tbody>
		
		
		</tbody>
		<tfoot>
		</tfoot>	
	</table>
	</div>




</body>
</html>