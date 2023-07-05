package days28;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import com.util.FileUtil;

/**
 * @author dlsgu
 * @date 2023. 3. 7. 오후 12:48:41
 * @subject
 * @content
 * 			파일명_1.hwp
 * 			파일명_2.hwp
 * 			파일명_3.hwp
 */
public class Ex02_10 {

	public static void main(String[] args) {
		// 파일 크기
		// 시간표_(5강의실)(디지털컨버전스)AWS 클라우드와 Elasticsearch를 활용한 Java(자바) Full-Stack 개발자 양성과정(H)_v2.hwp
		String parent = ".\\\\src\\\\days28";
		String child = "시간표_(5강의실)(디지털컨버전스)AWS 클라우드와 Elasticsearch를 활용한 Java(자바) Full-Stack 개발자 양성과정(H)_v2.hwp";
		File f = new File(parent, child);
		//> 파일 크기 : 307712(bytes)
		System.out.println("> 파일 크기 : " + f.length() + "(bytes)");
		// 10kb = 1024*20 byte
		final int VOLUME = 10*1024; // 10kb
		
		String baseName = FileUtil.getBaseName(child); // 확장자를 제외한 순수 파일명
		String ext = FileUtil.getExtension(child); // 확장자 .hwp
		
		// System.out.println(baseName);
		// System.out.println(ext);
		
		int data = 0; // 읽어온 한 바이트 저장 변수
		int i = 0; // 10*1024 == 10kb
		int index = 0; // 파일명_index.hwp
		
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		try (
				FileInputStream fis = new FileInputStream(f);
				BufferedInputStream bis = new BufferedInputStream(fis);
			) {
			
			while ((data = bis.read()) != -1) {
				// 파일 쓰기(저장)
				// i = 0_1, 10240_2, ...
				if (i % VOLUME == 0) {
					
					if (i != 0) bos.close();
					
					child = String.format("%s_%d%s", baseName, ++index, ext);
					System.out.println(child); // 출력
					File temp = new File(parent, child);
					fos = new FileOutputStream(temp);
					bos = new BufferedOutputStream(fos);
				}
				bos.write(data);
				i++;
			}//while
			System.out.println("end");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//main

}//class
