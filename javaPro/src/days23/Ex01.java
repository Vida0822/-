package days23;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

/**
 * @author dlsgu
 * @date 2023. 2. 27. 오전 9:06:21
 * @subject
 * @content
 */
public class Ex01 {

	public static void main(String[] args) {
		/*
		 * D, C
		 * get, set, add
		 * 
		 * [불변]
		 * JDK 1.8 java.time 패키지 추가 + 핵심클래스
		 * implements Temporal, TemporalAdjuster
		 * 날짜 LocalDate
		 * 시간 LocalTime
		 * 날짜+시간 LocalDateTime
		 * 날짜+시간+타임존 ZonedDateTime
		 * 
		 * implements TemporalAmount
		 * Period 날짜 - 날짜
		 * Duration 시간 - 시간
		 * 
		 * TemporalField
		 * TemporalUnit
		 * 
		 * [메서드 정리]
		 * 1) 객체 생성 : now(), of()
		 * 2) 특정 필드 값을 얻어올 때 : get(), getXXX()
		 * 3) 필드값 변경 : plus(), plusXXX(), minus(), minusXXX(), with()
		 * */
		
		/*
		// 4. 개강일(2023.1.26)로부터 100일 되는 날짜를 출력하세요. 
		// (조건: LocalDate 클래스 사용.) 
		LocalDate odate = LocalDate.of(2023, 1, 26);
		// LocalDate rdate = odate.plusDays(100);
		LocalDate rdate = odate.plus(100, ChronoUnit.DAYS);
		
		// odate.withDayOfMonth(1);
		// odate.with(ChronoField.DAY_OF_MONTH, 1);
		
		System.out.println(rdate.toString());
		*/
		
		// 1989.02.24
		// (요일)
		// LocalDate d = LocalDate.of(1989, 2, 24);
		LocalDate d = LocalDate.now();
		d = d.withYear(1989);
		d = d.withMonth(2);
		d = d.withDayOfMonth(24);
		
		DayOfWeek dow = d.getDayOfWeek();
		System.out.println(dow); // FRIDAY
		System.out.println(dow.getValue()); // 5
		
		int dayOfWeek = d.get(ChronoField.DAY_OF_WEEK);
		System.out.println(dayOfWeek);
		

	}//main

}//class
