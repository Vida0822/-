package days13;

/**
 * @author ♈ kenik
 * @date 2023. 2. 13. - 오전 11:09:14
 * @subject  다차원 배열.
 * @content  1차원 배열 - 열
 *
 */
public class Ex03_02 {

	public static void main(String[] args) {
		// 11:20 수업시작
		// int [] m = new int[8];
		
		// 배열 초기화
		// int [] m = new int[] {1,2,3,4,5,6,7,8};
		int [] m ={ 1,2,3,4,5,6,7,8 };
		
		// 1. 1차원 배열의 크기 -     배열명.length
		System.out.println(    m.length   );  // 8
		
		disp(m);

	} // main

	private static void disp(int[] m) {
		 for (int i = 0; i < m.length; i++) {
			System.out.printf("m[%d]=%d ", i, m[i]);
		}
		 System.out.println();
	}

} // class










