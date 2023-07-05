package days04;

/**
 * @author dlsgu
 * @date 2023. 1. 31. 오후 2:46:10
 * @subject String -> int
 * 			int -> String 형변환
 * @content 1) 10 + ""
 * 			2) Integer.toString(10)
 * 			3) String.valueOf(10)
 */
public class Ex08 {

	public static void main(String[] args) {
		// String -> int 형변환
		
		/*
		String s = "90";
		int i = Integer.parseInt(s);
		// int i = (int)s; // cast 연산자로 int 형변환 왜 안되나
		// cast 연산자로 강제형변환 할 때는 같은 숫자 자료형 일때만 변환 가능 +) 클래스들 간의 형변환도 
		System.out.printf("i = %d\n", i);
		*/
		
		// int -> String 형변환
		int n = 10;
		// 첫번째 방법 String s = 10 + ""; // "10"
		// Integer 래퍼클래스 - MAX_VALUE, parseInt()
		// 두번째 방법
		/*
		String s = Integer.toString(n);
		System.out.println(Integer.toHexString(n)); // 16진수 문자열 반환
		System.out.println(Integer.toOctalString(n)); // 8진수 문자열 반환
		System.out.println(Integer.toBinaryString(n)); // 2진수 문자열 반환
		*/
		
		// 세번째 방법
		String s = String.valueOf(n);
		System.out.println(s);

	}//main

}//class
