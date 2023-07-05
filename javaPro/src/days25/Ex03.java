package days25;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;

/**
 * @author dlsgu
 * @date 2023. 3. 2. - 오전 11:35:22
 * @subject 
 * @content 
 *
 */
public class Ex03 {

	public static void main(String[] args) {
		// [빙고 게임]
		int [][] bingo = new int[5][5];
		// 숫자를 중복되지 않게 1~50 채워넣자
		/*
		for (int i = 0; i < bingo.length; i++) {
			for (int j = 0; j < bingo[i].length; j++) {
				int n = (int)(Math.random()*50)+1;
				if (!isDuplicateCheck(bingo, i, j, n)) {
					bingo[i][j] = n;
				} else {
					j--;
				}
			}
		}
		*/
		LinkedHashSet set = new LinkedHashSet(25);
		while (set.size() < 25) {
			int n = (int)(Math.random()*50)+1;
			set.add(n);
		}
		// 1차원 -> 2차원 / 2차원 -> 1차원 / 2차원 -> 2차원
		int i = 0;
		Iterator ir = set.iterator();
		while (ir.hasNext()) {
			int n = (int) ir.next();
			bingo[i/5][i%5] = n;
			i++;
		}

		// 출력
		for (i = 0; i < bingo.length; i++) {
			for (int j = 0; j < bingo[i].length; j++) {
				System.out.printf("[%02d]", bingo[i][j]);
			}
			System.out.println();
		}
		
		/*
		for (int i = 0; i < bingo.length; i++) {

			for (int j = 0; j < bingo.length; j++) {
				int n = (int)(Math.random()*50)+1;
				num.add(n);
			}

		}
		Iterator ir = num.iterator();
		while (ir.hasNext()) {
			for (int i = 0; i < bingo.length; i++) {
				for (int j = 0; j < bingo.length; j++) {
					int n = (int) ir.next();
					bingo[i][j] = n;
				}
			}
		}
		System.out.println(Arrays.toString(bingo));
		*/

	}//main
	
	/*
	private static boolean isDuplicateCheck(int[][] bingo, int i, int j, int n) {
		for (int k = 0; k < i; k++) {
			for (int k2 = 0; k2 < bingo[i].length; k2++) {
				
			}
		}
		for (int k = 0; k < j; k++) {
			bingo[i][k] = n;
		}
		return false;
	}
	*/
	
}//class
