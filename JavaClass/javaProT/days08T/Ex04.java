package days08;

import java.util.Scanner;

/**
 * @author kenik
 * @date 2023. 2. 6. - 오후 3:50:23
 * @subject     함수 선언 연습 -> 함수 호출 사용
 * @content    4:01 수업 시작~ 
 *
 */
public class Ex04 {

	public static void main(String[] args) {
		// 년도를 입력받아서 윤년/평년을 체크해서 출력.
		/*
		 * 1. 년도 입력받아서 반환하는 함수 
		 * 2. 윤년(leap year) ,  평년 ? 이해
		 *     년도를 매개변수 윤년/평년을 반환하는 함수 
		 *     
		 *     
		 *     윤년 :  오차를 보정하기 위해 삽입하는 날, 주, 달이 들어가는 해(년도)를 말한다. 
		 *     치윤법(置閏法) :    삽입하는 달을 정하는 방법 
		 *     왜 ? 오차가 생기고 -> 치윤법(오차보정)
		 *     
		 *     윤년 : 한국력 = 그레고리력   ? 현 인류 사회에서 가장 널리 쓰이기에   (  윤년=2월 29일 )이 있는 해
		 *     2월 28일 X -> 29일까지 있는 해를 윤년.
		 *     
		 *     [ 그레고리력 ] - 오차 보정  2/29 이해.
		 *     
		 *     지구 자전주기와 공전주기 맞지 않다. ( 자연현상 )
		 *     공전주기 (1년) 365.2422일   0.25일
		 *     공전주기 (1년) 365.2422일
		 *     공전주기 (1년) 365.2422일
		 *     공전주기 (1년) 365.2422일   4년  1하루 오차 발생 +  4년마다 2월 29일로 처리하는 달력 ( 율리우스력 )
		 *     
		 *     1년 365.2425일   [ 오차  0.003일 ] 보정                  //    3333년 하루 오차
		 *      설명)   400년  97번의 윤년이 발생한다.                       2월 29일
		 *      400년 동안 4의 배수   년도        100번 => 윤년                    + 3년
		 *                        100의 배수 년도        4번     =>   평년                                   1년
		 *                        400의 배수 년도        1번    => 윤년 
		 *      [치윤법]
		 *      ① 서력 기원 연수가 4로 나누어 떨어지는 해는 우선 윤년으로 하고, 
		 *      ② 그 중에서 100으로 나누어 떨어지는 해는 평년으로 하며, 	
		 *      ③ 다만 400으로 나누어 떨어지는 해는 다시 윤년으로 정하였다
		 *      
		 *     
		 *      한국 :  1896년 부터 태양력(그레고리오력) 을 사용하고 있다. 
		 *     
		 *  3. 출력   
		 * */

		int year = getYear();
		
		// 함수 
		// 1. 기능 : 윤년, 평년인지 체크해주는 함수           isLeapYear()
		// 2. 매개변수 :  체크할 년도   int year
		// 3. 리턴값 :   윤년(true), 평년(false)     리턴자료형 : boolean   
		/*
		boolean cheack = isLeapYear(year);

		if( cheack) {
			System.out.println("윤년(leap year)");
		}else {
			System.out.println("평년(common year)");	
		}
		*/
		
		if(   isLeapYear(year)   )  {
			System.out.println("윤년(leap year)");
		}else {
			System.out.println("평년(common year)");	
		}

	}  // main
	 
	// 윤년(true), 평년(false) 
	public  static boolean isLeapYear(int year) {
		// *      [치윤법]
		//		 *      ① 서력 기원 연수가 4로 나누어 떨어지는 해는 우선 윤년으로 하고,          year % 4 ==0
		//		 *      ② 그 중에서 100으로 나누어 떨어지는 해는 평년으로 하며, 	                  year % 100 == 0
		//		 *      ③ 다만 400으로 나누어 떨어지는 해는 다시 윤년으로 정하였다              year % 400 == 0
		// return year % 4 ==0;  // 율리우스력
		//  우선 순위 :            &&   >    ||      ( 암기 )
		return year % 4 ==0  && year % 100 != 0  ||  year % 400 == 0 ; // 그레고리오력
	}

	public static int getYear() {
		Scanner scanner = new Scanner(System.in);

		String year ;
		String yearRegex = "\\d+";  //정수 1자리 이상~  

		do {
			System.out.print( " 년도를 입력 ? ");
			year = scanner.next();
		} while ( !year.matches(yearRegex) );

		return Integer.parseInt( year );
	} // getYear

}  // class




