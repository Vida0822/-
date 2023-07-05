package days07;

/**
 * @author dlsgu
 * @date 2023. 2. 3. 오후 2:52:46
 * @subject
 * @content
 */
public class Ex04_03 {

	public static void main(String[] args) {
		// 구구단 세로 출력 2층
		
		/*
		for (int i = 1; i <= 9; i++) {
			for (int j = 2; j <= 5; j++) {
				System.out.printf("%d*%d=%02d\t", j, i, i*j);
			}
			System.out.println();
		}
		System.out.println();
		for (int i = 1; i <= 9; i++) {
			for (int j = 6; j <= 9; j++) {
				System.out.printf("%d*%d=%02d\t", j, i, i*j);
			}
			System.out.println();
		}
		*/
		
		for (int k = 1; k <= 2; k++) {
			for (int i = 1; i <= 9; i++) {
				for (int j = 4*k-2; j <= 4*k+1; j++) {
					System.out.printf("%d*%d=%02d\t", j, i, i*j);
				}
				System.out.println();
			}
			System.out.println();
		}
	}//main

}//class
