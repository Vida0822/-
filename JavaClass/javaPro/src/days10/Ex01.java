package days10;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Ex01 {

	public static void main(String[] args) {

		int [] lotto = new int[6];
		
		fillLotto(lotto);
		dispLotto(lotto);

	}//main

 	public static void fillLotto(int[] lotto) {
		int index = 0 ,n;
		Random rnd = new Random();
		while (index <= 5) {
			n = rnd.nextInt(45)+1; // 1<=n<46
			if(isDuplicateLotto(lotto, index, n)) {
				lotto[index++] = n;
			}
		}
		
	}

	public static void dispLotto(int[] lotto) {
 		// Array 클래스는 배열을 사용하기 쉽도록 기능이 구현된 클래스이다
 		// toString() 배열 -> 문자열로 반환하는 메서드
		System.out.println(Arrays.toString(lotto)); // [0,0,0,0,0,0]
	}

	public static boolean isDuplicateLotto(int[] lotto, int index, int n) {
	for (int i = 0; i < lotto.length; i++) {
		if (lotto[i] == n) return false ;
	}
	return true;
	}


}//class
