package org.doit.ik.di.test;


import org.doit.ik.di.RecordViewImpl;
import org.doit.ik.di2.Config;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Ex03 {
	
	public static void main(String[] args) {
		// 자바 클래스 + 설정파일 
		
		/*
		 * 1. 스프링 객체 생성 + 조립 -> 스프링 컨테이너 
		 * 2. 2가지 방법 
		 * 		1) xml 파일 이용 				
		 * 			ㄴ src/main/resources  => application-context.xml 추가 
		 * 		2) java (클래스) 파일 
		 */

		AnnotationConfigApplicationContext ctx 
			= new AnnotationConfigApplicationContext(Config.class) ; 
		
		// RecordViewImpl rvi = (RecordViewImpl) ctx.getBean("rvi"); 
		// No bean named 'getRecordViewImpl' available
		// xml 에선 빈 이름을 rvi 로 줬음 ! 
		// RecordViewImpl rvi = (RecordViewImpl) ctx.getBean("getRecordViewImpl"); 
 		RecordViewImpl rvi = (RecordViewImpl) ctx.getBean("rvi"); 
		
		rvi.input(); // 성적입력 
		rvi.output();  // 성적 출력 
		System.out.println("END");
	} // main 

} // ex03
