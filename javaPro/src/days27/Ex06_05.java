package days27;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author dlsgu
 * @date 2023. 3. 6. 오후 12:53:11
 * @subject FileInputStream / FileOutputStream 바이트 스트림 - 파일 복사
 * @content 보조 스트림										 - 파일 복사
 * 			exe 실행파일 복사 -> 문자 스트림 X, 바이트 스트림 O
 */
public class Ex06_05 {

	public static void main(String[] args) {
		String fileName = "C:\\Users\\dlsgu\\Downloads\\통장사본_탁인혁.png";
		String copyFileName = "C:\\Users\\dlsgu\\Downloads\\통장사본_탁인혁_copy.png";
		
		// fileCopy_byteStream(fileName, copyFileName);
		fileCopy_byteStream02(fileName, copyFileName);

	}//main

	private static boolean fileCopy_byteStream02(String fileName, String copyFileName) {
		long start = System.nanoTime();
		
		final int BUFFER_SIZE = 1024;
		try (
				FileInputStream fis = new FileInputStream(fileName);
				FileOutputStream fos = new FileOutputStream(copyFileName);
				
				// 버퍼 기능이 있는 보조 스트림을 사용해서 코딩
				BufferedInputStream bis = new BufferedInputStream(fis, BUFFER_SIZE);
				BufferedOutputStream bos = new BufferedOutputStream(fos, BUFFER_SIZE);
			) {
			byte [] b = new byte [BUFFER_SIZE];
			int n; // 실제 배열 b에 채워진 바이트 수
			while ((n = bis.read(b)) != -1) {
				bos.write(b, 0, n);
			}//while
			bos.flush();
			
			long end = System.nanoTime();
			// > 처리 시간 : 2354800(ns) 복사완료
			System.out.println("> 처리 시간 : " + (end-start) + "(ns) 복사완료");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	private static boolean fileCopy_byteStream(String fileName, String copyFileName) {
		long start = System.nanoTime();
		try (
				FileInputStream fis = new FileInputStream(fileName);
				FileOutputStream fos = new FileOutputStream(copyFileName);
			) {
			int b;
			while((b = fis.read()) != -1) {
				fos.write(b);
			}//while
			long end = System.nanoTime();
			// > 처리 시간 : 1016265300(ns) 복사완료
			System.out.println("> 처리 시간 : " + (end-start) + "(ns) 복사완료");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}//class
