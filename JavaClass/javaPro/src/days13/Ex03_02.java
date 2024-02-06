package days13;

/**
 * @author dlsgu
 * @date 2023. 2. 13. 오전 11:09:20
 * @subject
 * @content
 */
public class Ex03_02 {

	public static void main(String[] args) {
		// int [] m = new int[8];
		
		// 배열 초기화
		int [] m = {1,2,3,4,5,6,7,8};
		
		// 1차원 배열 크기 .length
		System.out.println(m.length);
		
		disp(m);

	}//main

	private static void disp(int[] m) {
		for (int i = 0; i < m.length; i++) {
			System.out.printf("m[%d]=%d ", i, m[i]);
		}
		System.out.println();
	}

}//class
