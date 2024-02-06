package days10;

/**
 * @author dlsgu
 * @date 2023. 2. 8. - 오전 11:43:18
 * @subject 피보나치 수열 [시험문제 2]
 * @content 
 *
 */
public class Ex04_02 {

	public static void main(String[] args) {
		// [정보처리기사]실기
		// 피보나치 (fibonacci) 수열 : 첫번째, 두번째 = 1, 1
		// 1+1+2+3+5+8+13+21+34+...=???
		// f   s  n
		//     f   s  n
		// [문제] term <= 100 까지
		/*
		int firstTerm = 1;
		int secondTerm = 1;
		int nextTerm;
		int sum = firstTerm + secondTerm;
		System.out.printf("%d+%d+", firstTerm, secondTerm);
		
		while (true) {
			nextTerm = firstTerm + secondTerm;
			if (nextTerm>100) break;
			System.out.printf("%d+", nextTerm);
			sum += nextTerm;
			firstTerm = secondTerm;
			secondTerm = nextTerm;
		}
		System.out.printf("\b=%d\n", sum);
		*/
		
		int firstTerm = 1;
		int secondTerm = 1;
		int nextTerm;
		int sum = firstTerm + secondTerm;
		System.out.printf("%d+%d+", firstTerm, secondTerm);
		
		while ((nextTerm = firstTerm + secondTerm) <= 100) {
			System.out.printf("%d+", nextTerm);
			sum += nextTerm;
			firstTerm = secondTerm;
			secondTerm = nextTerm;
		}
		System.out.printf("\b=%d\n", sum);
		
		/*
		// [문제] term <= 100 까지
		int term1 = 1;
		int term2 = 1;
		int term = 0;
		int sum = 2;
		System.out.print("1+1+");
		while (term <= 100) {
			term = term1+term2;
			System.out.printf("%d+", term);
			sum += term;
			term2 = term1;
			term1 = term;
		}
		System.out.printf("\b=%d\n", sum);
		*/
		
		/*
		// [문제] 20번째 항까지
		int term1 = 1;
		int term2 = 1;
		int term = 0;
		int sum = 2;
		System.out.print("1+1+");
		while (term <= 100) {
			term = term1+term2;
			System.out.printf("%d+", term);
			sum += term;
			term2 = term1;
			term1 = term;
		}
		System.out.printf("\b=%d\n", sum);
		*/

	}//main

}//class
