package days21;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * @author ♈ k§nik
 * @date 2023. 2. 23. - 오후 4:47:37
 * @subject 
 * @content 
 */
public class Ex07_02 {

	public static void main(String[] args) {
		// [문제] java.util.Calendar 클래스를 사용해서 2010.5.1  무슨요일 ?   토
		//                                                                             마지막날짜 ?		
		// 4:48 + 10 + 5
		// 5:05 수업 시작( 풀이)
		
		/*
		Calendar c = Calendar.getInstance();  // 현재 시스템의 날짜,시간 정보를 가지는 객체  c 
		// c.get(int field)
		 
		c.set( Calendar.YEAR, 2010 );
		c.set( Calendar.MONTH, 5 -1 );
		c.set( Calendar.DATE, 1 );
		 
		c.set(2010, 5-1, 1);		
		System.out.println(  c.get(Calendar.DAY_OF_WEEK ) ); // 7(토)
		*/
		
	 
	   Calendar c	 = new GregorianCalendar(2010, 5-1, 1);	
	   System.out.println(  c.get(Calendar.DAY_OF_WEEK ) ); // 7(토)
	  
	   // 마지막날짜..
	   // Date   2010.6.1          -1    =>   2010.5.31
		/*
	   Calendar c	 = new GregorianCalendar(2010, 6-1, 1);
	   c.add( Calendar.DATE  , -1);
	   System.out.println(   c.get(Calendar.DATE)   ); // 31
	   */
	   
	   int lastDay = c.getActualMaximum(Calendar.DATE);
	   System.out.println( lastDay);
		
	   

	} // main

} // class








