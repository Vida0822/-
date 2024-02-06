package days16;

import java.util.Arrays;

/**
 * @author ♈ kenik
 * @date 2023. 2. 16. - 오후 12:22:15
 * @subject  가변인자( varargs ) 와 오버로딩.
 * @content
 *
 */
public class Ex05 {

	public static void main(String[] args) {
		// [ 가변인자 선언 형식 ] 
		//    자료형... 변수명   == Object... args
		// System.out.printf(String format, Object... args);

		System.out.println(  Ex05.sum(1, 2) );  // 2 정수의 합을 구해서 반환하는 메서드  sum 
		System.out.println(  Ex05.sum(1, 2, 3) );   
		System.out.println(  Ex05.sum(1, 2, 3, 4) );   

		// 2,3,4,5,~1000 개 정수의 합...
		int [] m = {1,2,3,4,5,6, 7,8,9,10};
		System.out.println(  sum( m )  );

	} // main

	public static int sum(int...args) {  // 가변 인자
		/*
		int result = 0 ; 
		for (int i = 0; i < args.length; i++) { 
			result +=		 args[i]; 
		} 
		return result;
		*/
		
		// 1.5 제네릭
		// 1.8 람다와 스트림 
		// 스레드, 네트워크, 람다와 스트림 X
		// "람다와 스트림"
		return Arrays.stream(args).sum();
		
	}
	
	/*
	private static int sum( int[] m ) {

		int result = 0 ; 
		for (int i = 0; i < m.length; i++) { 
			result +=		 m[i]; 
		} 
		return result;
		
	}

	// 오버로딩( 중복함수 )	
	public static int sum(int a, int b) {
		return a + b;
	}

	public static int sum(int a, int b, int c) {
		return a + b + c;
	}

	public static int sum(int a, int b, int c, int d) {
		return a + b + c + d;
	}
	*/

} // class





