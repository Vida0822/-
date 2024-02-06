package days02;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Now extends HttpServlet {
	/**
	 *The serializable class Now does not declare a static final serialVersionUID
	 * field of type long  => add genarate 어쩌구 아이디 (전세계에서 고유한 번호)
	 */
	private static final long serialVersionUID = 6485565372904482262L;

	// get 방식으로 요청 -> doGet()
	@Override 	// alt+shift+s
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(request, response);
	}

	// post 방식으로 요청 -> doPost()
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(request, response);
	}

	// get, post 던 모든 요청을 얘가 처리(위에 쟤네 있더라도!) => 나중엔 얘 ㅁ안만들어줄거임 
	@Override
	protected void service(
			HttpServletRequest request
			, HttpServletResponse response) throws ServletException, IOException {

		// contentType= "text/html; charset=UTF-8"
		response.setContentType("text/html; charset=UTF-8");
		// out 에러 
		PrintWriter out =  response.getWriter() ; 
		
		// 자바 코딩안에 html 코드를 넣어줘야하기 때문에 유지보수가 어렵다 
		out.write("<!DOCTYPE html>\r\n");
        out.write("<html>\r\n");
        out.write("<head>\r\n");
        out.write("<meta charset=\"UTF-8\">\r\n");
        out.write("<title>2023. 5. 16. - 오후 2:22:47</title>\r\n");
        out.write("<link rel=\"shortcut icon\" type=\"image/x-icon\" href=\"../images/SiSt.ico\">\r\n");
        out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
        out.write("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js\"></script>\r\n");
        out.write("</head>\r\n");
        out.write("<body>\r\n");
        out.write("<h3>Now.java 서블릿</h3>\r\n"); 

        Date now = new Date(); 
        String pattern ="yyyy-mm-dd hh:mm:ss"; 
        SimpleDateFormat sdf = new SimpleDateFormat(pattern); 
        String strNow = sdf.format(now); 
        
        out.write(">현재 날짜 시간 : "+strNow);       
        out.write("\r\n");
        out.write("</body>\r\n");
        out.write("</html>\r\n");
	}
}
