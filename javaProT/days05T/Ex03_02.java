package days05;

import java.util.Scanner;

/**
 * @author kenik
 * @date  2023. 2. 1. - 오전 11:42:13
 * @subject   if 조건문 설명
 * @content   if 형식 X
 *
 */
public class Ex03_02 {

	public static void main(String[] args) {
		// 정수를 입력받아서 "홀수"/"짝수"입니다라고 출력.
		int n;
		Scanner scanner = new Scanner(System.in);
		System.out.print("> 정수 입력 ? ");
		n =  scanner.nextInt();  // 10a -> int 변환  InputMismatchException		
		
		// System.out.println( n );
		/*
		12:01 수업시작~~~
		if (condition  조건식 이  참이면) {    참과 거짓 수식	
		   // { } 블럭 안의 코딩을 수행		
		}
		
		if (condition) {			
		} else {
		}
		
		if (scanner != null) {			
		}
		
		if (scanner == null) {			
		}
		*/
		
		// 짝수 조건식 ?  2로 나누어 떨어지는 정수(整數)   2n                n % 2 == 0
		// 홀수 조건식 ?  2로 나누어 떨어지지 않는 정수       2n + 1           n % 2 != 0   n % 2 == 1
		if ( n % 2 == 0 ) {  // 2   거짓
			System.out.println("짝수( even number) ");
		}
		
		//  {} 블럭 안의 명령라인이 "한 줄"인 경우에는   {} 생략 가능하다. 
		if ( n % 2 != 0 ) 
			System.out.println("홀수( odd number) ");
		
	    System.out.println(" END ");
		 
		// if문 2개 :  짝, 홀           X  
	    //    무조건 2번의 if문을 체크 ...
		
		
		

	} // main

} // class





