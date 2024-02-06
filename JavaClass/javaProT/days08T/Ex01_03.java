package days08;

import java.util.Scanner;

/**
 * @author kenik
 * @date 2023. 2. 6. - 오후 12:07:02
 * @subject    정규 표현식( Regular Expression) 사용
 * @content                              regex
 *
 */
public class Ex01_03 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("> user 가위(1), 바위(2),보(3) 선택 ? ");  //       1 ~ 3 정수		 
		String input = scanner.next();   
		
		// String클래스 안에 matches( regex ) 함수 
		// 1.                               일치하니?
		// 2.                               regex              1~3 정수인지 체크하는 정규표현식
		// 3.                               boolean
		
		// [0123456789] == [0-9] == \d
		
		//String regex  = "[abc]";   //  a || b || c
		// String regex  = "[^abc]";   // [^ 부정]
		//String regex = "[123]";
		String regex = "[1-3]";
		boolean flag = input.matches(regex);
		System.out.println( flag );
		
	} // main

} // class













