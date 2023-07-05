package days10;

import java.util.Iterator;

/**
 * @author kenik
 * @date  2023. 2. 8. - 오전 10:37:34
 * @subject 
 * @content 
 *
 */
public class Ex04 {

	public static void main(String[] args) {
		//[ 정보 처리 기사 실기 ]
		// 수열 :   반복문 , 반복규칙  적용...
		// 자연수(양의 정수)의 나열
		// [규칙 O], 규칙 X
		// 항(term) + 항 + 항
		//  1 + 2 + 4 + 7 +  11 + 16 + ...  191 = ???
		//     1    2    3     4     5 
		// 위의 수열의  20개 항까지의 합 얼마인가 ?   
		// 10:57 쉬는시간 + 10분
		// 풀이) 11: 10 수업 시작~    ***  계차수열 ?  191 => 일반항= 1+{(N^2-N)/2}
		// term      1+2+4+7+11+16+22+29+37+46+56+67+79+92+106+121+137+154+172+191+=1350
		// increase  1   2  3  4   5 ..  increase
		// 출력되는 각 항의 값을 저장할 변수 : term
		
		int term = 1;
		int increase = 0;  // 증가치
		int sum = 0;
		
		for (int i = 1; i <= 20; i++) {  // 반복 횟수   i == increase
			term += increase;
			sum += term;
			System.out.printf("%d+", term);   // 1+2+
			increase++; // 2
		} // for
		System.out.printf("\b=%d\n", sum );
		
		/*
		int term = 1;
		int increase =1;  // 증가치
		
		// 첫 번째 항
		System.out.printf("%d+", term);   // 1+
		
		// 두 번째 항
		term += increase;
		System.out.printf("%d+", term);   // 1+2+
		increase++; // 2
		
		// 세 번째 항
		term += increase;
		System.out.printf("%d+", term);   // 1+2+
		increase++; // 2
		
		term += increase;
		System.out.printf("%d+", term);   // 1+2+
		increase++; // 2
		
		term += increase;
		System.out.printf("%d+", term);   // 1+2+
		increase++; // 2
		*/
		

	} // main

} // class





/*
int plus = 1;
int sum = 0;
for (int i = 1; i <= 20; i++) {
   System.out.printf("%d+",plus);
   sum += plus;
   plus += i;
}
System.out.printf("\b=%d",sum);
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
//i=123
// [1][2][][][][][][][][]
 int a[] = new int [20];
 a[0] = 1;
  System.out.printf( "%d+",  a[0]);
  for (int i = 1; i <= 19; i++) {
         a[i] = a[i-1] + i;
         System.out.printf( "%d+",  a[i]);
  }
*/

/* [백XX]
int term = 1;
int n = 20;
for (int i = 2; i <= n; i++) {
   term += (i-1); 
}
System.out.println(term);
* */



 





