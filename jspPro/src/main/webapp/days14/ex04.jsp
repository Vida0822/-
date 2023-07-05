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
<div id = "googleMap" style="width:100%;height:400px"></div>
<script>
function myMap() {
	var lat = 37.49935854213284;  //위도
	var lng = 127.03320798504977; // 경도 
	var mapCenter =  new google.maps.LatLng(lat,lng ); 
	var mapCanvas = document.getElementById("googleMap"); 
	var mapProp={
            center: mapCenter // 속성1 : 지도의 중앙위치(가운데 위치)를 지정해주는 속성 (위도,경도=> 영국의 위도, 경도값임)
             , zoom: 5 // 속성2 : 지도의 확대 또는 축소를 설정하는 속성 
	}// mapProp
	var map = new google.maps.Map(mapCanvas,mapProp); 
	var markerPos = new google.maps.LatLng(lat,lng);
	var marker = new google.maps.Marker({
		position: markerPos
	}) //Marker
	marker.setMap(map); 
	
	// 이벤트 처리 
	var message = "<a href='http://www.naver.com'><img alt='lezhin.com 로고' src='//img-s-msn-com.akamaized.net/tenant/amp/entityid/BBFwET1.img'></a>"; 
		var infoWindow = new google.maps.InfoWindow({
			content: message
		}); // infoWindow
	// open x  -> 정보창 안열림 => 위의 정보창을 마커를 클릭할 때 열거라 
		google.maps.event.addListener(marker, "click", function() { 
			map.setZoom(15);
			map.setCenter(marker.getPosition()); 
			infoWindow.open(map,marker);
			
			window.setTimeout(function() {
				infoWindow.close()
			},3000); // setTimeout
			
		}) ;  // click
}// myMap

</script>

<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyB90--xVzcJ7Fji8PxtHDn0QPEOqrfvA0U&callback=myMap"></script>


</body>
</html>