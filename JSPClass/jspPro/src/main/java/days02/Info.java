package days02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/days02/info.htm")
public class Info extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public Info() {
    }

    // get 방식 요청 
	protected void doGet(HttpServletRequest request
			, HttpServletResponse response) throws ServletException, IOException {
		// ex03.jsp에서 여기로 넘어옴 
		
		response.setContentType("text/html; charset=UTF-8"); // 한글깨짐해결
		
		String name = request.getParameter("name"); 
		int age = Integer.parseInt(request.getParameter("age")); 
		
		PrintWriter out = response.getWriter(); 
		out
			.append("Get 방식 요청")
			.append(">이름:"+name+"<br>")
			.append(">나이:"+age+"<br>");
		
		
	}
	
	// post 방식 요청 
	protected void doPost(HttpServletRequest request
			, HttpServletResponse response) throws ServletException, IOException {
	
		// response.setContentType("text/html; charset=UTF-8");  
		// => 이것만 하면 한글 '이름' 부분만 깨져있음 ! 
		// => 근데 이거 안하면 다깨짐!
		request.setCharacterEncoding("UTF-8"); //utf 소문자도 ㄱㅊ 
		response.setContentType("text/html; charset=UTF-8");  
		// 요로케 두개 써줘야함 
		
		/* 
		request.setCharacterEncoding("UTF-8"); //utf 소문자도 ㄱㅊ 
		response.setContentType("text/html; charset=UTF-8");  
			: 출력하는 응답 데이터를 만들 때 UTF-8을 사용하겠다 ! 
			
			
			[] 	홍/ 20 	-> 	요청		->  [톰캣]  info.java     	-> 		응답 		-> 		[]
												**	doGet : get방식으로 날아오는 데이터는 톰캣에선 자동으로 UTF-8로 읽어들임! 
													=> 즉, 요청을 받을 때 utf-8로 읽어들이니까 한글이 깨지지 않음 
													doPost : post 방식으로 날아오는 데이터는 톰캣에선 자동으로 ISO 8859-1로 읽어들임! 
													=> 요청을 받을 때 한글을 못받기 때문에 응답을 아무리 한글로 한다해도 소용없음 이미 받아들인 값이 한글이 깨진 상태니까 
													=> 그래서! 읽어들일때 utf-8로 읽어들이겠다는 코딩이 필요 ! 
														: 		request.setCharacterEncoding("UTF-8"); 
														 		요청을				utf-8로 읽어들이겠다 			
									
		*/ 
		
		
		String name = request.getParameter("name"); 
		int age = Integer.parseInt(request.getParameter("age")); 
		
		PrintWriter out = response.getWriter(); 
		out
			.append("Post 방식 요청")
			.append(">이름:"+name+"<br>")
			.append(">나이:"+age+"<br>");
	}
}
