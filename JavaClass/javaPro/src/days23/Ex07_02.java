package days23;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;

/**
 * @author dlsgu
 * @date 2023. 2. 27. 오전 11:46:58
 * @subject Period, Duration
 * @content 날짜 - 날짜, 시간 - 시간 간격
 */
public class Ex07_02 {

	public static void main(String[] args) {
		LocalDate d1 = LocalDate.of(2014, 1, 1);
		LocalDate d2 = LocalDate.of(2015, 12, 31);
		
		Period p = Period.between(d1, d2); // d1 포함 O, d2 포함 X
		System.out.println(d1); // 2014-01-01
		System.out.println(d2); // 2015-12-31
		System.out.println(p); // P1Y11M30D
		
		// toTotalMonths() 일은 무시하고 년과 월을 월단위로 변환해서 반환하는 메서드
		System.out.println(p.toTotalMonths()); // 23
		
		// 오늘 아침에 수업 시작한지 몇초가 지났나
		LocalTime s = LocalTime.of(9, 0);
		LocalTime t = LocalTime.now();
		Duration d = Duration.between(s, t);
		System.out.println(d); // PT-3H-5M-58.1662533S
		// d.getNano();		d.getSeconds();
		System.out.println(d.toHours()); // 3
		System.out.println(d.toMinutes()); // 187 = 3*60 + 5
		System.out.println(d.toSeconds()); // 11292

	}//main

}//class
