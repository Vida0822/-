package days06;

import java.util.Iterator;

/**
 * @author kenik
 * @date  2023. 2. 2. - 오후 4:07:16
 * @subject    중첩 if문,  *** [중첩for문  연습] - 별찍기 ***
 * @content 
 *
 */
public class Ex04 {

	public static void main(String[] args) {
		//  별찍기 - 처리 과정 설명.
		 // ****
		 // ****
		 // ****
		 // ****
		
		/*
		System.out.println("****");
		System.out.println("****");
		System.out.println("****");
		System.out.println("****");
		*/
		
		/*
		for (int i = 1; i <= 4 ; i++) {
			System.out.println("****");
		}
		*/

		// 중첩 for문
		/*
		 *  i=1    1 <= 4(참)
		 *  j=1,2,3,4      5    5 <=4(거짓)
		 *  i=2   2<=4(참)
		 *  j=1,2,3,4      5    5 <=4(거짓)
		 *  i=3   3<=4(참)
		 *  j=1,2,3,4      5    5 <=4(거짓)
		 *  i=4   4<=4(참)
		 *  j=1,2,3,4      5    5 <=4(거짓)
		 *  i=5   5<=4(거짓)
		 *  
		 *     ****개행
		 *     ****개행
		 *     ****개행
		 *     ****개행
		 *     
		 * */
		for (int i = 1; i <= 4 ; i++) {        // 행갯수
			for (int j = 1; j <= 4 ; j++) {    // 별(열)갯수
				System.out.print("*");
			} // for j
			System.out.println();  
		} // for i
	} // main

} // class









