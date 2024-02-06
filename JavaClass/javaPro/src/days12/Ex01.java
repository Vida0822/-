package days12;

import java.util.Arrays;

/**
 * @author dlsgu
 * @date 2023. 2. 10. 오전 10:03:23
 * @subject 10진수 -> 16진수
 * @content
 */
public class Ex01 {

	public static void main(String[] args) {

		// 16진법 : 0 1 2 3 4 5 6 7 8 9 10(a)~ 15(f)
		int n = 123;   // 7B
		int 몫, 나머지;  // share, rest

		// String b = "0101"; -> 1010
		char [] hex = new char[4]; // [0][0][7][B]

		// char 배열 hex의 모든 요소의, 값을 '0' 초기화
		/*
	        for (int i = 0; i < hex.length; i++) {
	         hex[i] = '0';
	      }
		 */
		Arrays.fill(hex, '0');

		int index = hex.length-1;  // 3
		while( n != 0) {
			몫 = n/16;
			나머지 = n%16; 
			// 10(A) 11(B)  12(C)  ~ 15(F)          'F'

			// 나머지 =  나머지 >=10? 나머지 + 55 : 나머지;
			char value =  (char)( 나머지 += 나머지 >=10 ? 55 : 48 ) ; 

			hex[index--] = value;

			/*
	         if ( 나머지 >= 10) {
	            switch (나머지) {
	            case 10:
	               b += 'A';
	               break;
	            case 11:
	               b +='B';
	               break;

	            default:
	               break;
	            }
	         } else {
	            b += 나머지;
	         }
			 */

			n =  몫;
		}//while

		System.out.println( "0x"+ Arrays.toString( hex ) );


	}//main

}//class
