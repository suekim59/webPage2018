<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="container">
	<h3> DAUM - API </h3>
	<p><input type="button" value="PATH01" id="PATH01"/>
		<input type="button" value="PATH02" id="PATH02"/>
		<input type="button" value="PATH03" id="PATH03"/>
	</p>
	
	<script>
	result=0;
		$(function() {
			
			map1(37.5866076,126.97481100000005);
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
 
 <!-- search -->




</div>

</body>
</html>