package days07;

import java.util.Scanner;

/**
 * @author dlsgu
 * @date 2023. 2. 3. 오전 10:52:23
 * @subject
 * @content
 */
public class Ex02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 String message;
		System.out.print("> message input ? ");
		Scanner scanner = new Scanner(System.in);
		message = scanner.nextLine();
		
		//char [] 배열 선언
		// 자료형 [] 배열명 = new 자료형[배열크기];
		int len = message.length();
		char [] msgArr = new char[len];
			
		for (int i = 0; i < len; i++) {
			char one = message.charAt(i);
			msgArr[i] = one;
			System.out.printf("'%s'\n", one);
		}//for
		
		// String.toCharArray():
		// 1. 기능: String -> char [] 변환해주는 함수
		// 2. 매개변수 X
		// 3. 리턴값: char []
		// char [] msgArr2 = message.to.CharArray();
		
		// char[] -> String 변환(단순 암기): 생성자 + 클래스 + 인스턴스(객체)
		String s = new String(msgArr);
		
	}//main

}//class
