package days04;

import java.util.Calendar;

/**
 * @author dlsgu
 * @date 2023. 1. 31. 오전 9:07:54
 * @subject
 * @content
 */
public class Ex01 {

	public static void main(String[] args) {
		
		// Duke's Birthday: 01 31,2023
		Calendar c = Calendar.getInstance();
		String s1 = String.format("Duke's Birthday: %1$tm %1$te,%1$tY", c); // %tm 월, %te 일, %tY 년
		System.out.println(s1);
		
		// byte, short, int, long		%d		10진수
		// byte, short, int, long		%o		8진수
		// byte, short, int, long		%x, %X	16진수
		
		//  %[argument_index$][flags][width][.precision]conversion
		//  %		1$			, #		20		.2			d f(e, g, a)
		
		int m = -123;
		System.out.printf("%(d\n", m); // (123)
		
		int n = 10;
		
		// 10 -> 4자리 숫자 형식으로 출력 -> 0010
		System.out.printf("%04d\n", n); // 0010
		
		System.out.printf("%1$d %1$o %1$x\n", n);
		
		/*
		System.out.printf("%d\n", n); // 10
		System.out.printf("%o\n", n); // 12
		System.out.printf("%#o\n", n); // 012
		System.out.printf("%x\n", n); // a
		System.out.printf("%#x\n", n); // 0xa
		
		int money = 3256700; // \3,256,700
		// Error: Unresolved compilation problem: 
		// Invalid escape sequence (valid ones are  \b  \t  \n  \f  \r  \"  \'  \\ )
		System.out.printf("\\%,d\n", money);
		*/
		
		/* 
		 * 소수점 2자리 출력
		double avg = 98.127398;
		System.out.printf("[%20f]", avg); // [           98.127398] -> 전체자리 20 / 공백 9 / 오른쪽 정렬
		System.out.printf("[%-20f]", avg); // [98.127398           ] -> 전체자리 20 / 공백 9 / 왼쪽 정렬
		System.out.printf("[%20.2f]", avg); // [               98.13] -> 전체자리 20 / 공백 13 / 오른쪽 정렬 // 자동으로 3번째 자리에서 반올림
		System.out.printf("[%.2f]", avg); // [98.13] -> %.2f 소수점 2째 자리까지 자동으로 3번째 자리에서 반올림
		*/

	}//main

}//class
