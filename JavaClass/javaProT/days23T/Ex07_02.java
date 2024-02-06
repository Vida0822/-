package days23;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;

/**
 * @author ♈ kenik
 * @date 2023. 2. 27. - 오전 11:47:03
 * @subject   Period, Duration 
 * @content  날짜 -날짜,   시간-시간   간격
 *
 */
public class Ex07_02 {

	public static void main(String[] args) {
		LocalDate d1 = LocalDate.of(2014, 1,1);
		LocalDate d2 = LocalDate.of(2015, 12,31);
		
		Period p = Period.between(d1, d2); // d1 포함O, d2 포함X
		System.out.println( d1 );  // 2014-01-01
		System.out.println( d2 ); // 2015-12-31
		System.out.println( p );   // P-  1Y - 11M  - 30D
		
		// toTotalMonths()    일은 무시하고  년과 월을       월단위로 변환해서 반환하는 메서드 
		System.out.println(     p.toTotalMonths()  );  // 총 23개월
		
		// 12:03 수업 시작~~~
		// 오늘 아침에 수업 시작한지 지금 몇 초가 지났나? 
		LocalTime  s = LocalTime.of(9, 0);
		LocalTime  t = LocalTime.now();
		Duration d = Duration.between(s, t);
		System.out.println( d );  // PT-3H-7M-10.8405441S
		// d.getNano();		d.getSeconds();
		System.out.println(  d.toHours() );    // 3h
		System.out.println(  d.toMinutes() ); // 187m =  3*60 + 5
		System.out.println(  d.toSeconds() ); //  11277s
		
		
	   

	}

}










