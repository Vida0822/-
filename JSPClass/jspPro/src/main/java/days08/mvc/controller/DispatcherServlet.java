package days08.mvc.controller;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import days08.mvc.command.CommandHandler;

// MV[C] 컨트롤러
// 10:00 수업 시작~ 
public class DispatcherServlet extends HttpServlet{
   
   private static final long serialVersionUID = -3613785051622608035L;
    //          /board/list.do ListHandler
   private Map<String, CommandHandler> commandHandlerMap = new HashMap<>();
   
   @Override
   public void init() throws ServletException {
      // 초기화 
      String path = this.getInitParameter("path"); 
      String realPath = this.getServletContext().getRealPath(path);
      // realPath : E:\Class\SS18Class\Workspace\JSPClass\.metadata
      // \.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps
      // \jspPro\WEB-INF\commandHandler.properties
      // System.out.println( "realPath : "  + realPath  );
      
      Properties prop = new Properties();
      try( FileReader reader = new FileReader(realPath) ) {
         prop.load(reader);
      } catch (Exception e) {  
         throw new ServletException();
      }
      // commandHandlerMap <- 엔트리( 요청URL key,  커맨드핸들러객체 value )
      Set<Entry<Object, Object>> set =prop.entrySet(); 
      // entrySet() : Map에 저장된 키오 값을 결합해 'entry' 객체로 Set에 저장 => 반환 : SET 
      Iterator<Entry<Object, Object>>  ir = set.iterator();
      while (ir.hasNext()) {
         Entry<Object, Object> entry =  ir.next(); // SET에서 하나씩 Entry 객체를 뽑아와서 
         String url = (String)entry.getKey(); 
         String className = (String)entry.getValue();
         // WriteHandler wh = new WriteHandler();         
         Class<?> commandHandlerClass;
         try {
            commandHandlerClass = Class.forName(className);
            CommandHandler  commandHandler = (CommandHandler) commandHandlerClass.newInstance();
            this.commandHandlerMap.put(url, commandHandler);
         } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) { 
            e.printStackTrace();
         } 
      } // while
      
   }
   
   @Override
   public void destroy() { 
      super.destroy();
   } 
   
   @Override
   protected void doGet(HttpServletRequest request
         , HttpServletResponse response) throws ServletException, IOException {
	   // 요청 url 얻어와서 
       String requestURI = request.getRequestURI();
       //        /jspPro/board/list.do
       String contextPath = request.getContextPath();
       requestURI =  requestURI.replace(contextPath, ""); // /jspPro -> 없애고 다시 담기 = /board/list.do
       System.out.println(requestURI); //board/list.do
       
       // 해당 url 과 일치하는 key 값의 value 값, 즉 처리해주는 handler 객체 가져옴 
       CommandHandler handler = this.commandHandlerMap.get(requestURI); 
       
       String viewPage = null; // 응답할 페이지 주소 
       try {
         viewPage = handler.process(request, response); 
         // 게시글 ArrayList & 페이지 객체를 db에서 얻어와 request 객체에 담고(이 페이지와 공유됨) , 포워딩 시키기 위한 페이지 주소 반환 
      } catch (Exception e) { 
         e.printStackTrace();
      } // try~catch
       
       if( viewPage != null ) { 
          // 포워드 
          RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
          dispatcher.forward(request, response);
       } // if 
   } // doGet() 

   @Override
   protected void doPost(HttpServletRequest request
         , HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
   } 

}