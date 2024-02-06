package days08;

import java.util.Scanner;

/**
 * @author kenik
 * @date 2023. 2. 6. - 오후 12:41:21
 * @subject
 * @content
 *
 */
public class Ex02 {

	public static void main(String[] args) {
		// [문제] 정규표현식  ( String.matches()  사용 ) 
		// 등급을 나타내는 한 문자를 입력받아서 수,우,미,양,가 일경우에는  올바른 입력
		//  잘못된 입력일 경우에는 do~while문사용해서 다시 등급을 입력받도록... 

		Scanner scanner = new Scanner(System.in);
		System.out.print("> 등급(수~가) 입력 ?  ");  //
		
		String grade = scanner.next();
		String regex = "[수우미양가]";
		System.out.println(  grade.matches(regex)  );
		
		/*
		char grade = scanner.next().charAt(0);		
		if(  grade=='수' ||   grade=='우' ||  grade=='미' ||  grade=='양' ||  grade=='가'  ) {
			
		} // if
		*/
		/*
		String grade = scanner.next();		
		if(  grade.equals("수") ||   grade.equals("우") ||  grade.equals("미") ||  grade.equals("양") ||  grade.equals("가")  ) {
			
		} // if
		*/
		
	} // main

} // class








