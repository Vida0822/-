package days06;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @author hyejin
 * @date 2023. 2. 2. - 오후 2:46:20
 * @subject 
 * @content 
 *
 */
public class Ex03_02 {

	public static void main(String[] args) {
		// 알파벳 출력 (대, 소)
		// 대문자	'A' <= ch && ch <= 'Z'
		// 소문자	'a' <= ch && ch <= 'z'
		// 한글 '가' <= ch && ch <= '힣'		
		// 숫자 '0' <= ch && ch <= '9'
		// 특수문자
		
		Scanner scanner = new Scanner(System.in);
		char one;
		System.out.print("> 한 문자 입력 ? ");
		String input = scanner.next();
		one = input.charAt(0);
		
		if ('A' <= one && one <= 'Z' || 'a' <= one && one <= 'z') {
			System.out.println("알파벳");			
		} else if ('가' <= one && one <= '힣') {
			System.out.println("한글");
		} else if ('0' <= one && one <= '9') {
			System.out.println("숫자");
		} else if (one=='#' || one=='@' || one=='!' || one=='%') {
			System.out.println("특수문자");
		} else {
			System.out.println("알 수 없는 문자");
		}
		
		// 한글 X char one = (char) System.in.read(); // 0~255 int
		// Scanner scanner = new Scanner(System.in);
		// 스캐너로 한 문자 읽어가는 메서드 X
		// X scanner.nextChar()
		// nextInt(), nextByte(), nextDouble(), nextBoolean(), nextShort() 등등
		// 구분자
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// String br.readLine();
		// 문자열 = 문자의 나열
		// 한문자
		// 문자열(String) -> 한문자(char) 형변환 X -> 첫번째 문자 읽어오기
		// "a" = 'a' '\0' -> 'a'
		
		// String.charAt(index) -> x번째 문자 읽어오는 코딩
		/*
		String name = "홍길동";
		System.out.println(name.charAt(0)); // char
		System.out.println(name.charAt(1));
		System.out.println("홍길동".charAt(2));
		*/
		
		

	}//main

}//class
