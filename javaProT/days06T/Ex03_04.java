package days06;

import java.util.Scanner;

/**
 * @author kenik
 * @date  2023. 2. 2. - 오후 3:38:33
 * @subject 
 * @content 
 *
 */
public class Ex03_04 {   // ( 시험 ) 

	public static void main(String[] args) {
		// 정수를 하나 입력... => n 변수 저장.
		int n ;
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("> 정수(n) 입력 ? ");
		// n = scanner.nextInt(); 
		// 12a   , aaa  ->     InputMismatchException
		String input = scanner.nextLine();
		
		// input 문자열 모두 숫자로 이루어져 있는 지 체크 ( 유효성 검사 ) -> Integer.parseInt() -> n
		int len =  input.length();
		// System.out.println(  nameLength  );  // 13
		
		//  1   2   a
		boolean flag = false;
		for (int i = 0; i < len; i++) {
			char one = input.charAt(i); 
			if(   !( '0' <=  one &&  one <= '9')  )  {
				flag = true;
				break;
			}
		} //
		// if( flag == false)
		if(!flag) {
			n =  Integer.parseInt(input);
			System.out.println(  n  );
		}else {
			System.out.println("숫자만 입력하세요~");
		}
		
		 // 4:05 수업시작~
		
		// 문제점1) -11 ,  +11  처리~

	} // main

} // class







