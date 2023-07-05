package days22;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author ♈ kenik
 * @date 2023. 2. 24. - 오후 2:43:41
 * @subject
 * @content
 *
 */
public class Ex04_03 {

	public static void main(String[] args) {
		String strDate = "2023.02.25(토)";  //                -> Date, [ Calendar ]날짜 클래스 변환
		
		String pattern = "yyyy.MM.dd(E)";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		//  String  sdf.format(날짜)
		try {
			Date d = sdf.parse(strDate);
			System.out.println(  d.toLocaleString() );
			
			// Date -> Calendar 타입 변환.  ( Calendar클래스의 setTime(Date date) 사용 )  
			// 3:06 수업 시작~ 
			Calendar c = Calendar.getInstance();
			c.setTime(d);
			
		} catch (ParseException e) { 
			e.printStackTrace();
		}
		
		/*
		// substring으로 자르고 int로 만들어서 캘린더객체에 넣습니다
		int year =   Integer.parseInt(  strDate.substring(0, 4)  ); // 2023
		int month =   Integer.parseInt(  strDate.substring(5, 7)  ); // 2
		int day =   Integer.parseInt(  strDate.substring(8, 10)  ); // 25
		
		Calendar c  = new GregorianCalendar(year, month-1, day);
		Date d = new Date(year-1900, month-1, day);
		*/

	} // main

} // class











