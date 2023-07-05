package days22;

import java.time.DayOfWeek;
import java.util.Calendar;

/**
 * @author dlsgu
 * @date 2023. 2. 24. 오전 10:53:06
 * @subject
 * @content
 */
public class Ex01_03 {

	public static void main(String[] args) {

		Calendar t = Calendar.getInstance();
		// Date 클래스 0(일) ~ 6(토)
		// Calendar 클래스 1(일) ~ 7(토)
		int dayOfWeek = t.get(Calendar.DAY_OF_WEEK);
		System.out.printf("오늘은 \"%c요일\"입니다.\n", "_일월화수목금토".charAt(dayOfWeek));

	}//main

}//class
