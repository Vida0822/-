package days07;

/**
 * @author kenik
 * @date 2023. 2. 3. - 오후 2:24:09
 * @subject
 * @content
 *
 */
public class Ex04 {

	public static void main(String[] args) {
		
		// 구구단  가로 출력.
		// [2단]~[9단]
		/*
		System.out.printf("%d*%d=%d\n", 2, 1, 2*1);
		System.out.printf("%d*%d=%d\n", 2, 2, 2*2);
		System.out.printf("%d*%d=%d\n", 2, 3, 2*3);
		System.out.printf("%d*%d=%d\n", 2, 4, 2*4);
		System.out.printf("%d*%d=%d\n", 2, 5, 2*5);
		System.out.printf("%d*%d=%d\n", 2, 6, 2*6);
		System.out.printf("%d*%d=%d\n", 2, 7, 2*7);
		System.out.printf("%d*%d=%d\n", 2, 8, 2*8);
		System.out.printf("%d*%d=%d\n", 2, 9, 2*9);
		*/
		/*
		for (int i = 1; i <= 9 ; i++) {
			System.out.printf("%d*%d=%d\n", 2, i, 2*i);
		}
		for (int i = 1; i <= 9 ; i++) {
			System.out.printf("%d*%d=%d\n", 3, i, 3*i);
		}
		for (int i = 1; i <= 9 ; i++) {
			System.out.printf("%d*%d=%d\n", 4, i, 4*i);
		}
		:
		for (int i = 1; i <= 9 ; i++) {
			System.out.printf("%d*%d=%d\n", 9, i, 9*i);
		}
		*/
		
		// i=2   j=1,2,3,4,5,6,7,8,9            10<=9 거짓
		// i=3   j=1,2,3,4,5,6,7,8,9            10<=9 거짓
		// i=4   j=1,2,3,4,5,6,7,8,9            10<=9 거짓
		// :
		// i=9   j=1,2,3,4,5,6,7,8,9            10<=9 거짓
		// i=10   거짓
		for (int i = 2; i <=9 ; i++) {          // 행(단)
			for (int j = 1; j <= 9 ; j++) {      // 열
				System.out.printf("%d*%d=%02d\t", i, j, i*j);
			}
			System.out.println();
		}
		

	} // main

} // class








