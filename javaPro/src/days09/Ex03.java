package days09;

import java.util.Random;

/**
 * @author dlsgu
 * @date 2023. 2. 7. 오후 12:28:46
 * @subject
 * @content
 */
public class Ex03 {

	public static void main(String[] args) {
		// 제어문 + [***요구분석***] + 코딩
		// [로또게임]
		// 1~45 / 6
		
		// 0.0 <= double Math.random() < 1.0
		// 1 <= (int)(Math.random()*45)+1 < 46
		
		// java.util.Random 클래스
		Random rnd = new Random();
		for (int i = 1; i <= 6; i++) {
			System.out.println(rnd.nextInt(45)+1); // 1 <= int < 45
		}
		// 문제점: 중복된 로또번호 발생 Ex03_02

	}//main

}//clas
