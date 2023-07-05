package settings.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.Member;
import mvc.command.CommandHandler;
import settings.service.CurrentPasswordNotMatchedException;
import settings.service.ModifyProfileService;
import settings.service.UpdatePasswordNotMatchedException;

public class SettingsProfileModifyHandler implements CommandHandler {
	
	private ModifyProfileService service = new ModifyProfileService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		Member member = (Member)req.getSession().getAttribute("authUser");
		
		String pname = req.getParameter("pname");
		String parameter = req.getParameter("param");
		
		String currentPW = null;
		String password = null;
		String confimePW = null;
		if ( pname.equals("8") ) {
			currentPW = req.getParameter("currentPW");
			password = req.getParameter("m_pw");
			confimePW = req.getParameter("confirmM_pw");
		}
		
		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);
		
		try {
			// { "result":1  }
			// { "result":0  }
			String updateNameJson = null;
			if ( pname.equals("8") ) {
				updateNameJson = service.ChangePassword(pname, member.getM_password(), currentPW, password, confimePW, member.getM_email());
			} else {
				updateNameJson = service.updateProfile(pname, parameter, member.getM_email());				
			}
			
			return updateNameJson;
		} catch (CurrentPasswordNotMatchedException e) {
			errors.put("currentPasswordNotMatched", Boolean.TRUE);
		} catch (UpdatePasswordNotMatchedException e) {
			errors.put("updatePasswordNotMatched", Boolean.TRUE);
		}
		
		return null;
	}

}
