package days21;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.concurrent.CancellationException;

/**
 * @author dlsgu
 * @date 2023. 2. 23. 오후 4:11:43
 * @subject
 * @content
 */
public class Ex07 {

	public static void main(String[] args) {
		// JDK 1.1 Calendar 추상클래스
		// Calendar c = new Calendar(); X 추상클래스여서 객체 생성 불가
		// Calendar c = Calendar.getInstance(); // 메서드 제한됨
		// Calendar c = new GregorianCalendar();
		// GregorianCalendar c = new GregorianCalendar(); // 메서드 많음
		// true/false c.isLeapYear(2010);
		
		// GregorianCalendar
		// BuddhistCalendar - 태국
		
		Calendar c = Calendar.getInstance();
		System.out.println(c); // java.util.GregorianCalendar[time=1677136854508
		// ,areFieldsSet=true
		// ,areAllFieldsSet=true,lenient=true
		// ,zone=sun.util.calendar.ZoneInfo[id="Asia/Seoul",offset=32400000,dstSavings=0,useDaylight=false,transitions=30,lastRule=null],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=1,YEAR=2023,MONTH=1,WEEK_OF_YEAR=8,WEEK_OF_MONTH=4,DAY_OF_MONTH=23,DAY_OF_YEAR=54,DAY_OF_WEEK=5,DAY_OF_WEEK_IN_MONTH=4,AM_PM=1,HOUR=4,HOUR_OF_DAY=16,MINUTE=20,SECOND=54,MILLISECOND=508,ZONE_OFFSET=32400000,DST_OFFSET=0]

		// 년
		// c.get(int field) 날짜. 시간 정보를 얻어올 때 
		// c.set() 날짜, 시간 정보를 설정할 때
		System.out.println(c.get(Calendar.YEAR)); // == 1 -> 2023(년)
		// 월
		System.out.println(c.get(Calendar.MONTH)); // == 2 -> 1(2월)
		// 일
		System.out.println(c.get(Calendar.DATE)); // == 5 -> 23(일)
		System.out.println(c.get(Calendar.DAY_OF_MONTH)); // == 5 -> 23(일)
		// 시간
		System.out.println(c.get(Calendar.HOUR)); // == 10 -> 4(12시)
		System.out.println(c.get(Calendar.HOUR_OF_DAY)); // == 10 -> 16(24시)
		// 분
		System.out.println(c.get(Calendar.MINUTE)); // == 12 -> 33(분)
		// 초
		System.out.println(c.get(Calendar.SECOND)); // == 13 -> 54(초)
		// 밀리세컨드
		System.out.println(c.get(Calendar.MILLISECOND)); // == 14 -> 14(밀리초)
		// 요일
		// Date 클래스 : 0(일) 1(월) ~ 6(토)
		// Calendar 클래스 : 1(일) 2(월) ~ 7(토)
		System.out.println(c.get(Calendar.DAY_OF_WEEK)); // == 7 -> 5(목요일)
		
		System.out.println(c.get(Calendar.AM)); // == 1 오전(), 오후()
		System.out.println(c.get(Calendar.AM_PM)); // == 1 오전(), 오후()

		System.out.println(c.get(Calendar.WEEK_OF_MONTH)); // == 4 해당 월의 몇 번째 주
		System.out.println(c.get(Calendar.WEEK_OF_YEAR)); // == 8 해당 년도의 몇 번째 주
		
		// 일
		System.out.println(c.get(Calendar.DATE));
		System.out.println(c.get(Calendar.DAY_OF_MONTH)); // 해당 월의 몇 일
		System.out.println(c.get(Calendar.DAY_OF_YEAR)); // 해당 년도의 몇 일
		
	}//main

}//class
