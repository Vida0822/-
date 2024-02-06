 package days22;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author dlsgu
 * @date 2023. 2. 24. 오전 11:29:14
 * @subject
 * @content
 */
public class Ex01_06 {

	public static void main(String[] args) {
		// [달력]
		// 1. 2010.5	1일 무슨 요일
		// 2.			마지막 날짜		X
		// 4월(이전)+5월+6월(이후) 함께 출력
		int year = 2023;
		int month = 2;
		
		Calendar t = new GregorianCalendar();
		Calendar c = new GregorianCalendar(year, month-1, 1); // 2023.2.1
		int dayOfWeek = c.get(Calendar.DAY_OF_WEEK); // 1(일) ~ 7(토)
		
		c.add(Calendar.DATE,-dayOfWeek);
		
		System.out.println("-".repeat(52));
		// "일월화수목금토".
		String y = "일월화수목금토";
		for (int i = 0; i < 7; i++) {
			System.out.printf("%s\t", y.charAt(i));
		}
		System.out.println();
		System.out.println("-".repeat(52));
		
		for (int i = 1; i <= 42; i++) {
			c.add(Calendar.DATE, 1);
			// Date d = new Date(c.getTimeInMillis());
			// System.out.println(d.toLocaleString());
			
			int oMonth = c.get(Calendar.MONTH) + 1;
			
			// if (oMonth == month) System.out.printf("%d\t", c.get(Calendar.DATE));
			// else System.out.printf("(%d)\t", c.get(Calendar.DATE));
			if (oMonth == month && t.get(Calendar.DATE) == c.get(Calendar.DATE)) System.out.printf("[%d]\t", c.get(Calendar.DATE));
			else System.out.printf(oMonth == month ? "%d\t" : "(%d)\t", c.get(Calendar.DATE));
			
			if (i%7==0) System.out.println();
		}
		System.out.println("-".repeat(52));
		
		// [시험] Calendar -> Date 타입으로 형변환
		

	}//main

}//class
