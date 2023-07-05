package org.doit.ik.aop5;

import org.doit.ik.aop.Calculator;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Ex05 {

	public static void main(String[] args) {
		/*
		[ p 226 @Aspect 어노테이션 기반의 AOP 구현하는 방법 ]
		1) Aspect 설정
		2) Advice + 어떤 pointcut에 적용할지를 설정
		*/
		/*
		1) Calculator 인터페이스
		+ - * /
		2) CalculatorImpl 클래스
		+ - * / 오버라이딩(핵심기능) + 공통기능(처리시간 로그)
		*/
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("application-context5.xml");
		
		// 스프링 aop : 프록시
		Calculator calc = ctx.getBean("calc5", Calculator.class);
		System.out.println(calc.add(4, 2));
		
		System.out.println("== 5 END ==");
		
	}
	
}
