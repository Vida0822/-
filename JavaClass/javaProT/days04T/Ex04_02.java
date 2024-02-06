package days04;

/**
 * @author kenik
 * @date  2023. 1. 31. - 오후 12:41:51
 * @subject  소문자 -> 대문자 변경해서 출력.
 * @content  
 *
 */
public class Ex04_02 {

	public static void main(String[] args) {
		// 소문자   lowerCase
		// 대문자  upperCase
		
		char lowerCase = 'x';
		char upperCase;
		// 소문자 - 32 = 대문자
		// Type mismatch: cannot convert from int to char
		upperCase = (char) (lowerCase - 32);
		// 대문자 + 32 = 소문자
		System.out.println( upperCase );

	} // main

} // class






