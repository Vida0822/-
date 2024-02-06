<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<link rel="stylesheet" href="/fileUploadPro/cdn/example.css">
<script src="/fileUploadPro/cdn/example.js"></script>

</head>
<body>

<div>
   <div class="uploadDiv">
     <input type="file" name="uploadFile" multiple="multiple">
     <button id="uploadFile" style="vertical-align:top; top: 2px">  Upload File </button>
   </div>
   <div class="uploadResult">
     <ul>
     </ul>
   </div>   
</div>
<script>
  $(function (){
     
     var regex = /(.*?)\.(exe|sh|alz)$/i;
     var maxSize = 1024*1024*50; // 5M
     
     function checkExtension(fileName, fileSize){
      if( fileSize > maxSize ){
         alert("파일 사이즈 초과");
         return false;
      }  
      if(regex.test(fileName)){
         alert("해당 종류의 파일을 업로드할 수 없습니다.");
         return false;
      }
      return true;
     }
     
     $("#uploadFile").on("click", function (event){
        var formData = new FormData();
        var inputFile = $("input[name='uploadFile']");
        var files = inputFile[0].files;
        //console.log(files)
        for (var i = 0; i < files.length; i++) {
           if(!checkExtension(files[i].name, files[i].size)){
              return false;
           }
         formData.append("uploadFile", files[i]);
       } // for
       
       $.ajax({
          url:'/fileUploadPro/uploadAjaxAction.ajax',
          processData: false,
          contentType: false,
          data:formData,
          type:'POST',
          dataType:'json',
          success: function ( result ){
             console.log(result);
             
             var content = "";
             $(result).each(function(i, element) {
                if( element.image ){
                   //content += "<li><img src='"+  encodeURIComponent(element.uploadPath) +"' width='50px'>"+element.fileName+"</li>";
                   content += "<li><img src='"+  element.uploadPath +"' width='50px'>"+element.fileName+"</li>";
                }else{                   
                   content += "<li><img src='/fileUploadPro/images/attach.jpg' width='50px'>"+element.fileName+"</li>";
                }
             });
             $(".uploadResult ul").append(content);
          }
       }); // $.ajax
     });
  });
</script>
</body>
</html>