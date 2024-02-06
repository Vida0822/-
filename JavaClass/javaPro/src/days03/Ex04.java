package days03;

/**
 * @author dlsgu
 * @date 2023. 1. 30. 오후 2:51:04
 * @subject 형(type)변환 == 자료형 [ 시험문제]
 * @content 1. 형변환이란
 * 				   2. 형변환 종류
 */
public class Ex04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * 1. 모든 변수, 리터럴은 자료형이 있다
		 * 		자료형 변수명;
		 * 
		 * 2. true, false -> boolean
		 * 		1, 2, 100  -> int
		 * 		3.14        -> double
		 * 		'A', 'X'      -> char
		 * 		"홍길동"     -> String
		 * 
		 * 3. 프로그램을 작성하다보면 서로 다른 타입(자료형)간의 연산을 수행할 때가 있다
		 * 서로 다른 자료형을 일치시켜야 할 필요가 있다
		 * "형변환"이라고 한다
		 * 
		 * 4. 형변환
		 * 		1) 강제 형변환
		 * 		2) 자동 형변환
		 * 			ㄱ. 작은 자료형 +(연산) 큰 자료형 -> 자동으로 큰 자료형으로 연산
		 * 			ex) int + double -> double
		 * 
		 * 				[자료형의 크기]
		 * 				byte(2) < short(2) / char(2) < int(4) < long(8) < float(4) < double(8)
		 * 
		 * 			ㄴ. 좌측 큰 자료형 = 우측 작은 자료형일 때 자동으로 형변환된다 (반대의 경우는 되지 않음)
		 * 			ex) double result = 300;
		 * */
		
		/*
		int i = 100; // int 4바이트 정수:              [][][][01101100]
		double d = 3.14; // double 8바이트 실수: [][][][][][][][]
		
		double result = d + i; // double d + int i -> double 자동 형변환
		System.out.println(result);
		*/
		
		/*
		int i = 100;
		int j = 200;
		long result = i + j;
		System.out.println(result);
		*/
		
		// [강제형변환]
		// 우측이 좌측보다 더 큰 자료형이기 때문에 자동형변환이 되지 않는다
		//float f = 3.14; -> float f = 3.14F; 접미사 활용
		
		// double -> float 강제로 형변환
		// 이 때 사용하는 연산자 "cast 연산자"
		// "cast 강제 형변환"
		float f = (float)3.14; // 피연산자
		//          (변환하고자하는 자료형) cast 연산자
		
		// 연산자 우선순위: 곱셈 > 덧셈
		// 3 + 5 * 2 = 13
		
		// () 연산자 - 최우선 연산자
		// (3 + 5) * 2 = 16

	}//main

}//class
