package days10;

/**
 * @author dlsgu
 * @date 2023. 2. 8. - 오후 5:12:15
 * @subject [시험문제 1]
 * @content 
 *
 */
public class Ex03 {

	public static void main(String[] args) {
		// 1/2+2/3+3/4+ ... +8/9+9/10= ???
		// for/while 반복문/조건반복문 - (반복 규칙)

		// 분자/분모 == i/(i+1)
		double sum = 0;
		for (int i = 1; i <= 9; i++) {
			System.out.printf("%d/%d+", i, i+1);
			sum += (double)i/(i+1);
		}
		System.out.printf("\b=%f\n", sum);

		/*
		int n = 9;

		double sum = recursiveSum(n);
		System.out.println(sum);
		*/

	}//main

	public static double recursiveSum(int n) {
		if (n == 1) return (double)n/(n+1);
		else return (double)n/(n+1) + recursiveSum(n-1);
	}
		
}//class
