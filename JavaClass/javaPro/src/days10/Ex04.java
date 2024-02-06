package days10;

/**
 * @author dlsgu
 * @date 2023. 2. 8. - 오전 10:43:36
 * @subject 계차수열
 * @content 
 *
 */
public class Ex04 {

	public static void main(String[] args) {
		// [정보 처리 기사 실기]
		// 수열 : 반복문, 반복규칙 적용
		// 자연수의 나열 [규칙 O]
		// 항(term)+항+항
		// 1+2+4+7+11+16+...+???=????
		//   1  2  3   4   5
		// 위의 수열의 20개 할까지의 합은 얼마인가?
		// 계차수열 일반항 = 1+{(N^2-N)/2}
		// 1+2+4+7+11+16+22+29+37+46+56+67+79+92+106+121+137+154+172+191=1350
		//   1  2  3  4    5 ... increase
		// 출력되는 각 항의 값을 저장할 변수 : term
		
		int term = 1;
		int increase = 0; // 증가치
		int sum = 0;
		
		for (int i = 1; i <= 20; i++) {
			term += increase;
			sum += term;
			System.out.printf("%d+", term);
			increase++;
		}
		System.out.printf("\b=%d", sum);
		
		/*
		int term = 1;
		int increase = 1; // 증가치
		
		// 첫번째 항
		System.out.printf("%d+", term);
		
		// 두번째 항부터 반복
		term += increase;
		System.out.printf("%d+", term);
		increase++;
		 */
		
		/*
		int term  ;
	      int sum = 0 ;
	      for (int i = 1; i <=20; i++) {
	          term = (int) (1+(  (Math.pow( i, 2 )-i)/2 ));
	          sum  += term;
	          System.out.printf("%d+", term);
	      }
	      System.out.printf("\b=%d\n", sum);
		 */

		/*
		int n = 1;
		int sum = 1;
		System.out.printf("%d+", n);
		for (int i = 1; i <= 19; i++) {
			n += i;
			System.out.printf("%d+", n);
			sum += n;
		}
		System.out.printf("\b=%d\n", sum);
		 */

	}//main

}//class
