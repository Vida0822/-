package days21;

import java.util.Calendar;
import java.util.Date;

/**
 * @author dlsgu
 * @date 2023. 2. 23. 오후 2:19:47
 * @subject 날짜(date), 시간(time) + 형식화(formatting)
 * @content 컬렉션 프레임워크(컬렉션 클래스)
 * 			제네릭과 어노테이션
 * 			자바 IO(입출력)
 * 			-----------------
 * 			스레드 + 네트워크
 * 			람다식 + 스트림
 * 
 * 			DBMS - Oracle 3주 ~ 4주 (프로젝트 1주)
 */
public class Ex04 {

	public static void main(String[] args) {
		/*
		 * 1. JDK 1.0 - java.util.[Date 클래스], - deprecated 메서드
		 * 2. JDK 1.1 - java.util.Calendar 클래스
		 * 							ㄴ GregorianCalendar
		 * 3. JDK 1.8 - java.time 패키지 안에 여러 하위 패키지 및 다양한 클래스 추가
		 * */
		
		Date d = new Date();
		// Thu Feb 23 14:31:48 KST 2023
		System.out.println(d.toString());
		System.out.println(d);
		System.out.println(d.toGMTString()); // 23 Feb 2023 05:38:45 GMT Greenwich Mean Time 그리니치 평균 시간
		System.out.println(d.toLocaleString()); // 2023. 2. 23. 오후 2:38:45
		
		// 년
		System.out.println(d.getYear()+1900);
		// 월
		System.out.println(d.getMonth()+1);
		// 일
		System.out.println(d.getDate());
		// 요일
		System.out.println(d.getDay()); // 4(목)
		System.out.println("일월화수목금토".charAt(d.getDay()) + "요일"); // 목요일
		// 시간
		System.out.println(d.getHours());
		// 분
		System.out.println(d.getMinutes());
		// 초
		System.out.println(d.getSeconds());

	}//main

}//class
