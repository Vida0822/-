package days23;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @author ♈ kenik
 * @date 2023. 2. 27. - 오전 10:49:00
 * @subject
 * @content
 *
 */
public class Ex05_02 {

	public static void main(String[] args) {
		// Ex05.java     LocalDate, LocalTime ->     LocalDateTime      변환
		//                       LocalDateTime           -> LocalDate, LocalTime 변환
		
		LocalDateTime dt = LocalDateTime.of(2023, 2, 27,  10, 50, 20);
		System.out.println(  dt );  // 2023-02-27T10:50:20
		
		LocalDate d =  dt.toLocalDate();
		System.out.println( d );    // 2023-02-27
		
		LocalTime t =  dt.toLocalTime();
		System.out.println( t );    // 10:50:20

	} // main 

} // class













