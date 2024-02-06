package days21;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * @author ♈ k§nik
 * @date 2023. 2. 23. - 오후 4:10:18
 * @subject 
 * @content 
 */
public class Ex07 {

	public static void main(String[] args) {
		
		// JDK 1.1 Calendar 추상클래스 - 날짜, 시간 
		// Calendar c = new Calendar();  X
		
		// GregorianCalendar   c = new GregorianCalendar();
		// true/false    c.isLeapYear(2010)
		
		// GregorianCalendar
		// BuddhistCalenader - 태국

		Calendar c = Calendar.getInstance();
		System.out.println(   c  );
		// java.util.GregorianCalendar[time=1677136849149
		// ,areFieldsSet=true
		// ,areAllFieldsSet=true,lenient=true
		// 시간대 ,zone=sun.util.calendar.ZoneInfo[id="Asia/Seoul",offset=32400000,dstSavings=0,useDaylight=false,transitions=30,lastRule=null],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=1,YEAR=2023,MONTH=1,WEEK_OF_YEAR=8,WEEK_OF_MONTH=4,DAY_OF_MONTH=23,DAY_OF_YEAR=54,DAY_OF_WEEK=5,DAY_OF_WEEK_IN_MONTH=4,AM_PM=1,HOUR=4,HOUR_OF_DAY=16,MINUTE=20,SECOND=49,MILLISECOND=149,ZONE_OFFSET=32400000,DST_OFFSET=0]
		
		// 년
		// c.get(int field)   정보를 얻어올 때.. 메서드
		// c.set()   날짜,시간 정보를 설정  메서드
		System.out.println(   c.get( Calendar.YEAR  )  );  // 2023
		// 월
		System.out.println(   c.get( Calendar.MONTH  ) + 1  );  // 1      ( 2월)
		// 일
		System.out.println(   c.get( Calendar.DATE  )  ); 
		System.out.println(   c.get( Calendar.DAY_OF_MONTH  )  ); 
		// 시간
		System.out.println(   c.get( Calendar.HOUR  )  );   // 12시간 ( 0~11 )
		System.out.println(   c.get( Calendar.HOUR_OF_DAY  )  );    // 24시간 ( 0~23 )
		// 분
		System.out.println(   c.get( Calendar.MINUTE  )  ); 
		// 초
		System.out.println(   c.get( Calendar.SECOND  )  ); 
		// 밀리세컨드 
		System.out.println(   c.get( Calendar.MILLISECOND  )  ); 
		// 요일
		// Date 클래스        :   0(일) 1(월)~ 6(토)
		// Calendar 클래스 :   1(일), 2(월)~ 7(토)
		System.out.println(   c.get( Calendar.DAY_OF_WEEK  )  );
		
		System.out.println(   c.get( Calendar.AM )  );           // 오전, 오후    1
		System.out.println(   c.get( Calendar.AM_PM )  );   // 오전, 오후    1
				
		System.out.println(   c.get( Calendar.WEEK_OF_MONTH )  );   // 해당 월의 몇 번째 주
		System.out.println(   c.get( Calendar.WEEK_OF_YEAR      )  );   // 해당 년도의 몇 번째 주
		
		
		// 일
		System.out.println(   c.get( Calendar.DATE  )  ); 
		System.out.println(   c.get( Calendar.DAY_OF_MONTH  )  );  // 해당 월의 몇일째냐? 
		System.out.println(   c.get( Calendar.DAY_OF_YEAR  )  );      // 해당 년도의 몇일째냐? 
		
	} // main

} // class










