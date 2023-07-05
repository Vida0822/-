package days09;

import java.text.DecimalFormat;

public class FormatUtil {
	
	// 1. 인스턴스 메서드 
	public String number(long number, String pattern) {
		DecimalFormat df = new DecimalFormat(pattern); 
		return df.format(number);
	}// number
	
	// 2. static 메서드 
	public static String staticNumber(long number, String pattern) {
		DecimalFormat df = new DecimalFormat(pattern); 
		return df.format(number);
	} // staticNumber
} //FormatUtil
