package days03;

/**
 * @author kenik
 * @date 2023. 1. 30. - 오후 4:54:25
 * @subject  연산자( operator )
 * @content
 *
 */
public class Ex06 {

	public static void main(String[] args) {
		// 5:05 수업시작
		/*
		 * 1. 연산자(operator)
		 *     1) 정의 : '연산을 수행하는 기호'    예) + , - , / 등등
		 *     2) 피연산자( operand ) : 연산의 대상
		 *        예)   3 + 5
		 *                    + 연산자
		 *                3     5 연산의 대상( 피연산자)    
		 *  2. 식( expression )
		 *      1) 연산자와 피연산자를 조합하여 계산하고자 하는 바를 표현한 것.
		 *              
		 *  3. 연산자의 종류
		 *      1) 항(피연산자)의 갯수에 따라       단항, 이항, 삼항연산자.
		 *            3 + 5   덧셈연산자 == 이항연션자     
		 *      2) 기능에 따라서 
		 *           ㄱ. 산술연산자    +
		 *           ㄴ. 비교연산자            Ex06_02.java
		 *           ㄷ. 논리연산자
		 *           ㄹ. 대입연산자
		 *           등등      
		 * */
		
		// ㄱ. 산술 연산자( 이항연산자 )
		int i = 10, j = 3;
		System.out.println(  i + j ); // 13
		System.out.println(  i - j ); // 7
		System.out.println(  i * j );  // 30
		System.out.println(  i / j );  // 3.33333 X        3
		System.out.println(  i % j );  // 나머지 연산자 
		
		//  (주의할점)
		// System.out.println(  10 / 0  );      // 정수 / 0    ArithmeticException( 산술적 예외) 발생.: / by zero
		// System.out.println(  10 % 0  );     // 정수% 0   ArithmeticException( 산술적 예외) 발생.: / by zero

		System.out.println(  10.0 / 0  );  // 실수 / 0     Infinity ( 무한대 )
		System.out.println(  10.0 % 0  );  // 실수 % 0     NaN (  Not a Number 숫자가 아니다. )
		
	} // main

} // class









