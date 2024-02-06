package days13;

import java.util.Arrays;

/**
 * @author ♈ kenik
 * @date 2023. 2. 13. - 오후 2:55:55
 * @subject  배열+제어문 연습 예제
 * @content
 *
 */
public class Ex06 {

	public static void main(String[] args) {
		// 3:06 수업 시작
		// 2차원 배열 -> 1차원 배열 변환
		//  [ 4행 3열 ]
		int [][] m = {
                              				{ 1,2,3 }, 
                              				{ 4,5,6 }, 
                              				{ 7,8,9 }, 
                              				{ 10,11,12 } 
		                      };
		// 
		//int rowCount = m.length;
		//int colCount = m[0].length;
		//int [] n = new int[rowCount * colCount ];
		// System.out.println( n.length ); // 12
		int [] n = new int[ m.length * m[0].length ];
		
		/*
		int k = 0;
		for (int i = 0; i < m.length; i++) {          // 4 행갯수
			for (int j = 0; j < m[i].length; j++, k++) {  // 3열 갯수
				n[ k ]= m[i][j];
			}
		} // for i
		*/
		
		// k 변수를 선언하지 않아도  i, j 변수만 사용해서도 처리할 수 있다.
		//   i   j   k
		// 0  0   0
		// 0 1   1
		// 0 2   2
		// 1 1    3
		// 열갯수*i+j     == k
		int colLength = m[0].length;
		for (int i = 0; i < m.length; i++) {          // 4 행갯수
			for (int j = 0; j < m[i].length; j++) {  // 3열 갯수
				n[ colLength * i + j ]= m[i][j];
			}
		} // for i
		
		System.out.println(   Arrays.toString( n ) );

	} // main

} // class









