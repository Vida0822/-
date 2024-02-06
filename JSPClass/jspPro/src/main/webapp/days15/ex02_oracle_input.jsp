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
<div id = "map" style="width:100%;height:400px"></div>
<!-- Modal -->
   <div class="modal fade" id="myModal" role="dialog">
      <div class="modal-dialog" style="width: 350px">

         <!-- Modal content-->
         <div class="modal-content">
            <div class="modal-header">
               <h4 class="modal-title">위치 정보 입력</h4>
            </div>
            <div class="modal-body"> 
               <div style="text-align: center">
                  <form id="form1" action="ex02_oracle_input_ok.jsp" method="post">
                     <table style="width:300px;text-align: center" border="1">
                     
                        <tr><td>ID</td></tr>
                        <tr><td><input type="text" name="id" value="100"></td></tr>
                        <tr><td>TYPE</td></tr>
                        <tr><td><input type="text" name="type" value="restaurant or bar"></td></tr>
                        <tr><td>NAME</td></tr>
                        <tr><td><input type="text" name="name" value="admin"></td></tr>
                        <tr><td>ADDRESS</td></tr>
                        <tr><td><input type="text" name="address" value="seoul"></td></tr>
                        <tr>
                           <td><input type="button" id="btnSave" value="저장"></td>
                        </tr>
                     </table>
   <input type="hidden" id="h_lat" name="lat" value="" />
   <input type="hidden" id="h_lng" name="lng" value="" />
                  </form>
               </div>

            </div>
            <div class="modal-footer">
               <button type="button" onclick="modal_close();" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
         </div>

      </div>
   </div>
<script>
   //한독빌딩 위도,경도 
   var lat = 37.49935854213284;
   var lng = 127.03320798504977;
   
   function myMap(){
      // 1. div id=map    한독빌딩이 중심으로 지도가 출력.
      var mapCanvas = document.getElementById("map");
      var myCenter = new google.maps.LatLng(lat, lng); // 
      var mapOptions = {
         center : myCenter,
         zoom : 15
      };
      var map = new google.maps.Map(mapCanvas, mapOptions);
      // 2.  지도를 클릭할 때 클릭된 위치를 맛집으로 등록할 예정.
      google.maps.event.addListener(map, 'click', function(event) {
         placeMarker(map, event.latLng);
         
         $('#h_lng').val(event.latLng.lng());
         $('#h_lat').val(event.latLng.lat());
         
         // 입력하기 위한 모달창 띄우도록 할게요.
         $("#myModal").modal("show");
      } ); // 2
   } // myMap
   
   function placeMarker(map, location) {
       
      marker = new google.maps.Marker({
         position : location,  
         map : map
      });
      // 
      var infowindow = new google.maps.InfoWindow({
         content : 'Latitude: ' + location.lat() + '<br>Longitude: '   + location.lng()
      });

      infowindow.open(map, marker);
   }
</script>

<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyB90--xVzcJ7Fji8PxtHDn0QPEOqrfvA0U&callback=myMap"></script>

</body>
</html>