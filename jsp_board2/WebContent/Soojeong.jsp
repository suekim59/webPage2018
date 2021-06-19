<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="http://cdn.ckeditor.com/4.4.7/standard/ckeditor.js"></script>
<%@ include file="../inc/header.jsp" %>

<div class="container" style="min-height: 300px;">

	
	<script>
		$(document).ready(function() {
			$("#contact").click(function() {
				if($("#sender_name").val()=="") {
				alert("이메일칸이 빈칸입니다.\n(Please fill in the email blank.)");
				$("#sender_name").focus();
				return false;
			}

				if($("#sender_title").val()=="") {
				alert("제목칸이 빈칸입니다.\n(Please fill in the title blank.)");
				$("#sender_title").focus();
				return false;
			}
	
				if(CKEDITOR.instances.sender_content.getData().length < 1) {
				alert("글내용칸이 빈칸입니다.\n(Please fill in the content blank.)");
				$(CKEDITOR.instances.sender_content).focus();	
				return false;
			}
				
				$.ajax({url : "<%=request.getContextPath()%>/contact.do",  
					type:"post",
					dataType:"text",
					data : {
						"sender_name":$("#sender_name").val(),
						"sender_title":$("#sender_title").val(),
						"sender_content":CKEDITOR.instances.sender_content.getData(),
						"forme" : $("#forme").val()
						}, //값을 넘기려면 이 과정이 필요.
					success : function(data){ //result는 string으로 받아짐.
						$("#sender_name").val("");
						$("#sender_title").val("");
						CKEDITOR.instances.sender_content.setData("<p></p>");
						alert("메일보내기 성공");
						$("#forme").prop('checked',false);
						$("#").html(data);
					},
					error : function(xhr, textStatus, errorThrown) {
						alert (textStatus + "(HTTP)" + xhr.status+"/"+ errorThrown);
				}
				
			});
		});
	});
		
		
		//체크박스 만들어서 본인한테도 보내도록 하기
	</script>
	<h3><span class="glyphicon glyphicon-cog"></span>CONTACT ME</h3>
	
		<div class="form-group">
			<label for="sender_name">이메일(Email)</label>
			<input type="email" name="sender_name" id="sender_name" class="form-control">
		</div>
		<div class="form-group">
			<label for="sender_title">글제목(Title)</label>
			<input type="text" name="sender_title" id="sender_title" class="form-control">
		</div>
		<div class="form-group">
			<label for="sender_content">글내용(Content)</label>
			<textarea name="sender_content" id="sender_content" rows="3" ></textarea>		
		</div>
			<script>
			   CKEDITOR.replace( 'sender_content' );
			</script>
			<div class="form-group">
			<input type="checkbox" name="forme" id="forme" />
			<label for="forme">나에게도 메일 보내기(For Confirmation, Send it to Yourself.)</label>
		</div>
			<input type="button" id="contact" name= "contact" class="btn" value="Submit">

	

</div>

	<!-- Soojeong에 대한 내용 더 추가...? -->
	<div class="container" style="min-height: 1000px;">
	<h3> VISIT US </h3>
	<p><input type="button" value="OFFICE01" id="PATH01"/>
		<input type="button" value="OFFICE02" id="PATH02"/>
		<input type="button" value="OFFICE03" id="PATH03"/>
	</p>
	
	<script>
	
		$(function() {
			
			map1(37.5662952,126.97794509999994);
			
			$("#PATH01").click(function() {
				map1(37.5058916,127.05606280000006);
				
			});
			$("#PATH02").click(function() {
				map1(37.5111158,127.09816699999999);
			
			});
			$("#PATH03").click(function() {
				map1(37.5193776,126.94021029999999);
				
			});
		});
	</script>

<div id="map" style="width:100%;height:350px;"></div>
<div id="clickLatlng"></div>	
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=749d92f582c2cea893fe38c77fa736c5"></script> 

<script>
	function map1(num1,num2) { 
		
		var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
	    mapOption = { 
		
				 center: new daum.maps.LatLng(num1, num2), 
		
		 			level: 3 // 지도의 확대 레벨
	   			 };

			var map = new daum.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
			
			// 지도를 클릭한 위치에 표출할 마커입니다
			var marker = new daum.maps.Marker({ 
			    // 지도 중심좌표에 마커를 생성합니다 
			    position: map.getCenter() 
			}); 
			// 지도에 마커를 표시합니다
			marker.setMap(map);
			
			// 지도에 클릭 이벤트를 등록합니다
			// 지도를 클릭하면 마지막 파라미터로 넘어온 함수를 호출합니다
			daum.maps.event.addListener(map, 'click', function(mouseEvent) {        
			    
			    // 클릭한 위도, 경도 정보를 가져옵니다 
			    var latlng = mouseEvent.latLng; 
			    
			    // 마커 위치를 클릭한 위치로 옮깁니다
			    marker.setPosition(latlng);
			    
			    var message = '클릭한 위치의 위도는 ' + latlng.getLat() + ' 이고, ';
			    message += '경도는 ' + latlng.getLng() + ' 입니다';
			    
			    var resultDiv = document.getElementById('clickLatlng'); 
			    resultDiv.innerHTML = message;
			    
			});
				
				
 }	
 </script>
 


</div>



<%@ include file="../inc/footer.jsp" %>