package days07;

import java.util.Arrays;

/**
 * @author kenik
 * @date 2023. 2. 3. - 오후 4:27:12
 * @subject
 * @content
 *
 */
public class Ex05_02 {

	public static void main(String[] args) {
		// 10개의 정수에서 가장 큰,작은값...
		// max, min
		// (해결) 배열 + 반복문  을 사용해서 처리 
		int [] m = new int[10];
		for (int i = 0; i < m.length; i++) {
			m[i] = (int)(Math.random()*101) ;
		}
		// 배열 확인 ->  [Arrays 클래스 ] .toString()
		// 1. 배열 안의 각 요소를 문자열로 반환하는 메서드 (함수)
		// 2. X
		// 3. String
		System.out.println( Arrays.toString( m ) );

		//   0    1     2    3                                       9     첨자값(index) 
		// [45, 93, 68, 54, 96, 64, 49, 48, 89, 33]
		/*
		int max = m[0];  // 초기화  45
		for (int i = 1; i < m.length; i++) {
			if( max < m[i] ) max = m[i];
		} // for i
		
		int min = m[0];  // 초기화  45
		for (int i = 1; i < m.length; i++) {
			if( min > m[i] ) min = m[i];
		} // for i
		*/
		
		// int max = m[0], min = m[0];
		int max  , min ;
		max = min = m[0];
		
		for (int i = 1; i < m.length; i++) {
			//if( max < m[i] ) max = m[i];
			//if( min > m[i] ) min = m[i];
			
			if( max < m[i] ) max = m[i];
			else if( min > m[i] ) min = m[i];
		} // for i
		
		System.out.printf("max=%d, min=%d\n", max, min);

	} // main

} // class








