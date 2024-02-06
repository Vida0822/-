package days23;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

/**
 * @author dlsgu
 * @date 2023. 2. 27. 오전 10:53:18
 * @subject [TemporalAdjusters 클래스]
 * @content 시간상의 + 조정자(기)
 * 			날짜, 시간을 변경하는 메서드 : plus(), minus(), with()
 * 			자주 사용되는 날짜, 시간 계산(변경)하는 메서드를 미리 구현해 놓은 클래스
 * 			예) 다음주 금요일
 * 				오늘(월) + 1주일(다음(월))+화/수/목/금
 */
public class Ex06 {

	public static void main(String[] args) {
		
		LocalDate d = LocalDate.now();
		System.out.println(d); // 2023-02-27
		
		// 다음달 첫날 : TemporalAdjusters.firstDayOfNextMonth()
		System.out.println(d.with(TemporalAdjusters.firstDayOfNextMonth())); // 2023-03-01
		
		// 이번달 첫날 : TemporalAdjusters.firstDayOfMonth()
		System.out.println(d.with(TemporalAdjusters.firstDayOfMonth())); // 2023-02-01
		
		// 올해의 첫날 : TemporalAdjusters.firstDayOfYear()
		System.out.println(d.with(TemporalAdjusters.firstDayOfYear())); // 2023-01-01
		
		// 내년의 첫날 : TemporalAdjusters.firstDayOfNextYear()
		System.out.println(d.with(TemporalAdjusters.firstDayOfNextYear())); // 2024-01-01
		
		// 이번 달의 첫번째 월요일 : TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY)
		System.out.println(d.with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY))); // 2023-02-06
		
		// 이번 달의 마지막 토요일 : TemporalAdjusters.lastInMonth(DayOfWeek.SATURDAY)
		System.out.println(d.with(TemporalAdjusters.lastInMonth(DayOfWeek.SATURDAY))); // 2023-02-25
		
		// 다음 달의 금요일 : TemporalAdjusters.next(DayOfWeek.FRIDAY)
		System.out.println(d.with(TemporalAdjusters.next(DayOfWeek.FRIDAY))); // 2023-03-03
		
		// 이번 달의 3번째 토요일 : TemporalAdjusters.dayOfWeekInMonth(3, DayOfWeek.SATURDAY)
		System.out.println(d.with(TemporalAdjusters.dayOfWeekInMonth(3, DayOfWeek.SATURDAY))); // 2023-02-18
		
		// 지난 화요일 : TemporalAdjusters.previous(DayOfWeek.TUESDAY) preciousOrSame
		System.out.println(d.with(TemporalAdjusters.previous(DayOfWeek.TUESDAY))); // 오늘 포함 X 2023-02-21
		System.out.println(d.with(TemporalAdjusters.previousOrSame(DayOfWeek.TUESDAY))); // 오늘 포함 O 2023-02-21
		
		// 3일 뒤에 만나
		// d = d.plusDays(3);
		d = d.with(new DayAfter3일());
		System.out.println(d); // 2023-03-02
		
	}//main

}//class

class DayAfter3일 implements TemporalAdjuster {

	@Override
	public Temporal adjustInto(Temporal temporal) {
		
		return temporal.plus(3, ChronoUnit.DAYS);
	}
	
}
