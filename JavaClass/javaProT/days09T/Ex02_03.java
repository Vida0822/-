package days09;

import java.util.Iterator;

/**
 * @author kenik
 * @date  2023. 2. 7. - 오전 11:46:54
 * @subject 재귀 함수
 * @content 
 *
 */
public class Ex02_03 {

	public static void main(String[] args) {
		/*
		 *  [ 합 ]
		 *  [ 팩토리얼 ]
		 *  [ 거듭제곱 ]  == 누승 == 멱 == pow
               2 ^ 3 = 2 * 2 *2 = 8     // 2의 세제곱
               밑수를  지수만큼 반복해서 곱하는 것.
               
               지수 == 2    제곱
               지수 == 3    세제곱
               지수 == 1/2  제곱근
                      == 1/3  세제곱근
		 * */

		// int result = power( 2 , 3 );  // 2 밑수,  3 지수
		double result = power( 2 , -3 );  // 2 밑수,  -3 지수           0.125
		System.out.println( result );
	} // main

	// 12:00 쉬는 시간 + 5분 
	// 절대값을 반환하는 함수   abs(-1)==1 ,  abs(1)==1
	private static int abs(int i) {
		if( i < 0) return i * -1;
		else return i;
	}
	
	// [과제] 누승을 구하는 재귀 함수를 선언..
	private static double recursivePower(int a, int n) {
		return 0;
	}
	
	private static double power(int a, int n) {
		// 2 , 3  = 2 * 2 *2                          -3
		int result = 1;			
		// int m = abs(n);
		int m = Math.abs(n);
		for (int i = 1; i <= m ; i++) {      // 3
				result *= a;
		}	
		return n < 0 ? (double)1/result : result;		
	}
	/*
	private static double power(int a, int n) {
		// 2 , 3  = 2 * 2 *2                          -3
		int result = 1;		
		if( n < 0 ) {
			for (int i = 1; i <= -n; i++) {      // 3
				result *= a;
			}	
			return (double)1/ result;   // 0.125
		}else {
			for (int i = 1; i <= n; i++) {
				result *= a;
			}	
			return result;
		}			
	}
	*/

} // class








