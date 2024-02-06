package days02;

/**
 * @author kenik
 * @date  2023. 1. 27. - 오후 3:48:23
 * @subject     문자 자료형                  char(2)
 * @content    진법변환
 *
 */
public class Ex03_04 {

	public static void main(String[] args) {
	  // ASCII
	  // '0'-48~
	   // 'A'- 65~
		// 'a' -97
		// 대문자 - 소문자 = 32 차이
	  // char   [][][][][][][][] [][][][][][][][]
		
		// String %s %S
		// boolean %b %B
		// byte, short, int , long   %d
		// double    %f 소수점 6자리 출력.
		// char       %c  %C
		
		// 유니코드 2바이트 
		//  0x0000 ~ 0xFFFF
	  // char one =	 'a';
	   char one = '\u0061';
	  System.out.printf("one = %c \n", one);
	  System.out.printf("one = %C \n", one);
		
	  //  'A'       -> 인코딩->            65
	  //            <- 디코딩 <-
	} // main

} // class

/*
//byte     [0][0][0][0][1]   [0]    [1]   [0]
		//                                      23     22      21    20
		//                                       8       4       2       1  
		//                                     8 + 0+ 2+0 = 10
		//                                  진법변환
		// 10진수    [10]  -> 메모리 저장 0,1  ->  2진수
		//                         <-
		// 4:06 수업 시작~ 
		// 10진수 -> 2진수
		// 2진수 -> 10진수
		
		// 10진수 -> 8진수
		//        10  ->  012
		//  8진수 -> 10진수
		 // 1*8^1+ 2*8^0
		//       8 + 2 
		//         10
		
		// 10진수 -> 16진수
		//   20            0x0014       16진수 2바이트 
		// 16진수 -> 10진수
		//  0x14
		//     16^1 +   16^0
		//     16     +     4
		//         20

		// 67   -  2진수, 8진수, 16진수
		// [][][]  000 001  ~ 111 8가지
		
		// 0x00ff
*/






