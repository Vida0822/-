package days03;

import java.io.BufferedReader;  // Ctrl + Shift + O
// 컴파일러가 자동으로 추가를 해 준다. 
// import java.lang.*;

/**
 * @author kenik
 * @date 2023. 1. 30. - 오후 8:26:59
 * @subject      [ package와 import 문 설명 ] 시험
 * @content   Full Name
 *
 */
public class Ex01 {

	public static void main(String[] args)  {
		
		//[import 문 설명 ]
		/*
		 * 1. 패키지( package ) ?
		 *      ㄱ.  서로 관련있는 클래스의 묶음 
		 *      ㄴ.  실제 물리적으로는 폴더(디렉토리 ) 이다. 
		 *      ㄷ.  효율적으로 클래스를 관리할 목적.
		 *      
		 *       days01, days02, days03 패키지
		 *         이유? 수업 1일차, 2일차, 3일차 클래스를 묶어놓기 위해서 
		 *         
		 *  2. 패키지 선언
		 *       Ex01.java  소스파일(Source File) 의 맨 위에 코딩.
		 *       package 패키지명[.서브패키지명.서브패키지명];
		 * 
		 *  3.  다른 패키지 안의 클래스를 사용하려면
		 *       days03.Ex01  - main(){
		 *             days01.HelloWorld 클래스를 사용하려면 
		 *       }
		 *       
		 *       패키지명.서브패키지명.클래스명 사용해야 된다.
		 *       days01.HelloWorld    hw; 
		 *   
		 *  4.   Full Name 을 적으세요...
		 *       =>    패키지명.서브패키지명.클래스명
		 *       
		 *  5. static import 문 ( 검색 ) 정리 X     
		 * */
		
		// package java.io;
		 // BufferedREader   br; 선언                   F3
		/*
		java.io.BufferedReader br1;
		java.io.BufferedReader br2;
		java.io.BufferedReader br3;
		java.io.BufferedReader br4;
		*/
 
		BufferedReader br1;
		BufferedReader br2;
		BufferedReader br3;
		BufferedReader br4;
		
		// [System 클래스]
		// 1. 어떤 패키지 속한 클래스 확인 ? java.lang 패키지 안에 속한 클래스 
		java.lang.System.out.println("이창익");
		
		// import java.lang.System;  왜 ? 
		System.out.println("이태규");
		

	} // main

} // class



/*
//심성환, 하동호(개인사정), 홍성철(개인사정)
// 월/금  비대면
// 화(1조)/수(2조)/목(3조)     조별 대면.   
// 9:09 ~ 9:45 복습문제.   제출

// 화,수,목 : 홍성철, 박상범, 이혜진, 신희민, 김수민

// 10:02 수업시작~  
*/