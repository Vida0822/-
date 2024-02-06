package days12;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FileRenamePolicy;
import com.util.ConnectionProvider;
@WebServlet("*.ss")
public class FileTestServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public FileTestServlet() {
		super();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		Connection con = null;

		try {
			con = ConnectionProvider.getConnection();                  
			// ㄱ. saveDirectory
			String saveDirectory = request.getRealPath("/days12/upload");  // ㄱ
			System.out.println( saveDirectory ); 
			File saveDir = new File( saveDirectory );
			if( !saveDir.exists() ) saveDir.mkdirs();         

			// dao
			FileTestDAO dao = FileTestDAO.getInstance();

			// properties 파일 X
			// Handler X
			// Service X
			
			// 목록 
			if ( uri.indexOf("list.ss") != -1) {   // 자료실 목록 
				ArrayList<FileTestDTO> list = dao.selectFileList(con);
				request.setAttribute("list", list);
				
				String path = "/days12/ex05_list.jsp";
				RequestDispatcher dispatcher = request.getRequestDispatcher(path);
				dispatcher.forward(request, response); 
			
			// 작성폼 
			} else if ( uri.indexOf("write.ss") != -1) {  // 자료실 쓰기 + 폼
				String path = "/days12/ex05_write.jsp";
				RequestDispatcher dispatcher = request.getRequestDispatcher(path);
				dispatcher.forward(request, response); 
			
			// 작성등록
			} else if ( uri.indexOf("write_ok.ss") != -1) { // 자료실 쓰기 + 저장

				int maxPostSize =  5* 1024 * 1024  ;  // 5MB;     기본단위 byte
				String encoding = "UTF-8";    
				FileRenamePolicy policy = new DefaultFileRenamePolicy();   // 파일명(1).   _1.
				MultipartRequest mrequest = new MultipartRequest(
						request , 
						saveDirectory ,
						maxPostSize ,
						encoding , 
						policy   
						);

				// 첨부된 파일은 벌써 저장완료 
				FileTestDTO dto = new FileTestDTO();
				String subject = mrequest.getParameter("subject");
				dto.setSubject(subject);

				// 첨부파일 유무확인 
				File uploadFile = mrequest.getFile("attachFile");
				if(uploadFile != null) {
					long fileLength = uploadFile.length();
					String originalFileName = mrequest.getOriginalFileName("attachFile");
					String filesystemName = mrequest.getFilesystemName("attachFile");

					dto.setFilesystemname(filesystemName);
					dto.setOriginalfilename(originalFileName);
					dto.setFilelength(fileLength); 
				} // if 
				int rowCount = dao.insert(con, dto);
				response.sendRedirect("list.ss"); 
				
			// 삭제
			} else if ( uri.indexOf("delete.ss") != -1) {  // 삭제
				int num = Integer.parseInt( request.getParameter("num") );
	            String filesystemname = request.getParameter("filesystemname");
	            
	            int rowCount = dao.delete(con, num);
	            
	            String pathname = String.format("%s%s%s", saveDirectory, File.separator,   filesystemname);            
	            File deleteFile = new File(pathname);            
	            if (deleteFile.exists()) {               deleteFile.delete();            }
	            
	            String location = "/jspPro/days12/ex05_list.ss";
	            response.sendRedirect(location);
			
	         // 수정폼
			} else if ( uri.indexOf("update.ss") != -1) {  // 수정 + 폼
				int num = Integer.parseInt(request.getParameter("num"));
				FileTestDTO dto = dao.selectOne(con, num);
				request.setAttribute("dto", dto);
				
				String path = "/days12/ex05_update.jsp";
				RequestDispatcher dispatcher = request.getRequestDispatcher(path);
				dispatcher.forward(request, response); 
				
			///수정등록 
			} else if ( uri.indexOf("update_ok.ss") != -1) { // 수정 + 저장
				
				// 1. 제목만 수정하령우 
				// 1) 이전에 첨부파일 있을 경우 
				//		ㄱ. 현재 첨부 x : 이전 첨부파일 그대로 남겨두면 되고
				//		ㄴ. 첨부파일 새로 있는 경우: 이전 첨부파일 삭제 + 현재 새로 첨부파일 업로드 
				
				// 2) 이전 첨부파일 업는경우 
				//		ㄱ.
				//		ㄴ. 

				// ㄱ. write_ok.ss  코딩을 복사 -> 붙이기
	            int maxPostSize = 5 * 1024 * 1024 ;  // 5MB
	            String encoding = "UTF-8"; 
	            FileRenamePolicy policy = new DefaultFileRenamePolicy();
	            MultipartRequest mrequest = new MultipartRequest(
	                  request
	                  ,  saveDirectory       
	                  ,  maxPostSize
	                  , encoding
	                  , policy
	                  );
	            //      -> 벌써 업로드한  파일은  저장 완료!!! 
	            FileTestDTO dto = new FileTestDTO();
	            int num = Integer.parseInt( mrequest.getParameter("num") );
	              String subject = mrequest.getParameter("subject");
	            // 문제점 : [ 첨부파일 있는 경우 ]   새로 첨부파일 선택하지 않은 경우
	               dto = dao.selectOne(con, num);  // 해결 추가 코딩.
	               dto.setNum( num );    
	            dto.setSubject(subject);
	            
	            File uploadFile = mrequest.getFile("attachFile");
	            if ( uploadFile != null ) {
	               String fileName = uploadFile.getName(); 
	               long fileLength = uploadFile.length(); 
	               String originalFileName = mrequest.getOriginalFileName("attachFile");
	               String filesystemName = mrequest.getFilesystemName("attachFile");

	               dto.setFilesystemname(filesystemName);
	               dto.setOriginalfilename(originalFileName);
	               dto.setFilelength(fileLength);
	               // 첨부된 파일이 있다면 이전 첨부파일은 삭제 코딩 추가...
	               String delete_filesystemname = mrequest.getParameter("filesystemname");
	               String deleteFilePath = String.format("%s%s%s",   saveDirectory, File.separator,delete_filesystemname);   
	               
	               File deleteFile = new File(deleteFilePath);
	               if( deleteFile.exists() ) deleteFile.delete(); 
	            } // if
				int rowCount = dao.update(con, dto);
				response.sendRedirect("list.ss"); 
			} // if (update_ok)

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try{ con.close(); }catch(SQLException e) { e.printStackTrace(); }
		}
	} // doget 

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response); // post가 와도 get방식으로 처리해줌 
	}

} // FileTestServlet
