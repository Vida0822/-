package days09;

/**
 * @author dlsgu
 * @date 2023. 2. 7. 오전 11:23:36
 * @subject 재귀함수 - 일반함수, 팩토리얼 재귀함수
 * @content
 */
public class Ex02_02 {

	public static void main(String[] args) {
		/*
		 * 1. 팩토리얼(factorial) == 계승
		 * */
		
		int n = 5;
		// int result = factorial(n);
		int result = recursiveFactorial(n);
		System.out.println(result == -1 ? "입력이 잘못되었습니다" : result);
		
	}//main

	// 팩토리얼 재귀함수
	public static int recursiveFactorial(int n) {
		if (n > 1) return n * recursiveFactorial(n-1);
		else if (n==1 || n==0) return 1;
		else return -1;

	}
	
	public static int factorial(int n) {
		int result = 1;
		for (int i = n; i >= 1; i--) {
			result*=i;
		}
		return result;
	}

}//class
