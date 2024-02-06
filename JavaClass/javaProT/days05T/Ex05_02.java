package days05;

import java.util.Scanner;

/**
 * @author kenik
 * @date  2023. 2. 1. - 오후 2:47:19
 * @subject 
 * @content 
 *
 */
public class Ex05_02 {

	public static void main(String[] args) {
		// [문제]  2:58 수업 시작~ 
		int kor;
		Scanner scanner = new Scanner(System.in);
		System.out.print("> 국어점수 입력 ? ");
		kor =  scanner.nextInt();   
		
		// [switch 문을 사용해서 수~가 출력.]
		// 수 90 <=kor  && kor<=100
		// 우 80 <=kor  && kor<=89
		// :
		
		// 100
		// 90,91,92,93~99/10 == 9  수
		// 80,91,92,93~89/10 == 8  우
		
		// key : 변수, 수식
		// value : 변수X, 리터럴
		// switch문에 [break문] 필수 사항X - 제어문 빠져나가세요..
		char grade = '가' ;
		
		if( 0 <= kor && kor <= 100 ) {
				switch (  kor / 10  ) {  // 7
					case 10: // 101~109 수
					case 9: 
						 grade = '수';
						break;
					case 8:
						grade = '우';
						break;
					case 7:
						grade = '미';
						break;
					case 6:
						grade = '양';
						break;
					//default:  
						// grade = '가';
					//	break;
			} // switch
				
			// The local variable grade may not have been initialized
			// grade 지역변수  초기화 X
			System.out.println( grade );
		}else {
			System.out.println("입력 잘못!!!");
		} // if 

		
	} // main

} // class








