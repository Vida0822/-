package org.doit.ik.controller;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.doit.ik.domain.NoticeVO;
import org.doit.ik.persistence.NoticeDao;
import org.doit.ik.service.MemberShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/customer/*")
public class CustomerController {
	
	@Autowired
	private NoticeDao noticeDao;
	
	@Autowired
	private MemberShipService memberShipService;
	
	/*
	// 컨트롤러 메서드
	// @RequestMapping(value = {"/notice.htm"}, method = RequestMethod.GET)
	// @RequestMapping("/customer/notice.htm")
	@GetMapping("/customer/notice.htm")
	public ModelAndView notices(HttpServletRequest request, HttpServletResponse response, Model model, HttpSession session) throws Exception {
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("message","hello world");
		
		String ppage = request.getParameter("page");
		String pfield = request.getParameter("field");
		String pquery = request.getParameter("query");
		
		int page = 1;
		String field = "title";
		String query = "";
		
		if (ppage != null && !ppage.equals("")) { page = Integer.parseInt(ppage); }
		
		if (pfield != null && !pfield.equals("")) { field = pfield; }
		
		if (pquery != null && !pquery.equals("")) { query = pquery; }
		
		List<NoticeVO> list = this.noticeDao.getNotices(page, field, query);
		
		mav.addObject("list",list);
		
		mav.setViewName("notice.jsp");
		
		return mav;
		
	}
	*/
	
	// 컨트롤러 메서드
	// @RequestMapping(value = {"/customer/notice.htm"}, method = RequestMethod.GET)
	// @RequestMapping("/customer/notice.htm")
	@GetMapping("/notice.htm")
	public String notices(
			@RequestParam(value = "page", defaultValue = "1") int page
			, @RequestParam(value = "field", defaultValue = "title") String field
			, @RequestParam(value = "query", defaultValue = "") String query
			, Model model) throws Exception {
			
		model.addAttribute("message","hello world");
		
		List<NoticeVO> list = this.noticeDao.getNotices(page, field, query);
		
		model.addAttribute("list",list);
		
		return "notice.jsp";
		
	}
	
	@GetMapping("/noticeDetail.htm")
	public String noticeDetail(
			@RequestParam("seq") String seq
			, Model model) throws Exception {
		
		NoticeVO notice = this.noticeDao.getNotice(seq);
		
		model.addAttribute("notice",notice);
		
		return "noticeDetail.jsp";
		
	}
	
	// notice.jsp에서 링크태그 [글쓰기] 버튼 클릭
	// @RequestMapping(value = {"/noticeReg.htm"}, method = RequestMethod.GET)
	@GetMapping("/noticeReg.htm")
	public String noticeReg() throws Exception {
		
		return "noticeReg.jsp";
		
	}
	
   //  a-2.txt
   private String getFileNameCheck(String uploadRealPath, String originalFilename) {
      int index = 1;      
      while( true ) {         
         File f = new File(uploadRealPath, originalFilename);         
         if( !f.exists() ) return originalFilename;         
         // upload 폴더에 originalFilename 파일이 존재한다는 의미         a.txt (4자리)
         String fileName = originalFilename.substring(0, originalFilename.length() - 4 );  //   a
         String ext =  originalFilename.substring(originalFilename.length() - 4 );  // .txt
         // asdfasf-3.txt
         originalFilename = fileName+"-"+(index)+ext;

         index++;
      } // while 
   }
	
	// p358 컨트롤러 메서드 파라미터( 커맨드 객체 사용 예 )
	// @RequestMapping(value = {"/noticeReg.htm"}, method = RequestMethod.POST)
	@PostMapping("/noticeReg.htm")
	public String noticeReg(NoticeVO notice, HttpServletRequest request) throws Exception {
		
		// 1. 첨부 파일 유무 확인
		CommonsMultipartFile multipartFile = notice.getFile();
		
		String uploadRealPath = null;
		
		if (!multipartFile.isEmpty()) {
			uploadRealPath = request.getServletContext().getRealPath("/customer/upload");
			
			File saveDir = new File(uploadRealPath);
			if (!saveDir.exists()) saveDir.mkdirs();
			
			System.out.println("> uploadRealPath : " + uploadRealPath);
			
			String originalFilename = multipartFile.getOriginalFilename();
			
			String filesystemName =  getFileNameCheck(uploadRealPath, originalFilename);
			
			File dest = new File(uploadRealPath, filesystemName);
			multipartFile.transferTo(dest); // 실제 서버에 파일이 업로드된다
			
			notice.setFilesrc(filesystemName);
		}// if
		
		// 로그인 인증 - 세션
		notice.setWriter("hyeok");
		
		// int insertCount = this.noticeDao.insert(notice);
		this.memberShipService.insertAndPointUpOfMember(notice,"hyeok");
		int insertCount = 1;
		
		if (insertCount == 1) {
			// redirect: == response.sendRedirect()
			return "redirect:notice.htm";			
		} else {
			return "noticeReg.jsp?error";
		}
		
	}
	
	// ?seq=1
	@GetMapping("/noticeEdit.htm")
	public String noticeEdit(@RequestParam("seq") String seq, Model model) throws Exception {
		
		NoticeVO notice = this.noticeDao.getNotice(seq);
		
		model.addAttribute("notice", notice);
		
		return "noticeEdit.jsp";
		
	}
	
	// ?seq=1
	@PostMapping("/noticeEdit.htm")
	public String noticeEdit(NoticeVO notice, @RequestParam("o_filesrc") String oFilesrc, HttpServletRequest request) throws Exception {
		
		CommonsMultipartFile multipartFile = notice.getFile();
		
		String uploadRealPath = null;
		
		if (!multipartFile.isEmpty()) {
			uploadRealPath = request.getServletContext().getRealPath("/customer/upload");
			
			File delFile = new File(uploadRealPath, oFilesrc);
			if (delFile.exists()) delFile.delete();
			
			String originalFilename = multipartFile.getOriginalFilename();
			
			String filesystemName =  getFileNameCheck(uploadRealPath, originalFilename);
			
			File dest = new File(uploadRealPath, filesystemName);
			multipartFile.transferTo(dest); // 실제 서버에 파일이 업로드된다
			
			notice.setFilesrc(filesystemName);
		} else {
			notice.setFilesrc(oFilesrc);
		}
		
		int updateCount = this.noticeDao.update(notice);
		
		if (updateCount == 1) {
			// redirect: == response.sendRedirect()
			return "redirect:noticeDetail.htm?seq=" + notice.getSeq();			
		} else {
			return "redirect:notice.htm";
		}
		
	} // noticeEdit
	
	// ?seq=1&filesrc=ojdbc6.jar
	@GetMapping("/noticeDel.htm")
	public  String noticeDel(@RequestParam("seq") String seq, @RequestParam("filesrc") String delFilesrc, HttpServletRequest request) throws Exception  {
		
		// 1. 실제 업로드 경로에서 파일 삭제
		String uploadRealPath = request.getServletContext().getRealPath("/customer/upload");
		
		File delFile = new File(uploadRealPath, delFilesrc);
		if (delFile.exists()) delFile.delete();
		
		// 2. 테이블 레코드 삭제
		int deleteCount = this.noticeDao.delete(seq) ; 
		
		if(deleteCount == 1) {
			return "redirect:notice.htm";			
		}else {
			return "redirect:noticeDetail.htm?seq=" + seq+"&error" ; 
		} // ifelse 
	}// noticeDel
	
	// ?dir=customer/upload&file=${ notice.filesrc  }
    @RequestMapping( "/customer/download.htm")
    public void download(
          @RequestParam("dir")   String d
          , @RequestParam("file") String fname
          , HttpServletResponse response
          , HttpServletRequest request
          ) throws Exception{ 

       response.setHeader("Content-Disposition","attachment;filename="+ new String(fname.getBytes(), "ISO8859_1"));      

       String fullPath = request.getServletContext().getRealPath(   d + "/" + fname);

       FileInputStream fin = new FileInputStream(fullPath);
       ServletOutputStream sout = response.getOutputStream();  
       byte[] buf = new byte[1024];
       int size = 0;
       while((size = fin.read(buf, 0, 1024)) != -1) {
          sout.write(buf, 0, size); 
       }
       fin.close();
       sout.close();

    }

}
