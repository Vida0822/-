package days22;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author ♈ kenik
 * @date 2023. 2. 24. - 오후 2:33:53
 * @subject
 * @content
 *
 */
public class Ex04_02 {

	public static void main(String[] args) {
		
		Calendar c = Calendar.getInstance();	
		
		//   "yyyy년 MM월 dd일"  날짜 출력 형식.
		String pattern = "yyyy년 MM월 dd일";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);		
		// Calendar c <-> Date d  타입 변환 ? 
		Date d = new Date(c.getTimeInMillis());
		System.out.println( sdf.format( d ) );

	}

}





