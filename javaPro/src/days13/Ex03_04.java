package days13;

/**
 * @author dlsgu
 * @date 2023. 2. 13. 오전 11:43:07
 * @subject 3차원 배열 배열크기, 면/행/열 갯수
 * @content
 */
public class Ex03_04 {

	public static void main(String[] args) {
		//					  2면3행4열
		//int [][][] m = new int[2][3][4];
		
		// 3차원 배열 초기화
		int [][][] m = {
							{
								{1,2,3,4},
								{5,6,7,8},
								{9,10,11,12}
							},
							{
								{1,2,3,4},
								{5,6,7,8},
								{9,10,11,12}								
							}
					   };
		
		disp(m);

	}//main

	private static void disp(int[][][] m) {
		for (int i = 0; i < m.length; i++) {
			System.out.printf("[%d]면\n", i);
			for (int j = 0; j < m[i].length; j++) {
				for (int k = 0; k < m[i][j].length; k++) {
					System.out.printf("m[%d][%d][%d]=%d\t", i, j, k, m[i][j][k]);
				}//for k
				System.out.println();
			}//for j
			System.out.println();
		}//for i
		
	}

}//class
