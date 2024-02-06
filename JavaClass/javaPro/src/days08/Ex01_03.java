package days08;

import java.util.Scanner;

/**
 * @author dlsgu
 * @date 2023. 2. 6. 오전 11:40:16
 * @subject 정규 표현식(Regular Expression) regex 사용
 * @content 
 */
public class Ex01_03 {

	public static void main(String[] args) {
		//days05.Ex06
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("> user 가위(1), 바위(2), 보(3) 선택 ? ");
		String input = scanner.next(); // "문자열"

		// String클래스 안에 matches(regex)함수
		// 1. 기능이 일치하는지 물어보는 함수
		// 2. 매개변수 regex
		// 3. boolean
		
		// [0123456789] == [0-9] == \d
		
		//String regex = "[abc]"; // a || b || c
		//String regex = "[^abc]"; // [^ 부정]
		//String regex = "[123]";
		String regex = "[1-3]";
		input.matches(regex);
		
	}//main

}//class
