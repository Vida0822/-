package days12;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

 
public class UploadServlet extends HttpServlet{

   @Override
   protected void doGet(HttpServletRequest request
         , HttpServletResponse response) throws ServletException, IOException {
       
   }

   @Override
   protected void doPost(HttpServletRequest request
         , HttpServletResponse response) throws ServletException, IOException {
      response.setContentType("text/html; charset=UTF-8");
      // getParts() -> Part 객체
      Collection<Part> parts =  request.getParts();
      
      PrintWriter writer = response.getWriter();
      writer.println("<html><body>");
      
      String contentType = request.getContentType();
      //  첨부파일 존재
      if (contentType != null && contentType.toLowerCase().startsWith("multipart/")) {
         printPartInfo(request, writer);
      } else {
         writer.println("multipart가 아님");
      }
      
      writer.println("</body></html>");
      
   } // doPost
   
   private void printPartInfo(HttpServletRequest request, PrintWriter writer)
         throws IOException, ServletException {
      // 첨부 파일이 여러 개 일 경우 : request.getParts() 메서드로 Part 객체를 컬렉션으로 얻어온다.
      // Part 객체 
      Collection<Part> parts = request.getParts();
   
      for (Part part : parts) {
         
         writer.println("<br/> name = " + part.getName()); // 파라미터 이름
         String contentType = part.getContentType();           // 컨텐츠 타입
         writer.println("<br/> contentType = " + contentType);
         
         //                                                        첨부된 파일명
         if (part.getHeader("Content-Disposition").contains("filename=")) {
            
            writer.println("<br/> size = " + part.getSize());
            String fileName = part.getSubmittedFileName(); // 업로드 파일 이름
            writer.println("<br/> filename = " + fileName);
            if (part.getSize() > 0) {                               // 업로드 파일 크기
               part.write("c:\\temp\\" + fileName);             // 업로드한 파일을 지정한 파일에 복사 => 여기 없는데...?? 이 폴더명이랑 똑같은거 없으면 fileNotfountDrrir
               part.delete();                                     // 임시 파일 삭제
            }
            
         } else {
            String value = request.getParameter(part.getName());
            writer.println("<br/> value = " + value);
         }
         writer.println("<hr/>");
      } // for
   
   } // method

}






