package days23;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * @author ♈ kenik
 * @date 2023. 2. 27. - 오전 7:52:32
 * @subject
 * @content
 *
 */
public class Ex01 {

	public static void main(String[] args) {
		// 9:30 제출
		/*
		 *   D, C 
		 *   get() / set()
		 *   add(날짜, 100) = 만년 달력
		 *   
		 *   [불변]
		 *   JDK 1.8 java.time 패키지 추가 + 핵심틀래스
		 *   날짜  LocalDate   implements Temporal, TemporalAdjuster
		 *   시간  LocalTime
		 *   날짜+시간  LocalDateTime
		 *   날짜+시간+타임존 ZonedDateTime
		 *   
		 *   Period  날짜 - 날짜   implements  TemporalAmount
		 *   Duration 시간 - 시간
		 *   
		 *   TemporalField
		 *   TemporalUnit
		 *   
		 *   [ 메서드 정리 ]
		 *   1) 객체 생성 :  now() , of()
		 *   2) 특정 필드 값 얻어올 때  :  get(), getXXX()
		 *   3) 필드 값 변경  : plusXXX(),  minusXXX()
		 *                              plus()           minus()
		 *                              with() 
		 * */
		
		// 1989.02.24
		// (요일)
		LocalDate d = LocalDate.now(); 
		// LocalDate d = LocalDate.of(1989, 2, 24);
		// [ 불변 ]
		d = d.withYear(1989);
		d = d.withMonth(2);
		d = d.withDayOfMonth(24);
		
		
		
		DayOfWeek   dow =  d.getDayOfWeek();  // 
		System.out.println(  dow  );  // FRIDAY
		System.out.println(  dow.getValue()  );  // 5
		
		int dayOfWeek = d.get(  ChronoField.DAY_OF_WEEK  );	
		System.out.println( dayOfWeek );  // 5

		
	} // main

} // class






/*
 * 1조_연봉1조          : [팀장]이태규(*), 김지은(*), 설경인(*), 윤재민(*), 홍성철, 김동현, 박상범 (화요일)
 * 2조_귀염2(이)조  : [팀장]하동호(*), 박진용(*), 이혜진(*), 김수민, 신희민, 진예림, 박현주 (수요일)
 * 3조_자바를 잡아  : [팀장]박민종(*), 심성환(*), 이진우(*), 홍찬기(*), 김예지, 하지예 , 탁인혁 (목요일)
 */
