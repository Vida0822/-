package days23;

import java.time.LocalTime;
import java.time.temporal.ChronoField;

/**
 * @author dlsgu
 * @date 2023. 2. 27. 오전 10:31:51
 * @subject
 * @content
 */
public class Ex04 {

	public static void main(String[] args) {
		LocalTime t = LocalTime.now();
		System.out.println(t); // 10:32:48.938045100
		
		// 시간
		System.out.println(t.getHour());
		// 분
		System.out.println(t.getMinute());
		// 초
		System.out.println(t.getSecond());
		// 밀리초
		System.out.println(t.get(ChronoField.MILLI_OF_SECOND));
		// 나노초
		System.out.println(t.getNano());
		
		// 10분 후
		t = t.plusMinutes(10);
		System.out.println(t);

	}//main

}//class
