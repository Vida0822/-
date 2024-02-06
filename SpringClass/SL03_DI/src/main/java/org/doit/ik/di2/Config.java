package org.doit.ik.di2;

import org.doit.ik.di.RecordImpl;
import org.doit.ik.di.RecordViewImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// application-context.xml == 자바 클래스 설정파일 
@Configuration
public class Config { 
	
	// 	RecordViewImpl rvi = new RecordViewImpl();
	/* <bean id="record" class="org.doit.ik.di.RecordImpl"></bean> */
	/* 100% 똑같은 코딩 */ 
	@Bean
	public RecordImpl record() {
		return new RecordImpl() ; 
	} // record
	/*
	 * <bean id="rvi" class="org.doit.ik.di.RecordViewImpl"> 
	 * <property name="setRecord" ref="record"></property> 
	 * <property name="record" ref="record"/> -->
	 * <!-- ref : 참조하는 객체 / name : setter 함수 이름 --> 
	 * <property name="record"> <ref bean="record"/> </property> -->
	 */
	
	@Bean(name="rvi")
	public RecordViewImpl getRecordViewImpl() {
		RecordViewImpl rvi = new RecordViewImpl() ; 
		rvi.setRecord(record());
		return rvi ; 
	}// getRecordViewImpl
} // Config
 