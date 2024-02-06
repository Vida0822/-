package com.filter;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// @WebFilter("/LoginCheckFilter") => web.xml에 등록해줄거임 
public class LoginCheckFilter implements Filter {

    public LoginCheckFilter() {
    }// LoginCheckFilter

	public void destroy() {
	}// destroy
		
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
			throws IOException, ServletException {
//		request.getSession() -> 이거 안나옴 (왜? 이 request는 HttpServletRequest니까)
//		System.out.println(">LoginCheckFilter doFilter() 호출됨");
		HttpServletRequest req = (HttpServletRequest)request; 
		HttpServletResponse res= (HttpServletResponse)response; 
		
		String auth = null ; 
		boolean isLogon = false ; // 인증 받으면 true, 인증 안받으면 false 
		HttpSession session = req.getSession(false); // session 객체를 얻어와서 
		
		if(session !=null && (auth = (String)session.getAttribute("auth") ) != null) {
			isLogon=true; 		// 인증처리 o , 권한체크(생략) 
		}//if 
		if(isLogon) {
			chain.doFilter(request, response);	// 통과 시켜준다 (원래가던길인 다음 자원으로 넘겨준다)  
		}else {
			// 원래 가고자 했던 요청 url을 session 객체에 저장해둬서 ! 거기로 보낸다 
			// request.getUrI()
			String referer = req.getRequestURI(); // write.jsp
			session.setAttribute("referer", referer);
			
			// 인증 x -> 로그인 페이지 (ex06_logon.jsp) 
			String location = "/jspPro/days09/member/ex06_logon.jsp";
			res.sendRedirect(location);
		}//if,else
	}// doFilter

	
	
	
	
	public void init(FilterConfig fConfig) throws ServletException {
	}// init

} // LoginCheckFilter


















