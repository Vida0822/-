package days09;

/**
 * @author dlsgu
 * @date 2023. 2. 7. 오전 11:46:59
 * @subject 재귀함수
 * @content
 */
public class Ex02_03 {

	public static void main(String[] args) {
		/*
		 * [합]
		 * [팩토리얼]
		 * [거듭제곱] == 누승 == 멱== pow
		 * */
		
		// int result = power(2,3); // 2 밑, 3 지수
		// double result = power(2,-3); // 2 밑, -3 지수
		double result = recursivePower(2,3); // 2 밑, 3 지수
		System.out.println(result);

	}//main

	/*
	public static double power(int a, int n) {
		int result = 1;
		if (n >= 1) {
			for (int i = 1; i <= n; i++) {
				result *= a;
			}
			return result;
		} else if (n <=- 1) {
			for (int i = 1; i <= -n; i++) {
				result *= a;
			}
			return (double)1/result;
		}
	}
	*/
	
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
	
	public static int abs(int i) {
		if(i<0) return i*-1;
		else return i;
	}
	
	//[과제] 누승을 구하는 재귀함수를 선언
	public static double recursivePower(int a, int n) {
		int m = abs(n);
		if (m>1) return a * recursivePower(a, m-1);
		else if (n==0) return 1;
		return 0;
	}
	
	public static double power(int a, int n) {
	      int result = 1;
	      int m = abs(n);
	      //int m = Math.abs(n)
	      for (int i = 1; i <= m; i++) {
	         result *= a;
	      }
	      return n<0 ? (double)1/result : result;
	   }
	
}//class
