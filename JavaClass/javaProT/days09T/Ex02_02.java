package days09;

/**
 * @author kenik
 * @date  2023. 2. 7. - 오전 11:20:59
 * @subject  재귀 함수 -   일반함수,  팩토리얼 재귀 함수
 * @content 
 *
 */
public class Ex02_02 {

	public static void main(String[] args) {
		/*
		 * 1. 팩토리얼( factorial ) == 계승
		 *     정의 ) 1에서 양의 정수의 곱
		 *     n! = n*(n-1)*(n-2)*...*1
		 *     5! = 5*4*3*2*1
		 *     0! == 1 ( 약속 )
		 * */
		
		int n = -5;
		//int result = factorial( n );
		int result = recursiveFactorial( n );
		System.out.println( result ==- 1 ? "입력 잘못!!" : result );

	} // main
	
	// 팩토리얼 재귀 함수
	// 5!=5*4*3*2*1
	// 0!    1
	// -5! 입력잘못
	private static int recursiveFactorial(int n) {
		if( n > 1 )            return  n * recursiveFactorial(n-1);
		else if( n == 1  || n == 0) return 1;
		else   return -1; 
			
	}
	

	private static int factorial(int n) {
		int result = 1;
		for (int i = n; i >=1;  i--) {  // 5 4 3 2 1
			result *= i;
		}
		return result;
	}

} // class









