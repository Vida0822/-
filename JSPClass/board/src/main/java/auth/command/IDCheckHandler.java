package auth.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auth.service.LoginService;
import mvc.command.CommandHandler;

public class IDCheckHandler implements CommandHandler{

   private LoginService loginService = new LoginService();
   
   @Override
   public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
       
      // 중복체크할 ID 
      String id = trim(req.getParameter("memberid"));      
      
      Map<String, Boolean> errors = new HashMap<>();
      req.setAttribute("errors", errors);
      if (id == null || id.isEmpty())
         errors.put("id", Boolean.TRUE); 
      if (!errors.isEmpty()) {
         return null;
      }
      
      try {
         // { "count":1  } 
         // { "count":0  }
         String idCheckJson = loginService.idCheck(id); // 결과를 json으로
         return idCheckJson; // 반환 to Controller 
      } catch ( Exception e) {
         errors.put("idCheck", Boolean.TRUE);
         return null;
      } 
   }
   
   private String trim(String str) {
      return str == null ? null : str.trim();
   }

}