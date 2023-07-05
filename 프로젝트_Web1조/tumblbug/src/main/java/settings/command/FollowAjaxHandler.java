package settings.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.Member;
import mvc.command.CommandHandler;
import settings.service.FollowService;

public class FollowAjaxHandler implements CommandHandler {

	private FollowService followService = new FollowService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		Member member = (Member)req.getSession().getAttribute("authUser");
		String pname = req.getParameter("pname");
		String following = req.getParameter("param");
		
		try {
			// { "result":1  }
			// { "result":0  }
			String updateNameJson = followService.followUpdate(pname, following, member.getM_cd());
		
			return updateNameJson;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	} // process

}
