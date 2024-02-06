/**
 * httpReqeust.js
 */

var httpRequest = null;

function getXMLHttpRequest(){
   if(window.ActiveXObject){  // IE          6
      try {
         return new ActiveXObject("Msxml2.XMLHTTP");
      } catch (e) {
         try {
            return new ActivXObject("Microsoft.XMLHTTP");
         } catch (e) {
            return null;
         }

      }
   }else if(window.XMLHttpRequest){
      return new XMLHttpRequest();       
   }else {
      return null;
   }
}

//  ajax 처리할때 요청할 url, 파라미터, 콜백함수등록, get/post
function sendRequest(url,params,callback,method){ 
   // 1. xhr 객체얻기
   httpRequest = getXMLHttpRequest();
   // 2.   콜백함수 호출 
   httpRequest.onreadystatechange = callback;    
   
   
   var httpMethod= method?method:'GET';    // 값이 있으면 그값그대로 : 값이없으면 'GET'
   if(httpMethod!='GET' && httpMethod!='POST') httpMethod='GET'; // httpMethod가 get이 아니고 post도 아니면 GET 
// 이거 굳이 왜 두번해준거임 ? 
    
   // id=admin&age=20
   // null
   var httpParams = (params==null||params=="")?null:params;
   
   var httpUrl = url;
   
   if(httpMethod=='GET' && httpParams != null){
      httpUrl= httpUrl +"?"+httpParams;
   }     
   
   httpRequest.open(httpMethod,httpUrl,true); // true 비동기적..
   // [XMLHTTP를 사용해서 통신할 때 규약] 
   // httpRequest.setRequestHeader('Content-Type','application/x-www-form-unlencoded');    
   httpParams = (httpMethod=='POST'?httpParams:null );
   httpRequest.send( httpParams); // 요청처리...
}