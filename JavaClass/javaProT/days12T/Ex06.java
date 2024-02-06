package days12;

import java.util.Arrays;
import java.util.Random;

/**
 * @author ♈ kenik
 * @date 2023. 2. 10. - 오후 2:50:34
 * @subject  카드 섞기, 화투 섞기 등등
 * @content
 *
 */
public class Ex06 {

	public static void main(String[] args) {
 
		int [] m = { 0,1,2,3,4,5,6,7,8,9 };
		System.out.println(  Arrays.toString(m)  );
		
		shuffle(m);
		
		System.out.println(  Arrays.toString(m)  );

	} // main

	private static void shuffle(int[] m) {
		Random rnd = new Random();
		int idx1 = 0 , idx2 ;
		
		for (int i = 0; i < 100; i++) {
			// idx1 = rnd.nextInt(  m.length ) ;
			idx2 = rnd.nextInt(  m.length ) ;
			System.out.printf("%d - %d \n", idx1, idx2);
			
			int temp = m[idx1];
			m[idx1] = m[idx2];
			m[idx2] = temp;
		}
	} // shuffle

} // class













