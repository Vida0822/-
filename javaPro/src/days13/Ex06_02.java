package days13;

/**
 * @author dlsgu
 * @date 2023. 2. 13. 오후 3:23:22
 * @subject 1차원 배열 -> 2차원 배열 변환 [시험문제3]
 * @content
 */
public class Ex06_02 {

	public static void main(String[] args) {
		// 1차원 배열 -> 2차원 배열 변환
		int [] m = {1,2,3,4,5,6,7,8,9,10,11,12};
		int [][] n = new int[6][2];
		
		int 열갯수 = n[0].length;
		for (int i = 0; i < m.length; i++) {
			n[i/열갯수][i%열갯수] = m[i];
		}
		
		for (int i = 0; i < n.length; i++) {
			for (int j = 0; j < n[i].length; j++) {
				System.out.printf("[%d]", n[i][j]);
			}
			System.out.println();
		}

	}//main

}//class
