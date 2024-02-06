package days05;

import java.util.Scanner;

/**
 * @author kenik
 * @date  2023. 2. 1. - 오전 7:22:43
 * @subject 
 * @content 
 *
 */
public class Ex01 {

	public static void main(String[] args) {
		// 9:03
		// 9:40  복습문제...제출
		// Scanner 클래스  API document
		// Ctrl + A 전체 선택 => Ctrl + I 들여쓰기
		// 11:03 수업 시작~
		String input = "1 fish                2 fish red fish                  blue fish";
		
		// Resource leak: 's' is never closed
		Scanner s = new Scanner(  input  ).useDelimiter("\\s*fish\\s*");
		//  구분자로   "\\s*fish\\s*"  regex(정규표현식) 을 사용하겠다. 
		
		// \\s  스페이스
		//*    0~여러번
		// fish 문자열 
		//  \\s  스페이스
		// *
		
		System.out.println(s.nextInt());  //1 
		System.out.println(s.nextInt());   // 2
		System.out.println(s.next());  // red
		System.out.println(s.next());   // blue
		
		// s.close();



	} // main

} // class












