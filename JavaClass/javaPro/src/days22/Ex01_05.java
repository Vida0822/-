package days22;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * @author dlsgu
 * @date 2023. 2. 24. 오전 10:36:17
 * @subject
 * @content
 */
public class Ex01_05 {

	public static void main(String[] args) {

		Calendar s = new GregorianCalendar(2023, 2-1, 17, 0, 0, 0);
		Calendar e = new GregorianCalendar(2023, 2-1, 26, 18, 0, 0);
		Calendar t = new GregorianCalendar();
		
		long sTime = s.getTimeInMillis();
		long eTime = e.getTimeInMillis();
		long tTime = t.getTimeInMillis();
		
		// if(sTime <= tTime && tTime <= eTime)
		// if(e.before(t) && s.after(t))

	}//main

}//class
