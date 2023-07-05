package days05;

import java.util.Scanner;

/**
 * @author kenik
 * @date  2023. 2. 1. - 오후 12:22:11
 * @subject 
 * @content 
 *
 */
public class Ex04 {

	public static void main(String[] args) {
		// [시험] if문 사용해서  
		//           국어 점수를 입력받아서
		//           등급( 수, 우, 미, 양, 가) 을 출력
			//           수 : 90~100
			//           우 : 80~89
			//           미 : 70~79
			//           양 : 60~69
			//           가 : 0~59
		int kor;
		Scanner scanner = new Scanner(System.in);
		System.out.print("> 국어점수 입력 ? ");
		kor =  scanner.nextInt();  		
		// 0~100 입력값에 대한 유효성 검사. (전공자)		
		if ( 90 <=kor  && kor<=100 ) {
			System.out.println("수");
		}
		if ( 80 <=kor  && kor<=89 ) {
			System.out.println("우");
		}
		if ( 70 <=kor  && kor<=79 ) {
			System.out.println("미");
		}
		if ( 60 <=kor  && kor<=69 ) {
			System.out.println("양");
		}
		if ( 0 <=kor  && kor<=59) {
			System.out.println("가");
		}
		

	} // main

} // class
