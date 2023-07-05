package days23;

import static java.time.DayOfWeek.*;
import static java.time.temporal.TemporalAdjusters.*;

import java.time.LocalDate;

/**
 * @author ♈ kenik
 * @date 2023. 2. 27. - 오전 10:53:05
 * @subject    [ TemporalAdjusters 클래스 ]
 * @content   11:05 수업 시작
 *                        시간상의  + 조정자(기)
 *                        날짜,시간을 변경하는 메서드 : plus(), minus(), with()
 *                        자주 사용되는 날짜,시간  계산(변경)하는 메서드를 미리 구현해 놓은 클래스 
 *                        예) 다음 주 금요일 만나 ? 
 *                                오늘 (월) + 1주일 (다음(월))+화/수/목/금
 *
 */
public class Ex06_02 {

	public static void main(String[] args) {
		
		LocalDate d = LocalDate.now();
		System.out.println( d );  // 2023-02-27
		// 다음달 첫날 : TemporalAdjusters.firstDayOfNextMonth()    2023-03-01
		System.out.println(   d.with(   firstDayOfNextMonth()  ) );		
		// 이번 달 첫날 :  2023-02-01
		System.out.println(   d.with(   firstDayOfMonth()  ) );
		// 올해의 첫 날 : 2023-01-01
		System.out.println(   d.with(   firstDayOfYear() ) );
		// 내년의 첫날 : 2024-01-01
		System.out.println(   d.with(   firstDayOfNextYear() ) );
		
		// 이번 달의 첫 번째 월요일 ?  2023-02-06
		System.out.println(   d.with(   firstInMonth( MONDAY ) ) );
		// 이번 달 마지막 토요일 날 만나..( 약속 ) : 2023-02-25
		System.out.println(   d.with(   lastInMonth( SATURDAY ) ) );
		
		// 다음달의 금요일 휴강... : 2023-03-03
		System.out.println(   d.with(   next(FRIDAY) ) );
		
		// 이번 달의 3번째 토요일 만나 : 2023-02-18
		System.out.println(   d.with(   dayOfWeekInMonth(3, SATURDAY)  ) );
		
		// 지난 화요일 몇 일이니? 
		System.out.println(   d.with(   previous( SATURDAY)  ) ); // 오늘 포함X
		System.out.println(   d.with(   previousOrSame( SATURDAY)  ) );  // 오늘 포함

		// 3일 뒤에 만나..
		// d = d.plusDays(3);
		d =  d.with( new DayAfter3일() );
		System.out.println( d );  // 2023-03-02
	} // main

} // class

 






