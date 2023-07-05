package days21;

import java.io.FileReader;

/**
 * @author dlsgu
 * @date 2023. 2. 23. 오전 11:03:05
 * @subject
 * @content
 */
public class Ex01_02 {

	public static void main(String[] args) {
		/*
		2. days20.Ex12.java 파일을 읽어서 알파벳 대소문자 구분해서 
	    알파벳 갯수와 막대그래프를 그리세요. 
		*/
		
		// 파일의 경로
		// 1) 절대 경로
		// E:C:\Class\Workspace\Javaclass\javaPro
		String dir = System.getProperty("user.dir"); // key
		String path = String.format("%s\\src\\days20\\Ex12.java", dir);
		System.out.println(path);
		
		// 2) 상대 경로
		// path = ".\\src\\days20\\Ex12.java";
		
		// 0행 대문자 갯수
		// 1행 소문자 갯수
		// int [][] counts = new int[2][26];
		
		// try~with~resource문
		try (FileReader fr = new FileReader(path)){
			int code; // 한문자 -> int 반환하는 메서드
			int [] counts = new int[123];
			while ((code = fr.read()) != -1) {
				// Character.isAlphabetic(code)
				if (Character.isUpperCase(code) || Character.isLowerCase(code)) {
					counts[code]++;
				}
			}
			// 91~96 X
			for (int i = 'A'; i <= 'z'; i++) {
				System.out.printf("%c(%02d) : %s\n", i, counts[i], "#".repeat(counts[i]));
				if(i == 90) i = 96;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}//main

}//class
