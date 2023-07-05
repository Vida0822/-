package days23;

import java.time.LocalDate;
import java.time.temporal.ChronoField;

/**
 * @author dlsgu
 * @date 2023. 2. 27. 오전 10:13:13
 * @subject
 * @content
 */
public class Ex02 {

	public static void main(String[] args) {
		// now(), of()
		// get(), getXXX()
		// plus(), plusXXX(),	minus(), minusXXX(),	with()
		// 날짜와 시간 비교 : isAfter(), isBefore(), isEqual(),		compareTo()
		
		// 생일이 오늘 기준으로 지났는지 여부 체크
		LocalDate t = LocalDate.now();
		System.out.println(t); // 2023-02-27
		// 1998.2.26
		// LocalDate b = LocalDate.of(1998, 2, 26);
		// b = b.withYear(t.getYear());
		// b = b.with(ChronoField.YEAR, t.getYear());
		LocalDate b = LocalDate.of(t.getYear(), 2, 26);
		System.out.println(b.isAfter(t));
		System.out.println(b.isBefore(t)); // true
		System.out.println(b.isEqual(t));
		
		System.out.println(b.compareTo(t)); // -1

	}//main

}//class
