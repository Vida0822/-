package days22;

import java.util.Calendar;
import java.util.Date;

/**
 * @author ♈ kenik
 * @date 2023. 2. 24. - 오후 12:25:16
 * @subject  [시험]
 * @content
 *
 */
public class Ex02 {

	public static void main(String[] args) {
		// 1. Calendar -> Date 형 변환  
		Calendar c = Calendar.getInstance(); 
		Date d = new Date( c.getTimeInMillis() );
		
		// 2. Date -> Calendar 형 변환.                     메서드    Calendar    setTime( Date )
		/*
		Date d = new Date();
		// System.out.println(  d.toLocaleString()  );   // 2023. 2. 24. 오후 12:27:38		
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		*/		
		

	} // main

} // class







