package settings.command;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import member.model.Member;
import mvc.command.CommandHandler;
import net.coobird.thumbnailator.Thumbnailator;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import settings.model.ProfilePicture;

@MultipartConfig(
		location = "C:\\Users\\Default\\Downloads",
		fileSizeThreshold = -1,   
		maxFileSize = 1024*1024*10,
		maxRequestSize = 1024*1024*50*5
)
public class ProfilePictureHandler implements CommandHandler {

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
		return null;
	}

	private String processSubmit(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
	      
	    // json 으로 첨부파일 정보를 반환하는 ArrayList
	    List<ProfilePicture> list = new ArrayList<>();

	    PrintWriter out = response.getWriter();
	    String contentType = request.getContentType();
	      
	    JSONObject jsonData = new JSONObject();
	    int fileLength = 0;
	      
	    //String uploadFolder = "C:\\upload";
	    String uploadFolder = request.getSession().getServletContext().getRealPath("upload");
	    System.out.println( uploadFolder );
	    
	    // ~upload/2023/06/09			parent			child
	    File upLoadPath = new File(uploadFolder, getFolder());
	    if( !upLoadPath.exists()) upLoadPath.mkdirs();
	      
	    if ( contentType != null && contentType.toLowerCase().startsWith("multipart/")) { // 파일 업로드 하러 왔냐?
	    	// 첨부된 파일을 getPart()메서드로  컬렉션으로 얻어오기 
	    	Collection<Part> parts = request.getParts();
	    	for (Part part : parts) {
	            
	    		ProfilePicture attachDTO = new ProfilePicture();
	            
	    		String paramName = part.getName(); // input type=file의 파라미터명(name속성)
	    		contentType = part.getContentType();
	    		
	    		//System.out.printf("paramName=%s,contentType=%s\n", paramName,contentType );
	    		if( part.getHeader("Content-Disposition").contains("filename=") ) { // 첨부된 파일 있음
	    			String fileName = part.getSubmittedFileName();
	    			long size = part.getSize();
	    			// System.out.printf("fileName=%s, size=%d\n", fileName, size);
	    			attachDTO.setAf_ex_name(fileName);  // ㄱ
	    			
	    			if (size > 0) {
	    				UUID uuid = UUID.randomUUID();
	    				String filePath = String.format("%s\\%s_%s", upLoadPath, uuid.toString(), fileName);
	    				part.write( filePath ); // 파일 저장
	    				part.delete(); // 임시 파일 즉시 삭제
	    				fileLength++;
	                  
	    				attachDTO.setUuid(uuid.toString()) ;  // ㄴ
	                  
	    				// 이미지파일인 경우에는 섬네일 생성
	    				File f = new File(filePath);
	    				if( checkImageType(f) ) { 
	    					FileInputStream fis = new FileInputStream(f);
	    					filePath = String.format("%s\\s_%s_%s", upLoadPath, uuid.toString(), fileName);
	                     
	    					attachDTO.setAf_path(filePath.substring( filePath.indexOf("\\fileUploadPro") ))  ;  // ㄷ
	                     
	    					FileOutputStream thumbnail = new FileOutputStream(filePath);
	    					Thumbnailator.createThumbnail(fis, thumbnail, 250, 250);
	    					thumbnail.close();
	    					fis.close();
	                     
	    					attachDTO.setAf_image("1"); // ㄹ
	    				} // if
	    			} // if
	    		}  // if
	    		list.add(attachDTO); // ㅁ
	        } // for
	    }  
	      
	    //jsonData.put("result", fileLength);
	    //out.append(jsonData.toString());
	      
	    // [{},{},{}]
	    JSONArray jsonArray = JSONArray.fromObject(list);
	    out.append(jsonArray.toString());
	    System.out.println(jsonArray.toString());
	    
	    return jsonArray.toString();
	}

	// 날짜별 파일 저장하기 위한 폴더명 생성함수
	private String getFolder() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String folderName = sdf.format(date); // 2023\\06\\09
		    
		return folderName.replace("-", File.separator);
	} // getFolder
		   
	// 이미지 여부 체크 함수 -> 이미지면 썸네일 만들것
	public boolean checkImageType(File file) {
		try {
			String contentType = Files.probeContentType(file.toPath());
		    System.out.println("> contentType : " + contentType);
		        
		    return contentType.startsWith("image");
		} catch (Exception e) {
			System.out.println("checkImageError");
			e.printStackTrace();
		} // try
			
		return false;
	} // checkImage

}
