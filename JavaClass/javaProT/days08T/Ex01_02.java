package days08;

import java.util.Scanner;

/**
 * @author kenik
 * @date 2023. 2. 6. - 오후 12:07:02
 * @subject
 * @content
 *
 */
public class Ex01_02 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("> user 가위(1), 바위(2),보(3) 선택 ? ");  //       1 ~ 3 정수
		
		// scanner.nextInt() <- "a" 오류 발생
		//                                         4 오류 X,   결과 컴퓨터 승리.
		String input = scanner.next();      //   "문자열"
		// 입력받은 문자열 속에 숫자가 아닌 문자가 있는 지 체크할 게요..   
         // input.length() == 1  문자열 길이   12 X
		boolean flag = false;
		/*
		if(  input.length() == 1 ) {
			char ch = input.charAt(0);
			if(   '1' <=  ch && ch <= '3' ) {
				flag = true;
			}
		} // 
		*/
		char ch = input.charAt(0);
		if( input.length() == 1  && '1' <=  ch && ch <= '3') {
			flag = true;
		}
		
		if (flag) {
			System.out.println( "유효한 입력값 O ");
		} else {
			System.out.println( "유효한 입력값 X ");
		}

	} // main

} // class













