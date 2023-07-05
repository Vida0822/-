package days13;

/**
 * @author dlsgu
 * @date 2023. 2. 13. 오전 11:26:06
 * @subject 2차원 배열 [시험문제2]
 * @content - 다차원 배열은 배열의 배열이다
 */
public class Ex03_03 {

	public static void main(String[] args) {
		/*
		int [][] m = new int[4][2];
		m[0][0]=0 m[0][1]=0 
		m[1][0]=0 m[1][1]=0 
		m[2][0]=0 m[2][1]=0 
		m[3][0]=0 m[3][1]=0 
		*/
		// 2차원 배열 초기화
		int [][] m = {  
						{1,2},
						{3,4},
						{5,6},
						{7,8}
					 };
		disp(m); // 2차원 배열 출력

	}//main

	private static void disp(int[][] m) {
		for (int i = 0; i < m.length; i++) { // 행 갯수
			for (int j = 0; j < m[i].length; j++) { // 열 갯수
				System.out.printf("m[%d][%d]=%d ", i, j, m[i][j]);
			}
			System.out.println();
		}

	}

}//class
