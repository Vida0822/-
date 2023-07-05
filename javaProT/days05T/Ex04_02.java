package days05;

import java.util.Scanner;

/**
 * @author kenik
 * @date  2023. 2. 1. - 오후 12:22:11
 * @subject 
 * @content 
 *
 */
public class Ex04_02 {

	public static void main(String[] args) { 
		int kor;
		Scanner scanner = new Scanner(System.in);
		System.out.print("> 국어점수 입력 ? ");
		kor =  scanner.nextInt();  // 89  		
		
		if ( 90 <=kor  && kor<=100 ){
			System.out.println("수");
		}else if ( 80 <=kor  && kor<=89 ) {
			System.out.println("우");
		}else if ( 70 <=kor  && kor<=79 ) {
			System.out.println("미");
		}else if ( 60 <=kor  && kor<=69 ) {
			System.out.println("양");
		}else{  // 조건식 X  그 외의 모든 경우
			System.out.println("가");
		}
		// esle {} 필수 사항 X 

	} // main

} // class
