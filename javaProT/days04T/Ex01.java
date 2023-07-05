package days04;

import java.util.Calendar;

/**
 * @author kenik 
 * @date  2023. 1. 31. - 오전 7:08:13
 * @subject   하동호 (개인사정)
 * @content  복습문제  9:35 제출
 *
 */
public class Ex01 {

	public static void main(String[] args) {
		
		// Duke's Birthday: 01 31,2023 ( 암기 ) 
		Calendar c =  Calendar.getInstance(); 
		String s1 = String.format("Duke's Birthday: %1$tm %1$te,%1$tY", c);
		System.out.println( s1 );   
		
		// byte, short, int, long      %d                   10진수
		// byte, short, int, long      %o                   8진수 
		// byte, short, int, long      %x  %X            16진수
		
		// %[argument_index$][flags][width][.precision]conversion
		// %                                              20.2                                        f       e  g  a
		// %                                    ,                                                  d
		// %            1$                        #                                                  d
		
		int m = -123;
		System.out.printf("%(d\n", m); // (123)
		
		int n = 10;
		
		// 10 -> 4자리의 숫자 형식으로 출력            0010
		System.out.printf("%04d\n", n);  // 0010
		
		
		// 10:05 수업 시작~ 
		// java.util.MissingFormatArgumentException: Format specifier '%o'
		// System.out.printf("%d %o %x\n", n , n, n);
		System.out.printf("%1$d %1$o %1$x\n", n );
		
		/*
		System.out.printf("%d\n", n); // 10
		System.out.printf("%o\n", n);  // 12
		System.out.printf("%#o\n", n);  // 012
		System.out.printf("%x\n", n);  // a
		System.out.printf("%#x\n", n);  // 0xa
		
		int money  = 3256700;  // \3,256,760
		// Error: Unresolved compilation problem: 
		// 	Invalid escape sequence (valid ones are  \b  \t  \n  \f  \r  \"  \'  \\ )
		System.out.printf("\\%,d\n", money);
		*/
		
		
		/*
		double avg = 98.127398;
		// 소수점 2자리 출력             %.2f
		System.out.printf("[%20f]\n", avg);    // [           98.127398]  오른쪽 정렬
		System.out.printf("[%-20f]\n", avg);  // [98.127398           ]  왼쪽 정렬
		System.out.printf("[%20.2f]\n", avg);  // [               98.13]   자동으로 3번째 자리에서 반올림.
		System.out.printf("[%.2f]\n", avg);      // [98.13]
		*/

	} // main

} // class









