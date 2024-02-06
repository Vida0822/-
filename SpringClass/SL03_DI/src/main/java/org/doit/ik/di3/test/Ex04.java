package org.doit.ik.di3.test;

import org.doit.ik.di3.RecordViewImpl3;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Ex04 {
	public static void main(String[] args) {
		
		String resourceLocations = "application-context3.xml" ; 
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(resourceLocations) ; 
		RecordViewImpl3 rvi = (RecordViewImpl3) ctx.getBean("rvi"); 
		
		 rvi.input(); // 성적입력 
		 rvi.output();  // 성적 출력 
		
		System.out.println("END");
	} // main
} //  Ex04
