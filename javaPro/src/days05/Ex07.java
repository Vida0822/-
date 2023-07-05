package days05;

import java.util.Iterator;

/**
 * @author kenik
 * @date  2023. 2. 1. - 오후 4:25:49
 * @subject     if/   if~else /   if ~ else if ~ else if ~  else 문
 * @content    switch / break
 *                      반복문 :  [for] , foreach(확장for문)
 */
public class Ex07 {

	public static void main(String[] args) {
		// 임의의 숫자(1~3)를 10번 출력하세요.
		// System.out.println( (int)( Math.random() * 3 ) + 1 );
		// i=0     0<10(참)
		// i=1      1<10(참)
		// i=2      2<10(참)
        //   :
		// i=9      9<10(참)
		// i=10    10<10(거짓)
		
		// 3
		// 2
		// 2
		// :
		// 3
		
		for (int i = 1; i <= 10; i++) {
			System.out.printf( "%d : %d\n",
					i,   (int)( Math.random() * 3 ) + 1 );
		} // for
		
		
		
		/*
		for (Iterator iterator = collection.iterator(); iterator.hasNext();) {
			type type = (type) iterator.next();
			
		}
		*/
		 
		/*
		1. [ for 선언 형식 ]  시험문제
		for (  초기식 ;  조건식 ; 증감식 ) {
			  반복적으로 처리할 코딩
		} 
		2. for 처리 과정 설명하세요 ( 시험문제 ) 
		   초기식 -> 조건식  <------------------------
		                                                                               ↑
		                     ㄴ  참    ->  { 반복처리할 코딩. } -> 증감식
		                     ㄴ 거짓 -> for문 빠져나온다. 
		
		*/
	 
		/*
		for (int i = 0; i < args.length; i++) {
			String string = args[i];
			
		}
		*/
		/*
		foreach
		for (String string : args) {
			
		}
		*/
		
		/*
		for (Map.Entry<keyType, valType> entry : map.entrySet()) {
			keyType key = entry.getKey();
			valType val = entry.getValue();
			
		}
		*/
		 
		
		/*
 		System.out.println( (int)( Math.random() * 3 ) + 1 );
 		System.out.println( (int)( Math.random() * 3 ) + 1 );
 		System.out.println( (int)( Math.random() * 3 ) + 1 );
 		System.out.println( (int)( Math.random() * 3 ) + 1 );
 		System.out.println( (int)( Math.random() * 3 ) + 1 );
 		System.out.println( (int)( Math.random() * 3 ) + 1 );
 		System.out.println( (int)( Math.random() * 3 ) + 1 );
 		System.out.println( (int)( Math.random() * 3 ) + 1 );
 		System.out.println( (int)( Math.random() * 3 ) + 1 );
 		System.out.println( (int)( Math.random() * 3 ) + 1 );
 		*/

	} // main

} // class













