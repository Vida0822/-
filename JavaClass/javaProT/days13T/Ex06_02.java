package days13;

public class Ex06_02 {

	public static void main(String[] args) {
		// 1차원 -> 2차원 배열 변환
		int [] m = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12  };
		int [][] n = new int[6][2];
		// 코딩~~ 
		/* 
		 * i   n[행][열]
		 * 0      0     0          i/열갯수        i%열갯수
		 * 1       0     1
		 * 2       1     0
		 * 3       1     1
		 * 4       2    0
		 * 5       2     1
		 *  :
		 * 11   
		 * 
		 * */  
		int 열갯수 = n[0].length; // 2
		for (int i = 0; i < m.length; i++) {
			n[i/열갯수][i%열갯수] = m[i];
		}
		
		// 2차원 배열 출력
		for (int i = 0; i < n.length; i++) {
			for (int j = 0; j < n[i].length; j++) {
				System.out.printf("[%d]", n[i][j]);
			}			
			System.out.println();
		}
		

	}

}
