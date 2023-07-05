package days28;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * @author dlsgu
 * @date 2023. 3. 7. 오후 12:31:03
 * @subject
 * @content
 */
public class Ex02_08 {

	public static void main(String[] args) {
		// 여러 하위 폴더를 가지고 있는 상위 폴더에서
		// "람다" 문자열을 가진 모든 파일을 찾아서 라인번호 / 라인문자열 출력
		String pathname = "."; // javaPro 폴더
		File searchDir = new File(pathname);
		String keyword = "로또";
		
		// javaPro 폴더 + 하위 폴더에서 "로또" 문자열 모두 찾아서 출력
		printSearchFiles(searchDir, keyword);

	}//main

	private static void printSearchFiles(File searchDir, String keyword) {
		// 하위 폴더 + 파일 목록
		File [] list = searchDir.listFiles();
		
		for (int i = 0; i < list.length; i++) {
			if (list[i].isDirectory()) { // 폴더
				printSearchFiles(list[i], keyword);
			} else {
				try (
						FileReader in = new FileReader(list[i]);
						BufferedReader br = new BufferedReader(in);
					) {
					String line = null;
					int lineNumber = 1;
					
					while ((line = br.readLine()) != null) {
						if (line.contains(keyword)) {
							line = line.replaceAll(keyword, "<span style = 'color:red'>" + keyword + "</span>");
							System.out.printf("%s [%d] : %s\n", list[i], lineNumber, line);
						}
						lineNumber++;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
	}

}//class
