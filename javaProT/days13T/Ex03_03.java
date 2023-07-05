package days13;

/**
 * @author ♈ kenik
 * @date 2023. 2. 13. - 오전 11:25:26
 * @subject     2차원배열
 * @content    - ****  다차원 배열은 배열의 배열이다.  ( 엑셀 그림  이해...) 
 *
 */
public class Ex03_03 {

	public static void main(String[] args) {
		// int  m[][]
		/*
		int [][] m = new int[4][2];
		m[0][0]=1; m[0][1]=2; 
		m[1][0]=3; m[1][1]=4; 
		m[2][0]=5; m[2][1]=6; 
		m[3][0]=7; m[3][1]=8;
		*/
	    // (시험3)  2차원 배열의 초기화 하는 코딩을 하세요.
		int [][] m = {   	               
				                    {1,2},  
				                    {3,4},  
				                    {5,6},  
				                    {7,8}			             
		                      };
		
		// 2차원배열      배열명.length == 행 갯수
		System.out.println(    m.length  );  // 4
		
		System.out.println(    m[0].length  );  // 2          열 갯수
		System.out.println(    m[1].length  );  // 2           열 갯수
		System.out.println(    m[2].length  );  // 2           열 갯수
		System.out.println(    m[3].length  );  // 2          열 갯수

		disp(m);  // 2차원 배열 출력
	} // main

	// (시험1) 2,3 다차원배열 구조(그림)
	// (시험2) 2,3 다차원배열 출력하는 함수 구현.
	private static void disp(int[][] m) {
		// 행, 열
		for (int i = 0; i < m.length; i++) {   // 행 갯수
			for (int j = 0; j < m[i].length; j++) { // 열 갯수
				System.out.printf("m[%d][%d]=%d ", i, j, m[i][j]);
			}
			System.out.println();
		}
		
	}

} // class









