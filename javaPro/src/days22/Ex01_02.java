package days22;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * @author dlsgu
 * @date 2023. 2. 24. 오전 10:21:56
 * @subject
 * @content
 */
public class Ex01_02 {

	public static void main(String[] args) {
		String rrn = "980224";
		int month = Integer.parseInt(rrn.substring(2,4));
		int day = Integer.parseInt(rrn.substring(4));
		
		Calendar t = Calendar.getInstance();
		t.set(Calendar.HOUR, 0);
		t.set(Calendar.MINUTE, 0);
		t.set(Calendar.SECOND, 0);
		t.set(Calendar.MILLISECOND, 0);
		// t.clear(Calendar.MILLISECOND);
		
		Calendar b = new GregorianCalendar(t.get(Calendar.YEAR), month-1, day);
		
		System.out.println(t.getTimeInMillis());
		System.out.println(b.getTimeInMillis());
		
		System.out.println(t.after(b)); // true
		System.out.println(t.before(b)); // false
		System.out.println(t.equals(b)); // false
		System.out.println(t.compareTo(b)); // 같다:0 이후:1 이전:-1

	}//main

}//class
