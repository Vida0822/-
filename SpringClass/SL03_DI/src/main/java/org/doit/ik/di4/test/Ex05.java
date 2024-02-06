package org.doit.ik.di4.test;

import org.doit.ik.di4.RecordViewImpl4;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Ex05 {
	public static void main(String[] args) {
		
		String resourceLocations = "application-context4.xml" ; 
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(resourceLocations) ; 
		RecordViewImpl4 rvi = (RecordViewImpl4) ctx.getBean("recordViewImpl4"); 
		
		 rvi.input(); // 성적입력 
		 rvi.output();  // 성적 출력 
		
		System.out.println("END");
	} // main
} //  Ex04
