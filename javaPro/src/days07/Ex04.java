package days07;

/**
 * @author dlsgu
 * @date 2023. 2. 3. 오후 2:24:34
 * @subject
 * @content
 */
public class Ex04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
		
		// 구구단 가로 출력
		for (int i = 2; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				System.out.printf("%d*%d=%02d\t", i, j, i*j);
			}
			System.out.println();
		}
	}//main

}//class
