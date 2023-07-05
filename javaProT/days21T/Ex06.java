package days21;

import java.util.Date;

/**
 * @author ♈ k§nik
 * @date 2023. 2. 23. - 오후 3:19:24
 * @subject 
 * @content 
 */
public class Ex06 {

	public static void main(String[] args) {
		// [문제]
		// 주민등록번호     앞자리 6자리   "890211-1" // 1900년대
		// 생일 지났는지/ 지나지 않았는지 여부를 체크 하는 코딩... ...
		/*
		 *  본인 코딩.. 주석 처리
		 */
		// 생일의     년도 X,         월,일
		// 오늘날짜   년도X           월,일
		// 4:03 수업 시작~~~ 
		String  rrn  = "890211-1";
		
		Date d = new Date();    // 2023. 2. 23.           오후 3:39:23
		d.setHours(0);
		d.setMinutes(0);
		d.setSeconds(0);	 
		
		System.out.println( "오늘 날짜 : " +  d.toLocaleString() ); 
		System.out.println( "오늘 날짜 : " +  d.getTime() );   // long
		
		Date b_day = new Date(2023-1900, 2-1, 23) ;   // 00:00:00
		//System.out.println( b_day);
		System.out.println( "생일 날짜 : " +  b_day.toLocaleString() ); 
		System.out.println( "생일 날짜 : " +  b_day.getTime() );   // long
		
		// 밀리세컨드 : 0 설정.  X  
		
		
		System.out.println(   d.after(b_day)  );
		System.out.println(   d.before(b_day)  );
		System.out.println(   d.equals(b_day)  );
		
		/*
		 * 
		d.after(b_day); // true, false   이것이 참이면 생일 지난것
		d.before(b_day); // 생일이 지나지 않은 것
		d.equals(b_day);  //  오늘 생일
		*/
		
		
		/* 두 번째
		int b_md = Integer.parseInt(    rrn.substring(2, 6)    );  // 211
		
		Date d = new Date();
		int t_month = d.getMonth() + 1;
		int t_date =  d.getDate(); 
		int t_md = t_month * 100 + t_date;                                   // 223
		*/
		
		/* 첫 번째.
		int b_month = Integer.parseInt(    rrn.substring(2, 4)    );  // 2
		int b_date = Integer.parseInt(    rrn.substring(4, 6)    );     // 11
		
		Date d = new Date();
		int t_month = d.getMonth() + 1;
		int t_date =  d.getDate(); 
		
		// b_month == t_month  && b_date == t_date   오늘이 생일날.
		// b_month  <= t_month  && b_date > t_date     생일 지난것.
		// 그 외는                                                                   생일 안 지난 것.
		 * */

	}  // main

} // class











