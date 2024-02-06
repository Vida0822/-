package days22;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoField;

/**
 * @author ♈ kenik
 * @date 2023. 2. 24. - 오후 4:33:25
 * @subject
 * @content
 *
 */
public class Ex08 {

	public static void main(String[] args) {
		// 날짜만 다루는 클래스
		// new 연산자로 객체 생성할 수 없다. 
		LocalDate d =   LocalDate.now() ;
		System.out.println(  d );   // "2023-02-24"
		// 년
		int year =  d.get(  ChronoField.YEAR  );
		System.out.println( year );
		year = d.getYear();
		System.out.println( year );
		// 월
		int month = d.get( ChronoField.MONTH_OF_YEAR  );
		System.out.println(  month );
		month = d.getMonthValue();
		System.out.println(  month );
		
		Month   m =  d.getMonth();   // Month 열거형(enum)
		System.out.println( m );
		
		// 일
		int day = d.getDayOfMonth();
		System.out.println(  day  );
		day = d.get( ChronoField.DAY_OF_MONTH  );
		System.out.println(  day  );
		// 요일
		DayOfWeek   dof = d.getDayOfWeek();
		System.out.println(  dof   );  // FRIDAY
		// Date   0(일) ~ 6(토)
		// Calendar   1(일) ~ 7(토)
		// LocalDate    1(월)~ 7(일)      ISO 표준
		System.out.println(  dof.getValue()   );  // 1(월) 2(화)  ~ 7(일)
		
		// 5:06 쉬는 시간 +  ~ (상담)~ 복습  5:48  퇴실 체크 
		
		
		// LocalTime t;

	} // main

} // class








