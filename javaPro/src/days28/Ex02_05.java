package days28;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * @author dlsgu
 * @date 2023. 3. 7. 오전 11:40:58
 * @subject
 * @content
 */
public class Ex02_05 {

	public static void main(String[] args) {
		String pathname = ".\\src\\days28";
		File parent = new File(pathname);
		
		// [days28 폴더] 안에 있는 자바 파일 안에 "람다" 문자열이 포함된 파일 목록 출력 / 라인 / 텍스트
		String keyword = "람다";
		File [] list = parent.listFiles();
		
		for (int i = 0; i < list.length; i++) {
			String fileName = list[i].getName();
			// System.out.println(fileName);
			File f = list[i];
			try (
					FileReader in = new FileReader(f);
					BufferedReader br = new BufferedReader(in);
				) {
				String line = null;
				int lineNumber = 1;
				
				while ((line = br.readLine()) != null) {
					if (line.contains(keyword)) {
						line = line.replaceAll(keyword, "<span style = 'color:red'>" + keyword + "</span>");
						System.out.printf("%s [%d] : %s\n", fileName, lineNumber, line);
					}
					lineNumber++;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		

	}//main

}//class
