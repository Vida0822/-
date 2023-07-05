package days05;

import java.util.Scanner;

/**
 * @author dlsgu
 * @date 2023. 2. 1. 오전 11:41:57
 * @subject if 조건문
 * @content
 */
public class Ex03_02 {

	public static void main(String[] args) {
		// 정수를 입력받아서 "홀수"/"짝수"입니다라고 출력
		int n;
		Scanner scanner = new Scanner(System.in);
		System.out.print("> 정수 입력 ? ");
		n = scanner.nextInt(); // 10a -> int 변환 InputMismatchException
		
		//System.out.println(n);
		
		/*
		if (condition 조건식이 참이면) {
			
		}
		
		if (condition) {
			
		} else {

		}
		
		if (scanner != null) {
			
		}
		
		if (scanner == null) {
			
		}
		*/
		
		// 짝수 조건식 -> n % 2 == 0
		// 홀수 조건식 -> n % 2 == 1 or n % 2 != 0
		if (n % 2 == 0) {
			System.out.println("짝수(even number)");
		}
		
		// {} 블럭 안의 명령라인이 "한 줄"인 경우에는 {} 생략 가능하다
		if (n % 2 == 1) 
			System.out.println("홀수(odd number)");
		
		System.out.println("END");

	}//main

}//class
