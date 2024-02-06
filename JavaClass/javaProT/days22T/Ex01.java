package days22;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * @author ♈ kenik
 * @date 2023. 2. 24. - 오전 5:28:51
 * @subject
 * @content
 *
 */
public class Ex01 {

	public static void main(String[] args) {		
		
		// [달력]
		// 1.  2010.5                 1일 무슨 요일
		// 2.                              마지막 날짜                     X
		// 4월(이전)+ 5월+6월(이후) 함께 출력...
		int year = 2023;
		int month = 2;
		
		Calendar c = new GregorianCalendar( year, month - 1,  1 ); // 2023.2.1
		
		// [요일] 을 나타내는 코딩인데  // 1(일) 2(월) 3(화) [ 4(수) ] 5(목) 6(금) 7(토)
		int dayOfWeek = c.get( Calendar.DAY_OF_WEEK ); // 4
		
		// 1) Calendar 클래스의 add() 메서드 알고 있나요 ? 
		//   (1) 기능                   :   날짜   + 년/월/일/시/분/초 필드         +    덧셈/뺄쎔하는  새로운 날짜 메서드 
		//   (2) 매개변수           :   필드 년/월/일/시/분/초 ,  수량
		//   (3) 리턴자료형(리턴값)  : void
		//        2023.2.1                   -4                    2023.1.28 
		 c.add(   Calendar.DATE  , -dayOfWeek  );
		 // add() / set() / roll () 차이점 이해.~
		 
		 System.out.println( "-".repeat(24) );
		 //   chars() ,  mapToObj(),  forEach() 
		 // [ 람다와 스트림 ]
		 "일월화수목금토".chars().mapToObj(ch -> (char)ch).forEach(System.out::println);
		 
		 System.out.println( "-".repeat(24) );
		 
		 for (int i = 1; i <= 42; i++) {
			 c.add(   Calendar.DATE  , 1 );
			 //Date d = new Date(  c.getTimeInMillis() );
			 //System.out.println(   d.toLocaleString() ); //
			 
			 int oMonth = c.get(Calendar.MONTH) + 1;
			 
			 // if( oMonth == month  )   System.out.printf("%d\t",  c.get( Calendar.DATE ) );
			 //else   									System.out.printf("(%d)\t",  c.get( Calendar.DATE ) );
			 
			 System.out.printf(oMonth == month ? "%d\t" : "(%d)\t",  c.get( Calendar.DATE ) );
				 
			
			 if(   i % 7 ==0  ) System.out.println();
			 
		}
		 System.out.println( "-".repeat(24) );
		
		 //[시험] Calendar -> Date 타입으로 형변환		 
		 // 오늘 날짜는   [24]로 출력하고 싶다.
		 /*
		 (29)	(30)	(31)	1	2	3	4	
		 5	6	7	8	9	10	11	
		 12	13	14	15	16	17	18	
		 19	20	21	22	23	[24]	25	
		 26	27	28	(1)	(2)	(3)	(4)	
		 (5)	(6)	(7)	(8)	(9)	(10)	(11)
		 */	
	 
		 /*
		 시작날짜 세팅하는 
		 c.add(Calendar.DATE ,- dayOfWeek)
		 이 코딩이 이해가 안가서 다시 설명 가능한가요?
		 */
		
	} // main
	

} // class
 








