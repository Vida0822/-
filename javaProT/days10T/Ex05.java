package days10;

import java.util.Date;
import java.util.Scanner;

/**
 * @author kenik
 * @date  2023. 2. 8. - 오후 12:40:49
 * @subject 
 * @content 
 *
 */
public class Ex05 {

	public static void main(String[] args) {
		// 주민등록번호를 입력받아서.....
		Scanner scanner = new Scanner(System.in);  //    830412-1700001
		String rrn = Ex02.getRRN(scanner); 
		System.out.println("> RRN : " + rrn);
		// 1. 생년월일     "1983-04-12"		
		// System.out.println(  getBirth(rrn) );
		
		// 2. 성별 - 함수(메서드) 선언   1. 기능 2. 매개변수  3. 리턴값
		// System.out.println(   getGender(rrn) ? "남자" : "여자"  );

		// 3. 나이 계산
		/*
		 *  세는 나이 CountingAge - 태어나자마자 1살을 먹고, 새해 1월1일이 되면 1살이 먹는다. 
		 *  만 나이    AmericanAge - 태어나는 일을 기준으로 1년이 지나야지 1살을 먹는다. 
		 *                                
		 *                                   2019.12.31    2020.1.1    2020.12.30    2021.1.1
		 *  예)  A사람     만나이      0살                0살           1살                1살
		 *    2019.12.30  세나이      1살                  2살          2살               3살
		 *    
		 *    세는 나이 =  2020(현재년도) - 2019(생일년도) +1
		 *    만 나이  =  2020(현재년도) - 2019(생일년도)    ( 생일지났지 않았을 경우 -1)       
		 * */
		int countingAge = getCountingAge( rrn  );
		System.out.println( "> 세는 나이 : " +  countingAge  );  // 세는 나이.
		
		int americanAge = getAmericanAge( rrn  );
		System.out.println( "> 만 나이 : " +  americanAge  );  //만 나이.
		// 4. 출생지역
		// 5. 검증

	} // main
	
	// 3:02 수업 시작~~  ( 시험)  함수 선언하세요.. 
	private static int getAmericanAge(String rrn) {
		// 만 나이  =  2020(현재년도) - 2019(생일년도)    ( 생일지났지 않았을 경우 -1)       
		int americanAge;
		Date  d = new Date(); 
		int nowYear = d.getYear() + 1900;  // 2023
		int birthYear =   Integer.parseInt(   getBirth(rrn).substring(0, 4)   );
		
		americanAge = nowYear - birthYear;
		
		// 년도 X
		// 현재월 현재일              생일월  생일일
		// 현재월 < 생일월                                           생일이 지난것.
		// 현재월 == 생일월      &&  현재일 >= 생일일  생일이 지난것
		// 그외 생일지나지않는 경우.
		
	
		int nowMonth =   2 ;  // d.getMonth() + 1;  // 1월(0)~12월(11)              2
		int birthMonth =  Integer.parseInt( getBirth(rrn).substring(5, 7)  ) ;   //  "1983-01-23"
		int nowDay =  8;        // d.getDate();  // 8
		int birthDay =  Integer.parseInt( getBirth(rrn).substring(8)  ) ; 
		//현재월  < 생일월    ||     ( 현재월 == 생일월  &&  현재일  <  생일일)
		//      2          3
		/*
		if(   (nowMonth < birthMonth) ||   ( nowMonth == birthMonth  &&  nowDay  <  birthDay)) {
			americanAge--;
		}
		*/
		
		int nowMD =  nowMonth * 100 +nowDay ; //   208;
      	//  "1983-01-  23"           "01-23"          "0123"
		int birthMD=  Integer.parseInt(  getBirth(rrn).substring(5).replaceAll("-", "") );   // 123
		if(  nowMD  < birthMD)  americanAge--;
		
		return americanAge;
	}

	private static int getCountingAge(String rrn) {
		// 현재년도 
		Date  d = new Date();
		// The method getYear() from the type Date is deprecated
		int nowYear = d.getYear() + 1900;
		// System.out.println("> nowYear : " + nowYear); // 2023           123
		//                               "1983-04-12"   -> "1983"  -> 1983
		int birthYear =   Integer.parseInt(   getBirth(rrn).substring(0, 4)   );
		
		int CountingAge = nowYear - birthYear + 1;
		
		return CountingAge;
	}

	// "1983-04-12"
    public static String getBirth( String rrn ) {
    	// 83 04 12-1700001
    	// 문제) 18/19/20 + 83
    	// 성별 - 1,2,5,6   1900
    	//            3,4,7,8  2000
    	//             0,9       1800
    	String year = rrn.substring(0, 2);     // "83"
    	String month = rrn.substring(2, 4);  // "04"
    	String day = rrn.substring(4, 6);       // "12"
    	
    	String gender = rrn.substring(7,8);  // "1"
    	switch(  Integer.parseInt(gender)  ) {
	    	case 1: case 2: case 5: case 6:  // 1900 
	    		year = "19"+year;
	    		break;
	    	case 3: case 4: case 7: case 8:  // 2000
	    		year = "20"+year;
	    		break;
	    	case 0: case 9:   // 1800
	    		year = "18"+year;
	    		break;
    	}
    	return String.format("%s-%s-%s", year, month, day);
    }
	

	// 2:00 수업 시작~ 
	// [문제] 성별 반환하는 함수 선언.. 
	// 함수 ? 프로그램 + 반복적인 코딩 묶어서 + 함수 처리 + 구조화 + [재사용], 팀작업,
	//            drawLine(), drawLine(int n), drawLine( int n , char style) 오버로딩 == 중복함수
    /*
	public static boolean getGender(  String rrn ){
		String check = rrn.substring(7,8); //  "1"
		if(Integer.parseInt(check) % 2 != 0) return true; // 남자
		else                                                       return false;  // 여자
	}
	*/
    public static boolean getGender(  String rrn ){
    	// "980101-1000001"
		char gender = rrn.charAt(7);  // '1'
		//  '1' == 49 % 2 != 0
		//    '1' - 48 -> 1  변환            ( 주의할 사항. )
		//   char   int 변환
		if( (gender- 48 )% 2 != 0) return true; // 남자
		else                           return false;  // 여자
	}

} // class






