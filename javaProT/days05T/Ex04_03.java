package days05;

import java.util.Scanner;

/**
 * @author kenik
 * @date  2023. 2. 1. - 오후 12:22:11
 * @subject 
 * @content 
 *
 */
public class Ex04_03 {

	public static void main(String[] args) { 
		int kor;
		Scanner scanner = new Scanner(System.in);
		System.out.print("> 국어점수 입력 ? ");
		kor =  scanner.nextInt();  // 89  		
		
		if (  0 <=kor  && kor<=100 ) {
			if ( 90 <=kor  ){
				System.out.println("수");
			}else if ( 80 <=kor ) {
				System.out.println("우");
			}else if ( 70 <=kor  ) {
				System.out.println("미");
			}else if ( 60 <=kor  ) {
				System.out.println("양");
			}else{  // 조건식 X  그 외의 모든 경우
				System.out.println("가");
			} 
		} else {
			System.out.println("국어 점수 입력 잘못했습니다.( 0~100)");
		} // if

	} // main

} // class




