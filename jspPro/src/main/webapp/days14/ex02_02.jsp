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
	// 콜백함수 
	function myMap() {
		// 지도 그릴 옵션 => 객체 생성할때 인자값으로 줄거임
		var lat = ${param.lat};  //위도
		var lng = ${param.lng}; // 경도 
		var mapCenter =  new google.maps.LatLng(lat,lng ); 
		var mapProp={
                        center: mapCenter // 속성1 : 지도의 중앙위치(가운데 위치)를 지정해주는 속성 (위도,경도=> 영국의 위도, 경도값임)
                         , zoom: 15 // 속성2 : 지도의 확대 또는 축소를 설정하는 속성 
		}// mapProp
		var mapCanvas = document.getElementById("googleMap"); 
				
				
		var map = new google.maps.Map(mapCanvas,mapProp); 
		// 지도 객체 생성해서 div에 뿌릴거임 
		var marker = new google.maps.Marker({
			position: mapCenter
//			, animation: google.maps.Animation.BOUNCE
			, icon:"pinkball.png" // 이거 안됨 
		}) //Marker
			marker.setMap(map); 
		
		
		// 정보창(info window) 표시 
		var message = "<a href='http://www.sist.co.kr'><img alt='lezhin.com 로고' src='//img-s-msn-com.akamaized.net/tenant/amp/entityid/BBFwET1.img'></a>"; 
		var infoWindow = new google.maps.InfoWindow({
			content: message
		}); // infoWindow
		infoWindow.open(map,marker)
	}//myMap
/* 	AIzaSyB90--xVzcJ7Fji8PxtHDn0QPEOqrfvA0U */
</script>
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyB90--xVzcJ7Fji8PxtHDn0QPEOqrfvA0U&callback=myMap"></script>
</body>
</html>