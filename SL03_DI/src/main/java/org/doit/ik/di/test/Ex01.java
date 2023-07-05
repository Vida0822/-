package org.doit.ik.di.test;

import org.doit.ik.di.RecordImpl;
import org.doit.ik.di.RecordViewImpl;

public class Ex01 {

	public static void main(String[] args) {
		
		// org.doit.ik.di 패키지
			// ㄴ Record.java 인터페이스 
			// ㄴ RecordImpl.java 클래스 
			// ㄴ RecordView.java 인터페이스 
			// ㄴ RecordViewImpl.java 클래스 
		
		RecordImpl record = new RecordImpl() ; 
		
		// 1. 생성자 DI (자바도)
		// RecordViewImpl rvi = new RecordViewImpl(record);
		// 2. setter DI (자바도)
		 RecordViewImpl rvi = new RecordViewImpl();
		 rvi.setRecord(record);
		
		 rvi.input(); // 성적입력 
		 rvi.output();  // 성적 출력 
		
		System.out.println("END");
	} // main 
} // ex01 
