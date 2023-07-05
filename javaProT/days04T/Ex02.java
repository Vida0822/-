package days04;

/**
 * @author kenik
 * @date  2023. 1. 31. - 오전 10:41:23
 * @subject   논리 연산자.
 * @content     1)  일반 논리 연산자
 *                                  &&  일반논리 AND 연산자( 논리곱 )
 *                                         참(t 1) && 참  => 참
 *                                         참 && 거짓  => 거짓
 *                                         거짓(f 0) && 참  => 거짓
 *                                         거짓 && 거짓  => 거짓
 *                                         
 *                                         모두 참일 때만 참인 연산자. 
 *                                 
 *                                 ||     일반논리 OR 연산자( 논리합 ) 
 *                                    참 || 참 =>  참
 *                                    참 || 거짓 =>  참
 *                                    거짓 || 참 =>  참
 *                                    거짓 || 거짓 =>  거짓
 *                                    
 *                                    하나라도 참이면 참이다. 
 *                                 
 *                                  11:05 수업시작~~ 
 *                                  !      부정(NOT) 연산자
 *                                  
 *                                  !참 => 거짓
 *                                  !거짓 => 참
 *                                  
 *                                  연산자 우선 순위    ! >  &&   >    ||
 *                                  
 *                        2) 비트 논리 연산자   Ex02_02.java 
 *
 */
public class Ex02 {

	public static void main(String[] args) {
		// 연산자
		//  1. 산술연산자 + - * / %
		//  2. 비교연산자  > < >= <=  == !=
		//  3. 논리연산자.  
		
		// 연산자 우선 순위 :      산술 > 비교 > 논리 
		// 효율적인 연산( short circuit evaluation ) 
		System.out.println(   3 > 5    &&   10 > 7 );  // false 
		
		System.out.println(   3 <  5    ||   10 < 7 );  // true
		
		// The operator ! is undefined for the argument type(s) int
		// !int X
		
		// !           <
		System.out.println(   !( 3 <  5)   );  // true -> false

	} // main

} // class
