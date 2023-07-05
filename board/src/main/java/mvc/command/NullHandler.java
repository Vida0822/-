package mvc.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NullHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res)
	throws Exception {
		res.sendError(HttpServletResponse.SC_NOT_FOUND); // SC_NOT_FOUND : 404 에러 -> 이 에러를 클라이언트에 send(보내겠다)
		return null;
	}

}
