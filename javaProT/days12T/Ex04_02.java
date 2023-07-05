package days12;

import java.util.Random;

public class Ex04_02 {

	public static void main(String[] args) {
		// 5~ 21
		// 0 ~ 16               +5
		// rnd.nextInt(17)+5
		
		// 44032	~ 55203
		// System.out.printf( "%d\t%d\n" , (int)'가', (int)'힣'  );

		Random rnd = new Random();
		char one = (char)( rnd.nextInt('힣' - '가' + 1) + '가' );
		System.out.println(  one );
		
	}

}
