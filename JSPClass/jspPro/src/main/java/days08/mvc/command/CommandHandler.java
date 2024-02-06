package days08.mvc.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CommandHandler {
	
	String process(HttpServletRequest request , HttpServletResponse response) throws Exception ;
		// Controller 가 요청을 받아서 CommandHandle한테 일을 바로 시키기 때문에 그 요청과 응답 객체를 넘겨줘야한다! 
		// + 어떤 예외가 발생하던 Controller한테 떠넘기겠음 
		// return : 여기서 로직을 처리하고 그 결과물을 그냥 가져온 request에 담아주겠음  
		// => String : 그 request를 처리하는 view 페이지의 이름을 그냥 문자열로 바로 돌려줌 
		
		


}
