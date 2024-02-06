package days04;

/**
 * @author kenik
 * @date  2023. 1. 31. - 오후 12:32:39
 * @subject 
 * @content 
 *
 */
public class Ex04 {

	public static void main(String[] args) {
		
		char a = 'a';  // 97
		char d = 'd';  // 100
		char zero = '0';
		char two = '2';
		
		System.out.printf("'%c' (%d)\n", zero , (int)zero);
		
		System.out.println(   two - zero );  //  '2'-'0' == 50 - 48 => 2
		
		// 'd'-'a' == 100 - 97
		System.out.printf("'%c'-'%c' = %d\n", a, d ,     d - a      );
		
		//  대문자 -> 소문자 변경
		//  소문자 -> 대문자 변경
		// 소문자 'a' - 32 빼면 대문자 'A'
		// 대문자 'A' + 32 더하면 소문자 'a'
		char x = 'a' - 32;
		System.out.println( x );
		

	} // main

} // class






