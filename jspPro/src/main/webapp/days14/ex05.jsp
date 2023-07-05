<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String contextPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<pre>
	지도상의 마우스를 클릭하면 클릭된 위치에 마커와 정보창을 출력(클릭된 위치의-위도, 경도)
</pre>
<div id = "googleMap" style="width:100%;height:400px"></div>
<script>
	var lat = 37.49935854213284;  //위도
	var lng = 127.03320798504977; // 경도 
	
	function myMap() {
		var mapCenter =  new google.maps.LatLng(lat,lng ); 
		var mapCanvas = document.getElementById("googleMap"); 
		
		var mapProp={
                center: mapCenter // 속성1 : 지도의 중앙위치(가운데 위치)를 지정해주는 속성 (위도,경도=> 영국의 위도, 경도값임)
                 , zoom: 15 // 속성2 : 지도의 확대 또는 축소를 설정하는 속성 
			}// mapProp
		var map = new google.maps.Map(
				mapCanvas
				,mapProp
				); 
		// 1. 지도상에 클릭 이벤트 처리 해줄거임 
		map.addListener("click",(event)=>{
			// alert(event.latLng) // (37.50067502710594, 127.02848729718353) => 엥 나 이ㅓ 계속 같은 좌표 나오는데
			// 그 위치에 마커 출력 함수 
			placeMarker(map,event.latLng); 
		} )// click
	}// myMap
	
	
	function placeMarker(map,markerCenter) {
		//1. 
		var marker = new google.maps.Marker({
			position: markerCenter
		}) //Marker
		marker.setMap(map); 
		
		// 2. 
		var message = "Latitute: +"+markerCenter.lat()
							+"<br>Logitude :" +markerCenter.lng(); 
		var infoWindow = new google.maps.InfoWindow({
			content: message
		}); // infoWindow
		infoWindow.open(map,marker) 
	}// placeMarker
</script>
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyB90--xVzcJ7Fji8PxtHDn0QPEOqrfvA0U&callback=myMap"></script>
</body>
</html>