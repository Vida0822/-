package days04;

/**
 * @author dlsgu
 * @date 2023. 1. 31. 오전 11:12:19
 * @subject 비트 논리연산자 (자바에서 쓸 일은 없을 것)
 * @content 1) & 비트 논리 AND 연산자
 * 			2) | 비트 논리 OR 연산자
 * 			3) ^ XOR 연산자 - eXclusive OR 연산자 / 배타적인 == 서로 다른 == 서로 다를 때 참인 연산자
 * 			4) ~ 비트 부정(틸드) 연산자
 * 
 * 			연산자 우선순위 ~ > & > ^ > |
 */
public class Ex02_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 10; // 0000 1010
		System.out.println(~i); // -11  1111 0101 -> 1111 0100 -> 0000 1011 -> -11
		System.out.println(i&3); // 2
		System.out.println(i|3); // 11
		System.out.println(i^3); // 9

	}

}
