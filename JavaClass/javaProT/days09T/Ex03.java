package days09;

import java.util.Random;

/**
 * @author kenik
 * @date  2023. 2. 7. - 오후 12:28:40
 * @subject 
 * @content 
 *
 */
public class Ex03 {

	public static void main(String[] args) {
		// 제어문 + [***요구분석***] + 코딩~
		// [로또 게임]
		//  1 ~ 45   /  6 
		
		// 0.0 * 45 <=  double Math.random()  * 45< 1.0 *45
		// 0 + 1<=   (int)(  Math.random()  * 45 ) +1 < 45 +1
		// 1 <=  int  < 46
		
		// java.util.Random 클래스
		Random rnd = new Random();
		for (int i = 1; i <= 6 ; i++) {
			System.out.println( rnd.nextInt(45)+1 );  // ;    // 1<=  int  < 46
		}
		/* 
		7
		28      *****  중복된 로또번호 발생.( 문제점 )        Ex03_02.java  중복된 로또번호 발생하지 않도록 처리.
		26
		3
		20
		28      *****
		*/

	} // main

} // class













