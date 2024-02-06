package days13.replyboard.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import days13.replyboard.service.DeleteService;

public class DeleteHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request
			, HttpServletResponse response) throws Exception {
		
		int  num = Integer.parseInt( request.getParameter("num") );
		
		String  pass = request.getParameter("pass") ;
		System.out.println("> 입력받은 비밀번호(pass) : " + pass);
		
		int rowCount = 0;		
		DeleteService deleteService = DeleteService.getInstance();
		rowCount = deleteService.delete(num, pass);
		
		if (rowCount == 1) {
			String location = "list.do";
			response.sendRedirect(location);
		} 
		
		// rowCount 가 -1 이라면 비밀번호가 잘못됨.
		// 다시 view.do?num=해당글번호&error=101 호출함.		
		// [ 삭제 작업은 Ajax 로 처리... ]
		
		return null;
	}

}













