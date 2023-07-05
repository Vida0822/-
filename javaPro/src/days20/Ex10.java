package days20;

import java.util.Arrays;

/**
 * @author dlsgu
 * @date 2023. 2. 22. 오후 3:45:22
 * @subject
 * @content
 */
public class Ex10 {

	public static void main(String[] args) {

		int [] m = {3,5,2,4,1};
		System.out.println(Arrays.binarySearch(m, 2)); // 2
		Arrays.fill(m, 1); // [-1, -1, -1, -1, -1]
		System.out.println(Arrays.toString(m));
		
		// Arrays.asList(null);
		// 배열 복사 : System.arraycopy(args, 0, m, 0, 0);
		
	}//main

}//class
