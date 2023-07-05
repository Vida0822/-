package days09;

/**
 * @author kenik
 * @date  2023. 2. 7. - 오전 10:48:15
 * @subject  재귀 함수 활용. 
 * @content 
 *
 */
public class Ex02 {

	public static void main(String[] args) {
		
		int n = 10;
		
		// 1~n까지의 합을 반환하는 함수
		//int result = sum( n );		
		int result = recursiveSum( n );		
		System.out.println(result );
		// System.out.println(  sum(n)  );
		
		// 11:3 수업 시작~ 
		// recursiveSum( 10 )
		//     10 + recursiveSum( 9 )
		//                     9 + recursiveSum( 8 )
		//                            8 + recursiveSum( 7 )
		//                                             :
		//                                       2 + recursiveSum( 1 )
		
		// return 10+9+8+7+..2+1
		
	} //main

	// 1~ n 합 반환 함수 선언 + (재귀함수) [ 시험 2 ]  X  왜 ? 성능X
	// 꼭 사용하는 곳 ?  트리구조   탐색,  윈도우 탐색기.
	public static int recursiveSum(int n) {
		if( n == 1 ) return n;
		else           return  n + recursiveSum(n-1);
	}
	
	private static int sum(int n) {
		int result = 0;
		for (int i = 1; i <= n; i++) {
			result += i;
		}
		return result;
	}

} // class
