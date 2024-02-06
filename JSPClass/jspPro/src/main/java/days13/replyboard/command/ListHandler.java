package days13.replyboard.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import days13.replyboard.domain.ReplyBoardDTO;
import days13.replyboard.service.ListService;

public class ListHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ListService listService = ListService.getInstance();
		List<ReplyBoardDTO> list = listService.select();
		
		// MessageListView.java : 
		request.setAttribute("list", list);
		request.setAttribute("pageBlock", "[1] 2 3 4 5 6 7 8 9 10 >");
		
		return "/days13/replyboard/list.jsp";
	}

}
