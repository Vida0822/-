package days22;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author dlsgu
 * @date 2023. 2. 24. 오전 11:24:15
 * @subject
 * @content
 */
public class Ex02 {

	public static void main(String[] args) {
		// 1. Calendar -> Date 형변환	Date d = new Date(c.getTimeInMillis());
		Calendar c = Calendar.getInstance();
		Date d = new Date(c.getTimeInMillis());		
		
		// 2. Date -> Calendar 형변환	Calendar setTime(Date) 메서드
		Date dd = new Date();
		Calendar cc = Calendar.getInstance();
		cc.setTime(dd);

	}//main

}//class
