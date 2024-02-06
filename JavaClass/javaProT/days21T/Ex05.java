package days21;

import java.util.Date;

/**
 * @author ♈ k§nik
 * @date 2023. 2. 23. - 오후 2:49:49
 * @subject 
 * @content 
 */
public class Ex05 {

	public static void main(String[] args) {
		// 3:05 수업 시작~~~
		// [ 달력 ] 
		// 1)   2010 년,   5 월의 
		//                                    1일 무슨 요일 ? 
		// 2)                       몇일까지?  28/29/30/31
		//    2010.6.1  날짜 객체  - 1일 = 2010.5.마지막날짜를 가진 객체 => getDate() 일 
		Date d = new Date(2010-1900, 6-1, 1); //  2010.6.1  날짜 객체
	   int date =	d.getDate(); // 1일
	   d.setDate( date - 1 );
	   System.out.println( d.toLocaleString() );  // 2010. 5. 31. 오전 12:00:00
	   System.out.println(  d.getDate()  ); 
		
		
		// 2010.5.1  Date 날짜 객체 생성 + getDay() 메서드 0(일) ~6(토)
		// (1) Date 생성자
		/*
		Date d = new Date( 2010 - 1900 , 5-1, 1);
		System.out.println(    "일월화수목금토".charAt(   d.getDay()   )      );
		*/
		// (2) 년,월,일,시,분,초 설정...   setXXX()
		/*
		Date d = new Date();
		d.setYear(2010 - 1900);
		d.setMonth(5-1);
		d.setDate(1);
		// 시,분,초  설정하지 않아도 무관~~ 
		d.setHours(0);
		d.setMinutes(0);
		d.setSeconds(0);
		System.out.println(  d.toLocaleString()  );
		*/

	} // main

} // class












