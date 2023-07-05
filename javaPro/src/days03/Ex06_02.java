package days03;

/**
 * @author dlsgu
 * @date 2023. 1. 30. 오후 5:21:35
 * @subject ㄴ. 비교연산자: >	<  	>=		<=		==		!=
 * @content 비교연산자의 결과값은 boolean(true/false)이다
 */
public class Ex06_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 10, j = 5;
		System.out.println(i > j); // true
		System.out.println(i < j); // false
		System.out.println(i >= j); // true
		System.out.println(i <= j); // false
		
		// (주의할점)
		// System.out.println(i = j); // 5 -> 같다 X / 대입연산자 O
		System.out.println(i == j); // false
		System.out.println(i != j); // true
		
		// 논리연산자 ~~(내일)

	}//main

}//class
