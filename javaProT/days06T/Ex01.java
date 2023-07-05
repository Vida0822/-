package days06;

import java.util.Iterator;

/**
 * @author kenik
 * @date  2023. 2. 2. - 오전 7:11:00
 * @subject   forEach문 
 * @content 
 *
 */
public class Ex01 {

	public static void main(String[] args) {
		// 9시 45분 제출...  
		// 11:02 수업 시작~
		
		// 1. 배열의 정의 ?  동일한 자료형이 메모리 상에 연속적으로 놓이게 한 것. 
		// 2. 배열 선언 형식?  자료형 [] 배열명 = new 자료형[배열 크기];
		//     그림) [][][][][][][][][][]          ->   [0x100]   참조타입,       변수, 참조변수, 배열명
		// int kor;
		int [] kors = new int[10];
		
		for (int i = 0 , kor ; i < 10 ; i++) { 
			kors[i] = (int)(Math.random() * 101)  ;  
		} 
		
		// 확장for문==foreach문
		/*
		for (자료형 i :  배열 또는 컬렉션 객체) {
			
		}
		*/
		for(int kor  : kors ) {
			System.out.println( kor );
		}
		
		// Alt + Shit + A ( 토글 )
		/*
		for (int i = 0; i < 10; i++) {
			System.out.printf("kors[%d]=%d\n", i,  kors[i]);
		} 
		*/
		





	} // main

} // class



















