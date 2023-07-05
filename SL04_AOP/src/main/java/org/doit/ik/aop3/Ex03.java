package org.doit.ik.aop3;

import org.doit.ik.aop.Calculator;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Ex03 {

	public static void main(String[] args) {
		
		// org.doit.ik.aop2.advice 패키지 - 언제
		// 전후 LogPrintAroundAdvice 클래스 추가
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("application-context3.xml");
		// Calculator calc = ctx.getBean("calc", Calculator.class);
		
		Calculator calc = ctx.getBean("calcProxy", Calculator.class);
		System.out.println(calc.add(4, 2));
		
		System.out.println("== 3 END ==");
		
	}
	
}
