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

<a href='ex02.jsp'>ex02.jsp</a>
<div id="googleMap" style="width:100%;height:400px"></div>

<script>
   function myMap(){
      var mapOptions = {
                                         center: new google.maps.LatLng(51.508742, -0.120850)
                                          , zoom: 5
                                      }; 
      var map = new google.maps.Map( 
                                                            document.getElementById("googleMap")  
                                                            , mapOptions 
                                                               );
   }
</script>

<script src="https://maps.googleapis.com/maps/api/js?key=yourkey&callback=myMap"></script>
<!--  이 key값 우리가 가입해서 받아둬야함! ! !  -->
</body>
</html>