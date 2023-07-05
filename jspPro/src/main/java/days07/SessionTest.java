package days07;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/days07/session.htm")
public class SessionTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SessionTest() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// System.out.println("SessionTest doGet() 호출됨"); // ㅇㅋ
		// session.
		// session 기본객체 안뜸 : jsp 에선 기본내장객체(9가지)이기 때문에 바로 사용가능하지만 앤 servlet! 즉 java 파일이기 때문에 이 객체가 존재하지 않는다
		// ==> 서블릿에선 세션을 어떻게 사용하는가? 2가지 방법 
		// 1. 매개변수 x 
		HttpSession session1 =  request.getSession(); // session이 존재하지 않으면 새로운 세션 객체를 생성해서 반환한다
		//	== HttpSession session2 =  request.getSession(true);
		/*
		 * if (session1 == null) { } ※이 첫번째 메서드에선 절대!! null이 나올 수 없음 (세션이 존재하지 않으면 만들기 때문에) -> 이거 실수 많이하니까 주의
		 */
			
		
		
		// 2. 매개변수 o
		HttpSession session2 =  request.getSession(false); // session이 존재하지 않으면 null을 반환하는 코딩 
		
		if (session2==null) {
			// 코딩 ~ 
		}//if
		
		
		
		
	}// doGet() 
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
