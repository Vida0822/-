package days22;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * @author dlsgu
 * @date 2023. 2. 24. 오전 10:56:52
 * @subject
 * @content
 */
public class Ex01_04 {

	public static void main(String[] args) {
		Calendar s = new GregorianCalendar(2023, 1-1, 26, 9, 0, 0);
		Calendar t = Calendar.getInstance(); // h,m,s,ms
		
		long sTime = s.getTimeInMillis();
		long tTime = t.getTimeInMillis();
		
		long gab = tTime - sTime; // 개강일~오늘(현재) 흐른 ms
		/*
		System.out.println(gab);
		System.out.println(gab/1000+"초");
		System.out.println(gab/(60*1000)+"분");
		System.out.println(gab/(60*60*1000)+"시간");
		System.out.println(gab/(24*60*60*1000)+"일");
		*/
		// [문제] 29일 ??시 ??분 ??초 ??밀리세컨드
		/*
		System.out.println(gab/(24*60*60*1000)+"일 "
							+ gab%(24*60*60*1000)/(60*60*1000)+"시간 "
							+ gab%(60*60*1000)/(60*1000)+"분 "
							+ gab%(60*1000)/1000+"초 "
							+ gab%1000+"밀리세컨드");
		*/
		/*
		System.out.println(gab/(24*60*60*1000)+"일");
		gab = gab%(24*60*60*1000);
		System.out.println(gab/(60*60*1000)+"시간");
		gab = gab%(60*60*1000);
		System.out.println(gab/(60*1000)+"분");
		gab = gab%(60*1000);
		System.out.println(gab/(1000)+"초");
		gab = gab%(1000);
		System.out.println(gab/(1)+"밀리세컨드");
		*/
		
		int [] tunit = {
						24*60*60*1000,
						60*60*1000,
						60*1000,
						1000,
						1
					   };
		for (int i = 0; i < tunit.length; i++) {
			System.out.print(gab/tunit[i]+"_");
			gab %= tunit[i];
		}

	}//main

}//class
