/**
 * 
 */
package days11;

import java.util.Scanner;

/**
 * @author kenik
 * @date 2023. 2. 9. - 오후 2:36:10
 * @subject ( 시험 1 )  10분
 * @content
 *
 */
public class Ex04 {

	public static void main(String[] args) {
		// [일정관리/근태관리] - 자바 달력, 오라클 SQL, javascript 달력, JSP 달력
		// [년도와 월]을 입력받아서 달력을 출력.
		// 3:05 수업 시작~
		// 1) 1일 무슨 요일 ?
		// 2) 마지막날짜 ? O
		Scanner scanner = new Scanner(System.in);
		int year, month;

		System.out.printf("> year, month input ? ");
		year = scanner.nextInt();
		month = scanner.nextInt();

		/*
		 * for (int i = 1; i <=12; i++) { int lastDay = getLastDay( year, i );
		 * System.out.printf("%d.%d = %d일\n", year, i , lastDay); }
		 */ 
		printCalendar(year, month);
	} // end of main
 
	private static void printCalendar(int year, int month) {
		// (1)
		int lastDay = getLastDay(year, month);
		// (2) 
		int dayOfWeek = getDayOfWeek(year, month, 1); // 0(일), 1(월)~ 6(토)
		System.out.printf("\t\t[%d년 %d월]\n", year, month );
		 // 4:03 수업 시작 [ 달력 출력 ]
	     days08.Ex03_02.drawLine(30, '-');
	     String week = "일월화수목금토";
	     for (int i = 0; i < week.length() ; i++)  System.out.printf("\t%c", week.charAt(i));
		 System.out.println();  // 개행
	     System.out.println(  "-".repeat(30) );
	     // 1 날짜의 위치 - 공백(\t)  출력 for
	     for (int i = 0; i < dayOfWeek; i++) {
			System.out.print("\t");
		}
	     // 1~ 마지막날짜 for
	     for (int i = 1; i <= lastDay; i++) {
	    	 System.out.printf("\t%d", i );
	    	 if( ( i  + dayOfWeek ) % 7 == 0) System.out.println();
		} 
	     System.out.println();  // 개행
	     System.out.println(  "-".repeat(30) );
	}

	private static int getDayOfWeek(int year, int month, int day) {
		// 1.1.1 ~ year.month.day 총날짜수
		int totalDays = getTotalDays(year, month, day);
		//System.out.println( "총 날짜수 : " + totalDays  );
		int dayOfWeek = totalDays % 7;
		//System.out.println(  "일월화수목금토".charAt(dayOfWeek) + "요일" );
		return dayOfWeek; // 0~6 요일에 해당되는 정수 반환하는 함수.
	}

	// 총날짜수를  구합니까? 
	// 1.1.1 ~ year.month.day 총날짜수
	private static int getTotalDays(int year, int month, int day) {
		int totalDays = 0; 
		totalDays = ( year - 1 ) * 365 + ( year - 1 )/4 - ( year - 1 )/100 + ( year - 1 )/400 ;
		int[] months = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };		
		for (int i = 0; i < month - 1; i++)  			totalDays += months[i];
		if( month >= 3 && days08.Ex04.isLeapYear(year) ) totalDays++;
		totalDays += day;		
		return totalDays;
	}
	/*
	private static int getTotalDays(int year, int month, int day) {
		// 2000.12.1 총날짜수
		// (2000-1) * 365 + 1월(31) + 2월(29) + 3월(31) + 4월(30) ... + 11월(30) + 1 (고민)
		int totalDays = 0; // 총날짜수

		for (int i = 1; i < year; i++) {
			if (days08.Ex04.isLeapYear(i))
				totalDays += 366;
			else
				totalDays += 365;
		}
		// 이전년도 까지의 총 날짜수 1999.12.31 까지의 총날짜수 ...

		// month = 1
		totalDays += 1;
		// month =2
		totalDays += 31 + 1;
		// month =3
		totalDays += 31 + 28/29+ 1;
		// month =4
		totalDays += 31 + 28/29+ 31+  1;
		// month =5
		totalDays += 31 + 28/29+ 31+  30+  1;
		// month =6
		totalDays += 31 + 28/29+31+30+31+ 1;
		// month =7
		totalDays += 31 + 28/29+31+30+31+30+ 1;
		// month =8
		totalDays += 31 + 28/29+31+30+31+30+31+ 1;
		// month =9
		totalDays += 31 + 28/29+31+30+31+30+31+31+ 1;
		// month =10
		totalDays += 31 + 28/29+31+30+31+30+31+31+30+ 1;
		// month =11
		totalDays += 31 + 28/29+31+30+31+30+31+31+30+31+ 1;
		// month =12
		totalDays += 31 + 28/29+31+30+31+30+31+31+30+31+30+ 1;

		return totalDays;
	}
	*/

	private static int getLastDay(int year, int month) { // 5
		// [0]=1월달 [11] = 12월달
		int[] months = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		if (month == 2)
			return days08.Ex04.isLeapYear(year) ? 29 : 28;
		return months[month - 1];
	}

	/*
	 * private static int getLastDay(int year, int month) { int lastDay = 0;
	 * 
	 * switch (month) { case 4:case 6:case 9:case 11: lastDay = 30; break; case
	 * 1:case 3:case 5:case 7:case 8: case 12: lastDay = 31; break; case 2: // 윤년
	 * 29, 평년 28 lastDay = days08.Ex04.isLeapYear(year) ? 29 : 28; break; // default
	 * : } return lastDay; }
	 */

} // end of class
