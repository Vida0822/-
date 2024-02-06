package days13.replyboard.controller;

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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import days13.replyboard.command.CommandHandler;
 
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    public DispatcherServlet() {
        super();  
    }
     
	@Override
	public void destroy() { 
		super.destroy();
	}
 
	private Map<String, CommandHandler>  commandHandlerMap = new HashMap<String, CommandHandler>();
	
	@Override
	public void init() throws ServletException { 
		String path = this.getInitParameter("path");
		String realPath = this.getServletContext().getRealPath(path);
		
		Properties prop = new Properties();		
		try(FileReader reader = new FileReader(realPath) ) {
			prop.load(reader);
		} catch (Exception e) {
			 throw new ServletException();
		}
		 
		Set<Entry<Object, Object>> set =  prop.entrySet();
		Iterator<Entry<Object, Object>> ir = set.iterator();
		while( ir.hasNext()) {
			Entry<Object, Object> entry = ir.next();
			String url = (String) entry.getKey();    // "/board/list.do" 
			String className = (String) entry.getValue();                    //  "days09.mvc.command.ListHandler"
			
			try {
				Class<?> handlerClass = Class.forName(className);
				CommandHandler  commandHandler = (CommandHandler) handlerClass.newInstance();				
				commandHandlerMap.put(url, commandHandler);
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) { 
				e.printStackTrace();
			}
		
		} // while
		
	}  // init

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
		String requestURI =  request.getRequestURI(); 
		String contextPath = request.getContextPath();  
		
		if (   requestURI.indexOf(contextPath)  == 0 ) {
			int beginIndex = contextPath.length();
			requestURI = requestURI.substring(beginIndex);
		}
		 
		CommandHandler handler = commandHandlerMap.get(requestURI);
  
		String viewPage = null;
		try {
			viewPage = handler.process(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		} 
 
		// (정의)  포워딩.
		if( viewPage != null ) {
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
		}
		
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
