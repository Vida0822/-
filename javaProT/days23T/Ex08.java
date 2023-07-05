package days23;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author ♈ kenik
 * @date 2023. 2. 27. - 오후 12:09:14
 * @subject   java.time 패키지    핵심(날짜,시간) 클래스
 * @content   문자열 -> 파싱,       포맷(format)
 *                       DateTimeFormatter 형식화 클래스 
 *
 */
public class Ex08 {

	public static void main(String[] args) {
	    LocalDateTime dt = LocalDateTime.now();
	    System.out.println( dt );  // 2023-02-27T12:11:50.727573900
	    
	    // 출력 형식
	    // 2023/02/27 월요일   12:11:50
	    // DateTimeFormatter dtf = new  객체 생성 X
	    // e(1,2,3,) E(월,화)
	    String pattern = "yyyy/MM/dd E요일   hh:mm:ss.SSS";
	    DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);
	    String 날짜형식 = dtf.format(dt);
	    System.out.println( 날짜형식 );  // 2023/02/27 월요일   12:17:57.3

	}

}










