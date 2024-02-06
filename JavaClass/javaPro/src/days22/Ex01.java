package days22;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * @author dlsgu
 * @date 2023. 2. 24. 오전 9:06:41
 * @subject
 * @content
 */
public class Ex01 {

	public static void main(String[] args) {
		int year, lastDay;
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("> 년도 입력 ? ");
			year = scanner.nextInt();
			System.out.printf("%d년\n\n", year);
			
			Calendar c = new GregorianCalendar(year, 1-1, 1); // 2005.1.1
			
			for (int i = 1; i <= 12; i++) {
				// 캘린더의 월을 i 값으로 수정
				c.set(Calendar.MONTH, i-1);
				lastDay = c.getActualMaximum(Calendar.DATE);
				System.out.printf("%d월 : %d일\n", i, lastDay);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}//main

}//class
