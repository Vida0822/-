package days23;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author ♈ kenik
 * @date 2023. 2. 27. - 오후 12:19:28
 * @subject  SimpleDateFormatter 클래스 - format(), parse()
 * @content   DateTimeFormatter 형식화 클래스 
 *
 */
public class Ex08_02 {

	public static void main(String[] args) {
		String s = "2022년 12월 25일 (일)";		
		// String s = "2022-12-25";    // ISO_LOCAL_DATE 형식
		
		// 위의 문자열 s -> LocalDate 타입으로 변환.
		// LocalDate d =  LocalDate.parse(s);
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 (E)");
		LocalDate d =  LocalDate.parse(s, formatter);
		System.out.println( d );  // 2022-12-25
		
		// 위의 문자열 s -> LocalDateTime 타입으로 변환.
		//LocalDateTime dt = LocalDateTime.parse(s);
		//System.out.println( dt );

	} // main

} // class
