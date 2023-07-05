package days05;

import java.util.Scanner;

/**
 * @author kenik
 * @date  2023. 2. 1. - 오전 11:42:13
 * @subject   if 조건문 설명
 * @content   if 형식 X
 *
 */
public class Ex03_03 {

	public static void main(String[] args) {
		 
		int n;
		Scanner scanner = new Scanner(System.in);
		System.out.print("> 정수 입력 ? ");
		n =  scanner.nextInt();   
		
		if ( n % 2 == 0 ) {
			System.out.println("짝수( even number) ");
		} else {  // 홀수
			System.out.println("홀수( odd number) ");
		} 
		
	    System.out.println(" END ");
		 
	} // main

} // class





