package days13;

/**
 * @author ♈ kenik
 * @date 2023. 2. 13. - 오전 11:42:52
 * @subject  3차원 배열   배열크기, 행갯수, 면갯수, 열개수 + 출력  for 문사용. (시험)
 * @content
 *
 */
public class Ex03_04 {

	public static void main(String[] args) {
		// int [] m = new int[8];
		// int [][] m  = new int[4][2];
		
		//                                    2면 3행 4열
		// int [][][] m = new int[2][3][4];
		
		// 3차원 배열 초기화
		int [][][] m = {
				                             {
				                            	    {1,2,3,4},  
								                    {5,6,7,8},  
								                    {9, 10,11,12}
				                             },
				                             {
				                            	    {1,2,3,4},  
								                    {5,6,7,8},  
								                    {9, 10,11,12}
				                             }
		                           };
		
		disp( m );  // 3차원 배열을 출력하는 함수 선언 + 호출
		
		System.out.println(  m.length  );  // 2       면 갯수
		
		System.out.println(  m[0].length  ); // 3 행 갯수           0면의 행 갯수 3
		System.out.println(  m[1].length  ); // 3 행 갯수             1면의 행 갯수 3
		
		System.out.println(   m[0][0].length );   // 0면 0행의 열갯수 4
		System.out.println(   m[0][1].length );    // 0면 1행의 열갯수 4
		System.out.println(   m[0][2].length );   // 0면 2행의 열갯수 4
	 
		
		System.out.println(   m[1][0].length ); 
		System.out.println(   m[1][1].length ); 
		System.out.println(   m[1][2].length ); 
 
		 

	} // main

	private static void disp(int[][][] m) {
		for (int i = 0; i < m.length; i++) {                     // 면 갯수			
			System.out.printf("[%d]면\n", i);			
			for (int j = 0; j < m[i].length; j++) {            // 행 갯수				
				for (int k = 0; k < m[i][j].length; k++) {  // 열 갯수
					System.out.printf("m[%d][%d][%d]=%d\t", i, j, k, m[i][j][k]);
				}	// for k		 	
				System.out.println(); // 개행
			} // for j
			System.out.println();  // 개행
		} // for i
		
	}

} // class










