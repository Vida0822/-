package days22;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author dlsgu
 * @date 2023. 2. 24. 오후 12:53:38
 * @subject SimpleDateFormat *****
 * @content	- Date, Calendar 내가 원하는 날짜 형식으로 출력하는 형식화 클래스
 * 			- 패턴 기호
 * 			G 연대(AD/BC)
 * 			y 년도
 * 			M 월
 * 			w 년 중에 주차(1~53)
 * 			W 월 중에 주차(1~5)
 * 			D 년 중에 일(1~366)
 * 			d 월 중에 일(1~31)
 * 			F 요일(?)
 * 			E 요일(월~일)
 * 			a AM/PM 오전/오후
 * 			H 시간 0~23
 * 			k 시간 1~24
 * 			K 시간 0~11
 * 			h 시간 1~12
 * 			m 분
 * 			s 초
 * 			S 밀리초
 * 			z 타임존(시간대)
 * 			Z 타임존(?)
 * 			' escape 문자
 */
public class Ex04 {

	public static void main(String[] args) {
		Date t = new Date();
		
		// [문제] '23년 2월 24일 "금요일"
		String pattern = "''yy년 M월 dd일 \"E요일\"";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		String strDate = sdf.format(t);
		System.out.println(strDate);
		
		/*
		System.out.println(t);
		System.out.println(t.toGMTString());
		System.out.println(t.toLocaleString()); // 2023. 2. 24. 오후 2:17:39
		
		// 년도-월-일 시간:분:초:밀리초 요일
		String pattern = "yyyy-MM-dd a HH:mm:ss.SSS E요일";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		String strDate = sdf.format(t);
		System.out.println(strDate);
		*/

	}//main

}//class
