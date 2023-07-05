package days03;

/**
 * @author dlsgu
 * @date 2023. 1. 30. 오후 3:32:57
 * @subject 형변환 예제
 * @content 래퍼 클래스란: 기본형을 사용하기 쉽도록 포장(가공/구현)해놓은 클래스
 * 				   Integer.MAX_VALUE
 * 				   Integer.MIN_VALUE
 */
public class Ex04_02 {

	public static void main(String[] args) {
		//int i = 2147483647;
		// 기본형 -> 래퍼(Wrapper)클래스: 기본형을 사용하기 쉽도록 포장(가공/구현)해놓은 클래스
		// int -> Integer 클래스
		int i = Integer.MAX_VALUE;
		int j = 100;
		long k = (long)i + j;
		// i = [][][][]
		// j = [][][][]
		// k = [][][][] - int로 표현할 수 있는 값의 범위를 벗어난다 -> 산술오버플로우/언더플로우
		
		System.out.printf("%d + %d = %d\n", i, j, k);
		
		// float f = 3.14;
		// float f = (float)3.14;
		// float f = 3.14f;

	}//main

}//class
