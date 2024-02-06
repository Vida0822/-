package days09;

import java.util.Random;

/**
 * @author dlsgu
 * @date 2023. 2. 7. 오후 3:14:44
 * @subject ***로또 번호 최종***
 * @content
 */
public class Ex03_04 {

	public static void main(String[] args) {

		int [] lotto = new int[6];

		fillLotto( lotto );

		dispLotto( lotto );

	} // main

	public static void fillLotto(int[] lotto) {
		int index = 0 , n;
		Random rnd = new Random(); 
		// [0]
		lotto[index++] = rnd.nextInt(45)+1; // 1

		//       [][][x][][]
		while( index <= 5 ) {
			n  = rnd.nextInt(45)+1;
			if( !isDuplicateLotto(  lotto, index, n  ) ) {
				lotto[index++] = n;
			} // if
		} // while 
	} // fillLotto

	public static boolean isDuplicateLotto(int[] lotto, int index, int n) {
		for (int i = 0; i < index; i++) {
			if( lotto[i] == n) {
				return true;  // 중복 된다.
			}
		} // for
		return false; // 중복 X
	}

	public static void dispLotto(int[] lotto) {
		for (int i = 0; i < lotto.length; i++) {
			System.out.printf("[%d]", lotto[i]);
		}
		System.out.println(); // 개행
	}

} // class
