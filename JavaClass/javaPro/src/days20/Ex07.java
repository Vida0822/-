package days20;

/**
 * @author dlsgu
 * @date 2023. 2. 22. 오후 2:32:22
 * @subject
 * @content
 */
public class Ex07 {

	public static void main(String[] args) {
		// [래퍼(Wrapper)클래스]
		// 기본형 8가지를 사용하기 쉽도록 댇체화 시킨 클래스를 래퍼 클래스라고 한다
		// boolean -> Boolean
		// char -> [Character]
		// byte -> Byte
		// short -> Short
		// int -> [Integer]
		// long -> Long
		// float -> Float
		// double -> Double
		
		int i = 10;
		// "100" -> Integer
		// Integer.parseInt("100");
		Integer j = new Integer("100");
		
		// Integer -> int 반환하는 메서드
		int k = j.intValue();
		long l = j.intValue();
		
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		
		Integer.parseInt("100", 2); // 2진수 100 -> 4
		Integer.parseInt("12", 8); // 8진수 12 -> 14
		
		/*
		상속 계층도
		Object
			ㄴ Boolean
			ㄴ Character
			ㄴ Number 추상클래스
				ㄴ Byte
				ㄴ Short
				ㄴ Integer
				ㄴ Long
				ㄴ Float
				ㄴ Double
				
				ㄴ BigInteger 클래스
				ㄴ BigDecimal 클래스
		*/

	}//main

}//class
