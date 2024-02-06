package days27;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author dlsgu
 * @date 2023. 3. 6. 오후 12:27:08
 * @subject FileReader, FileWriter 사용해서 파일 복사
 * @content	보조 스트림 BufferedReader, BufferedWriter 사용
 * 						readLine() 라인단위로 처리할 수 있는 특징
 * 						버퍼기능
 * 
 * 		[Ex01.java] -> BufferedReader[FileReader] -> while() -> FileWriter -> [Ex01_Copy.java]
 * 									int n = reader.read() 읽기
 * 									writer.write(n) 쓰기
 */
public class Ex06_04 {

	public static void main(String[] args) {
		
		
		String fileName = ".\\src\\days27\\Ex01.java";
		String copyFileName = ".\\src\\days27\\Ex01_Copy.java";
		
		fileCopy_textStream02(fileName, copyFileName);

	}//main

	private static boolean fileCopy_textStream02(String fileName, String copyFileName) {
		long start = System.nanoTime();
		
		final int BUFFER_SIZE = 1024;
		try (
				FileReader reader = new FileReader(fileName);
				FileWriter writer = new FileWriter(copyFileName);
				
				BufferedReader br = new BufferedReader(reader, BUFFER_SIZE);
				BufferedWriter bw = new BufferedWriter(writer, BUFFER_SIZE);
			) {
			
			/* 라인 단위로
			String line = null;
			int lineNumber = 1;
			while ((line = br.readLine()) != null) {
				bw.write(lineNumber++ + ":" + line);
			}
			*/
			char [] cbuf = new char[BUFFER_SIZE]; // 버퍼
			// [][] [][] [][] []
			int n; // 실제 버퍼에 읽어온 문자들의 수
			while ((n = br.read(cbuf)) != -1) { // ***** 이 코딩의 정확한 이해가 필요
				// bw.write(char [], offset, length);
				bw.write(cbuf, 0, n);
			}
			
			System.out.println("파일 복사 완료");
			long end = System.nanoTime();
			System.out.println("처리시간(ns) : " + (end-start)); // 처리시간(ns) : 7387901 / 840200
			
			return true;
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
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
