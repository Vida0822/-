package org.doit.ik.di.test;

import org.doit.ik.di.RecordViewImpl;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Ex02 {

	public static void main(String[] args) {
		
		/*
		  1. 스프링 객체 생성 + 조립 -> 스프링 컨테이너 
		  2. 2가지 방법 
		  		1) xml 파일 이용 				
		  			ㄴ src/main/resources  => application-context.xml 추가 
		  		2) java (클래스) 파일 
		 */
		
		String resourceLocations = "application-context.xml" ; 
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(resourceLocations) ; 
		// GenericXmlApplicationContext : 조립기 기능을 구현한 클래스 
		// => 매개변수로 xml 파일 넣어줌 : 
		RecordViewImpl rvi = (RecordViewImpl) ctx.getBean("rvi"); 
		
		 rvi.input(); // 성적입력 
		 rvi.output();  // 성적 출력 
		
		System.out.println("END");
		
		
	} // main 
} // ex02
