package days27;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author dlsgu
 * @date 2023. 3. 6. 오후 12:27:08
 * @subject FileReader, FileWriter 사용해서 파일 복사
 * @content	
 * 
 * 		[Ex01.java] -> FileReader -> while() -> FileWriter -> [Ex01_Copy.java]
 * 									int n = reader.read() 읽기
 * 									writer.write(n) 쓰기
 */
public class Ex06_03 {

	public static void main(String[] args) {
		
		
		String fileName = ".\\src\\days27\\Ex01.java";
		String copyFileName = ".\\src\\days27\\Ex01_Copy.java";
		
		fileCopy_textStream(fileName, copyFileName);

	}//main

	private static boolean fileCopy_textStream(String fileName, String copyFileName) {
		long start = System.nanoTime();
		try (
				FileReader reader = new FileReader(fileName);
				FileWriter writer = new FileWriter(copyFileName)
			) {
			
			int c;
			while ((c = reader.read()) != -1) {
				System.out.println(c); // 복사되는 문자 출력
				writer.write(c);
			}//while
			
			writer.flush();
			System.out.println("파일 복사 완료");
			long end = System.nanoTime();
			System.out.println("처리시간(ns) : " + (end-start)); // 처리시간(ns) : 7387901
			
			return true;
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

}//class
