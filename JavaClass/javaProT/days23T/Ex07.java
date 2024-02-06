package days23;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

/**
 * @author ♈ kenik
 * @date 2023. 2. 27. - 오전 11:27:37
 * @subject
 * @content
 *
 */
public class Ex07 {

	public static void main(String[] args) {
		// 개강일
		LocalDate o = LocalDate.of(2023, 1, 26);
		// 오늘일
		LocalDate t = LocalDate.now(); // .plusDays(1);
		
		// 날짜 - 날짜 간격(차)
		Period   p = Period.between(o, t); // o 포함O,   t 포함X
		
		// 개강일 - 오늘일 간격
		long year =  p.get( ChronoUnit.YEARS );
		System.out.println(   year );
		long month =  p.get( ChronoUnit.MONTHS );
		System.out.println(   month );
		long day =  p.get( ChronoUnit.DAYS );
		System.out.println(   day );
		
		// 개강시간 9:00:00
		// 현재시간
		LocalTime oTime = LocalTime.of(9, 0, 0 );
		LocalTime tTime = LocalTime.now();
		
		// 
		Duration d = Duration.between(oTime, tTime);
		// d  초, 나노초  간격을 얻어올 수 있더라..
		/*
				// long hour = d.get( ChronoUnit.HOURS );  사용할 수 없다.
				long hour = d.get( ChronoUnit.SECONDS ) / ( 60 * 60 );
				System.out.println( hour );
				//long min = d.get( ChronoUnit.MINUTES );사용할 수 없다. 
				//System.out.println( min );
				long sec = d.get( ChronoUnit.SECONDS );
				System.out.println( sec );
		*/
		LocalTime  diff = LocalTime.of(0, 0).plusSeconds(    d.getSeconds()  );
		int hour = diff.getHour();
		int min = diff.getMinute();
		int sec = diff.getSecond();
		int nano = d.getNano();
		
		// Period,  Duration
		// 두 날짜 간격(차) : between() 
		
		// 오늘날짜  :   t ~ 생일날짜 
		LocalDate b = LocalDate.of(2023, 5, 26);
		// Period.between(t, b)
		// Period  p = t.until( b );
		
		// (주의) Duration을 반환하는 until() 메서드는 없다. 
		//          시간 간격
		
		// of() 설정 , with()  수정하는 메서드 존재.
		// plus(), minus() 메서드 존재  +  곱셈, 나눗셈 메서드 존재..
		
	 
		
		
		

	} // main

} // class








