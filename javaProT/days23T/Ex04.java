package days23;

import java.time.LocalTime;
import java.time.temporal.ChronoField;

/**
 * @author ♈ kenik
 * @date 2023. 2. 27. - 오전 10:31:51
 * @subject
 * @content
 *
 */
public class Ex04 {

	public static void main(String[] args) {
		LocalTime t = LocalTime.now();
		System.out.println(  t );   // 10:32:32.778304100
		
		// 시간
		System.out.println( t.getHour() ); 
		// 분
		System.out.println( t.getMinute() ); 
		// 초
		System.out.println( t.getSecond() ); 
		// 밀리초
		System.out.println( t.get( ChronoField.MILLI_OF_SECOND )  );
		// 나노초
		System.out.println( t.get( ChronoField.NANO_OF_SECOND )  ); 
		// t.getNano();
		
		// 1시간 10분 후에 만나요... 
		t = t.plusHours(1);
		t = t.plusMinutes(10);
		System.out.println( t );

	}  // main

} // class












