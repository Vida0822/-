package days03;

import java.io.BufferedReader; // Ctrl + Shift + O
// 컴파일러가 자동으로 추가를 해준다.
// import java.lang.*; // * -> 모든 클래스의 의미

/**
 * @author dlsgu
 * @date
 * @subject [package와 import문 설명] [시험문제]
 * @content
 *
 */
public class Ex01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// [import문 설명]
		/*
		 * 1. 패키지(package)
		 * 		ㄱ. 서로 관련있는 클래스의 묶음
		 * 		ㄴ. 실제 물리적으로는 폴더(디렉토리)이다.
		 * 		ㄷ. 효율적으로 클래스를 관리할 목적
		 * 
		 *  	days01, days02, days03 패키지
		 *  	이유? 수업 1일차, 2일차, 3일차 클래스를 묶어놓기 위해서
		 * 
		 * 2. 패키지 선언
		 *		Ex01.java 소스파일(Source File)의 맨 위에 코딩
		 *		package 패키지명[.서브패키지명.서브패키지명];
		 *
		 *	3. 다른 패키지 안의 클래스를 사용하려면
		 *		days.03Ex01 - main(){
		 *			days01.HelloWorld 클래스를 사용하려면
		 *		}
		 *
		 *		패키지명[.서브패키지명].클래스명 으로 사용해야한다.
		 *		days01.HelloWorld.hw;
		 *
		 *	4. Full Name을 적으세요
		 *		패키지명.서브패키지명.클래스명
		 *		패키지명부터 클래스명까지 적는 것
		 *
		 */
		
		// package java.io;
		BufferedReader br1;
		BufferedReader br2;
		BufferedReader br3;
		BufferedReader br4;
		
		// [System 클래스]
		// 1. 어떤 패키지에 속한 클래스인지 확인 -> java.lang 패키지 안에 속한 클래스
		java.lang.System.out.println("탁인혁");
		
		

	}//main

}//class
