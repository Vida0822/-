package days04;

/**
 * @author kenik
 * @date  2023. 1. 31. - 오후 2:46:21
 * @subject 
 * @content [ String -> int ] 형 변환 
 *                     int -> String  형변환
 *                     1)  10 + ""
 *                     2) Integer.toString( 10 )
 *                     3) String.valueOf( 10 )
 *
 */
public class Ex08 {

	public static void main(String[] args) {
		// [ String -> int ] 형 변환 
		/*
		int x = 10;
		char y = (char)x; 

		String s = "90";
		 int i = Integer.parseInt(s);
		// int i = (int)s;  // cast 연산자로 int 형변환.  왜?
		// cast 연산자로 강제형변환할 때는   같은 숫자형일때만 변환 가능
		//                     ㄴ 클래스들 간의 형변환
		System.out.printf("i = %d\n", i );
		*/

		// 3:05 수업 시작~
		// int -> String  형변환
		int n = 10;
		// 첫번째 방법 : String s =  10 +""; // "10"
		// Integer  래퍼 클래스 - MAX_VALUE, parseInt()
		/* 두 번째 방법
		String s = Integer.toString(   n   );
		System.out.println( Integer.toHexString(n) );    // 16진수 문자열 반환
		System.out.println( Integer.toOctalString(n) );  // 8진수 문자열 반환
		System.out.println( Integer.toBinaryString(n) ); // 2진수 문자열 반환
		*/
		// 세 번째 방법
		String s =  String.valueOf(n);
		
		
	} // main

} // class





