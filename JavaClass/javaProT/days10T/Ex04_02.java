package days10;

/**
 * @author kenik
 * @date  2023. 2. 8. - 오전 11:42:55
 * @subject 
 * @content 
 *
 */
public class Ex04_02 {

	public static void main(String[] args) {
		// [ 정보처리 기사 실기]
		// 피보나치( fibonacci) 수열 : 첫 번째, 두 번째   - 1, 1
		// 1 + 1 + 2 + 3 + 5 + 8+ 13 + 21 + 34 +....=???
		// f    s   n
		//       f   s    n
		//            f    s      n
		// 12:00 쉬는시간 + 10분
		// 12:11 수업시작~
		// [문제]  <=100
		
		int firstTerm = 1;
		int secondTerm = 1;		
		int nextTerm  ;
		int sum = firstTerm + secondTerm;  // 2		
		System.out.printf("%d+%d+", firstTerm, secondTerm);
		//          1+1+2+3+5+..55+ 89 = 232
		//                                 f      s
		// sum = 12
		/*
		while( true ) {
			nextTerm = firstTerm + secondTerm;		//  144	
			if( nextTerm > 100 ) break;
			System.out.printf("%d+", nextTerm);
			sum += nextTerm;		
			
			firstTerm = secondTerm;  // 1
			secondTerm = nextTerm;  // 2
		} // 
		*/
		
		while( (nextTerm = firstTerm + secondTerm) <= 100 ) {
			System.out.printf("%d+", nextTerm);
			sum += nextTerm;		
			
			firstTerm = secondTerm;  // 1
			secondTerm = nextTerm;  // 2
		} // 
		
		System.out.printf("\b=%d\n", sum);
		
		/*
		// 3 
		nextTerm = firstTerm + secondTerm;
		System.out.printf("%d+", nextTerm);
		sum += nextTerm;		
		firstTerm = secondTerm;
		secondTerm = nextTerm;
		
		// 4.  
		nextTerm = firstTerm + secondTerm;
		System.out.printf("%d+", nextTerm);
		sum += nextTerm;		
		firstTerm = secondTerm;
		secondTerm = nextTerm;
		
		// 5. 
		nextTerm = firstTerm + secondTerm;
		System.out.printf("%d+", nextTerm);
		sum += nextTerm;		
		firstTerm = secondTerm;
		secondTerm = nextTerm;
		*/
		
		
		

	} // main

} // class







