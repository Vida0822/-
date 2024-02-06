package org.doit.ik.aop;

public class Ex01 {

	public static void main(String[] args) {
		/*
		org.doit.ik.aop 패키지 추가
			ㄴ Ex01.java
			ㄴ Calculator 인터페이스 + - * / 추상메서드 선언
			ㄴ CalculatorImpl 클래스 구현
		*/
		
		Calculator calc = new CalculatorImpl();
		System.out.println(calc.add(4, 2));
		System.out.println(calc.sub(4, 2));
		System.out.println(calc.mult(4, 2));
		System.out.println(calc.div(4, 2));
		
		System.out.println("== 1 END ==");
		
	}
	
}
