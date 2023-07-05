package days05;

import java.util.Scanner;

/**
 * @author dlsgu
 * @date 2023. 2. 1. 오전 11:41:57
 * @subject if 조건문
 * @content
 */
public class Ex03_03 {

	public static void main(String[] args) {
		// 정수를 입력받아서 "홀수"/"짝수"입니다라고 출력
		int n;
		Scanner scanner = new Scanner(System.in);
		System.out.print("> 정수 입력 ? ");
		n = scanner.nextInt();
		
		if (n % 2 == 0) { // 짝수?
			System.out.println("짝수(even number)");
		} else { // 홀수?
			System.out.println("홀수(odd number)");
		}
		
		System.out.println("END");

	}//main

}//class
