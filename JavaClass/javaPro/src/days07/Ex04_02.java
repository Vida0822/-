package days07;

/**
 * @author dlsgu
 * @date 2023. 2. 3. 오후 2:37:23
 * @subject
 * @content
 */
public class Ex04_02 {

	public static void main(String[] args) {
		// 구구단 세로 출력
		for (int i = 1; i <= 9; i++) {
			for (int j = 2; j <= 9; j++) {
				System.out.printf("%d*%d=%02d\t", j, i, i*j);
			}
			System.out.println();
		}

	}//main

}//class
