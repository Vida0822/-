package days03;

/**
 * @author dlsgu
 * @date 2023. 1. 30. 오후 2:15:19
 * @subject 실수 -> 2진수 표현
 * @content
 */
public class Ex03 {

	public static void main(String[] args) {
		/*
		 * 1. 실수 - .소수점
		 * ex) 3.14, 3.0, 3.
		 * 
		 * 2. 자바에서 숫자계열 중 실수를 나타내는 자료형 - float(4), double(8)
		 * 
		 * float [S][8][][][][][][] [E][23][][][][][][] [][][][][][][][] [][][][][][][][M]
		 * double [S][11][][][][][][] [][][][E][52][][][] [][][][][][][][] [][][][][][][][] [][][][][][][][] [][][][][][][][] [][][][][][][][] [][][][][][][][M]
		 * 
		 * float 단정도 정밀도 23
		 * double 배정도 정밀도 52
		 * 
		 * 3.626 실수
		 * 3 -> 2진수 -> 11
		 * 0.625 -> 2진수 -> [1][0][1]
		 * 
		 * 0.625 * 2 = [1].25
		 * 0.25 * 2 = [0].5
		 * 0.5 * 2 = [1].0
		 * 
		 * 3.625 -> 2진수 -> 11.101
		 * 
		 * 부동소수점표기(정수 1자리만)
		 * 11.101 -> 1.1101 x 2^1
		 * 0.1101 -> 가수, ^1 -> 지수
		 * ex) 0.0001010101111 -> 1.010101111 x 2^(-4)
		 * 
		 * 9.1234567 유한소수 -> 2진수 -> 무한소수 -> 오차발생
		 * float보다 double이 오차가 작다
		 * 실수는 무조건 오차가 적은 double로 선언한다
		 * [BigDecimal 클래스]
		 * 
		 * */
		
		//[문제] 키와 몸무게를 저장할 변수를 선언하세요
		// 키: 179.8cm 실수 float
		// 몸무게: 65.6kg 실수 double
		// 에러 - Type mismatch: cannot convert from double to float -> float = double 타입 불일치
		//float height = 179.8;
		float height = 179.8F;
		double weight = 65.6D;
		
		System.out.printf("키=%f, 몸무게=%f\n", height, weight);
		
		/* [시험문제]
		 * 다른 자료형(타입)이다
		 * 0  int
		 * 0.(d, D) double
		 * 0f(F) float
		 * 0l(L) long
		 * */

	}//main

}//class
