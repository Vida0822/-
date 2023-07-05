package days27;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author dlsgu
 * @date 2023. 3. 6. 오전 11:47:32
 * @subject [ FileReader / FileWriter ]
 * @content XXXReader / XXXWriter
 * 			문자 스트림
 */
public class Ex06 {

	public static void main(String[] args) {

		String fileName = ".\\src\\days27\\Ex01.java";
		// 읽어올 파일의 정보를 알고싶다
		// 파일 + 디렉토리를 다루는 (정보 얻어오기, 파일+지렉토리 생성, 수정, 삭제 등등) 클래스 : File
		File file = new File(fileName);
		
		System.out.println("> 파일의 크기 : " + file.length() + "(bytes)");
		
		// try (FileReader reader = new FileReader(fileName)) {
		try (FileReader reader = new FileReader(file)) {
			
			/*
			reader.read(); // 한 문자, 스트림의 끝 -1 반환
			reader.read(char[] cbuf);
			reader.read(CharBuffer target);
			reader.read(char [] cbuf, int offset, int length);
			*/
			int n;
			while ((n = reader.read()) != -1) {
				System.out.print((char)n);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
