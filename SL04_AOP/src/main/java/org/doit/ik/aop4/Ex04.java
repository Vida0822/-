package org.doit.ik.aop4;

import org.doit.ik.aop.Calculator;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Ex04 {

	public static void main(String[] args) {
		
		/*
		p 211 xml 설정 파일에 <aop:config> 태그를 이용해서
		1) Aspect 설정
		2) Advice + 어떤 pointcut에 적용할지를 설정
		*/
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("application-context4.xml");
		
		// 스프링 aop : 프록시
		Calculator calc = ctx.getBean("calc4", Calculator.class);
		System.out.println(calc.add(4, 2));
		
		System.out.println("== 4 END ==");
		
	}
	
}
