package project.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.Member;
import mvc.command.CommandHandler;
import project.model.Item;
import project.model.PayList;
import project.model.Supporter;
import project.service.PayService;

public class PayHandler implements CommandHandler {

	private static final String FORM_VIEW = "/WEB-INF/view/payForm.jsp";
	private PayService payService = new PayService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if (req.getMethod().equalsIgnoreCase("GET")) {
			return processForm(req, res);
		} else if (req.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(req, res);
		} else {
			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}

	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		Member member = (Member)req.getSession().getAttribute("authUser");
		String mcd = member.getM_cd();
		String procd = req.getParameter("pro_cd");
		String giftcd = req.getParameter("gift_cd");
		String spadd = null;
		if ( req.getParameter("sp_add") != null && req.getParameter("sp_add") != "" ) {
			spadd = req.getParameter("sp_add");			
		} else if ( req.getParameter("sp_add") == null || req.getParameter("sp_add") == "" ) {
			spadd = "0";
		}

		PayList payList = payService.selectPro(procd, giftcd, spadd);
		Supporter supporter = payService.selectSup(mcd);
		List<Item> item = payService.selectItem(procd, giftcd);
		payList.setItem(item);
		payList.setSupporter(supporter);	

		req.setAttribute("list", payList);
		req.setAttribute("item", item);
		req.setAttribute("supporter", supporter);
		
		if (supporter.getAcnt_number() != 0) {
			String acnt_num = String.valueOf(supporter.getAcnt_number());
			String acnt_sec = acnt_num.replace(acnt_num.substring(0, acnt_num.length()-4), "*".repeat(acnt_num.length()-4));
			req.setAttribute("acnt_sec", acnt_sec);			
		}
		
		return FORM_VIEW;
	}

	private String processSubmit(HttpServletRequest req, HttpServletResponse res) throws IOException {
		Member member = (Member)req.getSession().getAttribute("authUser");
		String mcd = member.getM_cd();
		String procd = req.getParameter("pro_cd");
		String giftcd = req.getParameter("gift_cd");
		String spadd = null;
		if ( req.getParameter("sp_add") != null && req.getParameter("sp_add") != "" ) {
			spadd = req.getParameter("sp_add");			
		} else if ( req.getParameter("sp_add") == null || req.getParameter("sp_add") == "" ) {
			spadd = "0";
		}
		String total = req.getParameter("total");
		String addrcd = req.getParameter("addr_cd");
		String pmcd = req.getParameter("pm_cd");
		String prosup = req.getParameter("pro_sup");
				
		payService.insSupport(mcd, procd, giftcd, spadd, total, addrcd, pmcd, prosup);
		
		res.sendRedirect(req.getContextPath() + "/WEB-INF/view/paySuccess.jsp?sup=" + prosup);
		return null;
	}

}
