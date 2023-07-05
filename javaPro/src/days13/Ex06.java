package days13;

import java.util.Arrays;

/**
 * @author dlsgu
 * @date 2023. 2. 13. 오후 2:56:12
 * @subject 배열 + 제어문 연습 예제
 * @content
 */
public class Ex06 {

	public static void main(String[] args) {
		// 2차원 배열 -> 1차원 배열 변환
		// [4행 3열]
		int [][] m = {
						{1,2,3},
						{4,5,6},
						{7,8,9},
						{10,11,12}
					 };
		
		// int rowCount = m.length;
		// int colCount = m[0].length;
		// int [] n = new int[rowCount*colCount];
		// System.out.println(n.length);
		int [] n = new int[m.length*m[0].length];
		
		int colLength = m[0].length;
		for (int i = 0; i < m.length; i++) { // 행갯수 4
			for (int j = 0; j < m[i].length; j++) { // 열갯수 3
				n[colLength*i+j] = m[i][j];
			}
		}
		System.out.println(Arrays.toString(n));
	}//main

}//class
