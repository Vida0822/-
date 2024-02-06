package days13;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author dlsgu
 * @date 2023. 2. 13. 오전 11:58:04
 * @subject 검색(Search) == 탐색
 * @content	- 같은 성질을 갖는 항목의 집합 중에서 특성을 갖는 항목을 찾아내는 것
 * 			1) 순차검색 (Sequence Search)
 * 			2) 이진검색 (binary Search)
 */
public class Ex04_02 {

	public static void main(String[] args) {

		int [] m = {5, 11, 20, 13, 1, 5, 20, 1, 15, 1, 2, 8, 9, 17, 3, 8, 4, 9, 20, 2, 15, 14, 19, 9, 9, 12, 5, 19, 8, 9};
		System.out.println(Arrays.toString(m));
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("> 배열에서 찾을 정수 입력 ? ");
		int n = scanner.nextInt();

		int idx = -1;
		int fromIndex = 0;
		
		while ((idx = sequenceSearch(m, n, fromIndex)) != -1) {
			System.out.println(idx + " 찾았다");
			fromIndex = idx + 1;
		}
		
		/*
		idx = sequenceSearch(m, n, fromIndex);
		System.out.println(idx + " 찾았다");
		
		fromIndex = idx + 1;
		idx = sequenceSearch(m, n, fromIndex);
		System.out.println(idx + " 찾았다");
		*/

	}//main
	
	private static int sequenceSearch(int[] m, int n, int fromIndex) {

		for (int i = fromIndex; i < m.length; i++) {
			if (m[i] == n) return i;
		}
		return -1;
	}
	
	private static int sequenceSearch(int[] m, int n) {

		for (int i = 0; i < m.length; i++) {
			if (m[i] == n) return i;
		}
		return -1;
	}


}//class
