package days22;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author dlsgu
 * @date 2023. 2. 24. 오후 2:44:46
 * @subject
 * @content
 */
public class Ex04_03 {

	public static void main(String[] args) {
		String strDate = "2023.02.25(토)"; // -> Date, Calemdar 날짜 클래스로 변환
		
		String pattern = "yyyy.MM.dd(E)";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		// String sdf.format(날짜)
		try {
			Date d = sdf.parse(strDate);
			System.out.println(d.toLocaleString());
			
			// Date -> Calendar 타입 변환 (Calendar 클래스의 setTime(Date) 이용
			Calendar c = new GregorianCalendar();
			c.setTime(d);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		/*
		int year = Integer.parseInt(strDate.substring(0,4));
		int month = Integer.parseInt(strDate.substring(5,7));
		int day = Integer.parseInt(strDate.substring(8,10));
		
		Calendar c = new GregorianCalendar(year, month-1, day);
		Date d = new Date(year-1900, month-1, day);
		*/

	}//main

}//class
