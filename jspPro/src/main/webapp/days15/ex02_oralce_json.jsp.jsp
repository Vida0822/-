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
<style>
#map {
   height: 100%;
}

html, body {
   height: 100%;
   margin: 0;
   padding: 0;
}
</style>
</head>
<body>
 <button id="btnDeleteMarkers">delete marker</button>
 <br>

<div id="map" ></div>

<script>
var customLabel = {
      restaurant : {
         label : 'R'
      },
      bar : {
         label : 'B'
      }
   };

   var markers = [];

   function myMap(){
       // 1.  한독빌딩
      var   lat = 37.49935854213284;
      var   lng=127.03320798504977;
      
      var map = new google.maps.Map(document.getElementById('map'), {
         center : new google.maps.LatLng(lat, lng),
         zoom : 15
      });
      
      // 2.
      var infoWindow = new google.maps.InfoWindow;
      
      // 3. jquery ajax method :   ajax()
      var params = null;
      $.ajax({
         url : "ex02_oracle_json_data.jsp",
         dataType : "json",
         type : "get",
         data : params,
         cache : false,
         success : function(data) { //  []
         // data == [{"id":100,"type":"restaurant","name":"admin","lng":127.03432487024399,"lat":37.49937084987687,"address":"seoul"},{"id":200,"type":"bar","name":"admin","lng":127.03231042642815,"lat":37.49895800057274,"address":"seoul"}]
            $(data).each(
                  function(index, e) {
                     // id, type,name, lng,lat,address
                     var id = e.id;
                     var name = e.name;
                     var address = e.address;
                     var type = e.type;
                     var point = new google.maps.LatLng(
                           parseFloat(e.lat), parseFloat(e.lng));

                     var infowincontent = $("<div />");
                     var strong = $("<strong />").html(name);
                      infowincontent.append(strong).append($("<br>"));

                     var text = document.createElement('text');
                     text.textContent = address;
                      infowincontent.append(text);
                      
                     var icon = customLabel[type] || {};

                     var marker = new google.maps.Marker({
                        map : map,
                        position : point,
                        label : icon.label
                     });
                     
                     marker.addListener('click', function() {
                        infoWindow.setContent(infowincontent.html());
                        infoWindow.open(map, marker);
                     }); 
                     
                     // 모든 마커를 저장했다.
                     markers.push(marker);
                  }); // each
         }
      }); // ajax 
      
   } // myMap
 
   
// 5. 
   $("#btnDeleteMarkers").click(function (){
      for (var i = 0; i < markers.length; i++) {
         markers[i].setMap(null);  // 마커 삭제
      }
   });
</script>
</body>
</html>