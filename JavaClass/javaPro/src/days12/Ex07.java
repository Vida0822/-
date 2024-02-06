package days12;

import java.util.Arrays;

/**
 * @author dlsgu
 * @date 2023. 2. 10. 오후 3:20:07
 * @subject 정보처리기사 실기(알고리즘)
 * @content 정렬(Sort): 특정 기준에 맞게 데이터를 열거하는 알고리즘
 * 			(성적순, 키순, 나이순)
 * 			정렬 - 오름차순(ascending) 정렬 1,2,3,4,5 작은->큰
 * 				   내림차순(descending) 정렬 5,4,3,2,1 큰->작은
 * 			[정렬 알고리즘 방법]
 * 			1. 버블정렬, 선택정렬, 삽입정렬, 병합정렬
 */
public class Ex07 {

	public static void main(String[] args) {
		int [] m = { 3,5,2,4,1};
		System.out.println(  Arrays.toString( m ) );
		// [버블정렬(bubble sort)] - asc(오름차순) 정렬
		// buubleSort(m);

		// [선택정렬(selection sort)]
		selectionSort(m);

	}//main

	public static void selectionSort(int[] m) {

		//Arrays.sort(m)

		// 1회전: m[0] = 가장작은값 (5개중):
		for (int i = 0; i < m.length-1; i++) {
			int minIndex = i;
			for (int j = i+1; j < m.length; j++) {
				if(m[minIndex] > m[j]) {
					minIndex = j;
				}
			}
			System.out.println("> minIndex = " + minIndex);

			int temp = m[i];
			m[i] = m[minIndex];
			m[minIndex] = temp;

			System.out.println( Arrays.toString(m) );
		}
		
		// 2회전: m[1] = 가장작은값 (4개중):
		// 3회전: m[2] = 가장작은값 (3개중):
		// 4회전: m[3] = 가장작은값 (2개중):


	}//selectionSort
	// 인접한 두 원소를 비교해서 작은 값하고 자리바꿈
	// 0-1  0-2 0-3  0-4 
	// 1-2  1-3 1-4 
	// 2-3 2-4
	// 3-4

	/*
	for (int i = 0; i < m.length; i++) {
		for (int j = i+1; j < m.length; j++) {
			if (m[i]>m[j]) {
				int temp = m[j];
				m[j] = m[i];
				m[i] = temp;
			}
		}
	}
	System.out.println(Arrays.toString(m));
	 */

	/*
	for (int i = 0; i < m.length-1; i++) {
         for (int j = i+1; j < m.length; j++) {
            System.out.printf("%d-%d ", i, j);
            if( m[i] > m[j] ) {
               System.out.print(" *** ");
               int temp = m[i];
               m[i] = m[j];
               m[j] = temp;
            }
            System.out.println(Arrays.toString(m));
         } // for j

      }  // for i
	 */


	public static void buubleSort(int[] m) {
		// - 인접한 두 원소를 검사하며 정렬하는 알고리즘
		// - 두 개의 인접한 자료 값을 비교하면서 위치를 교환하는 방식으로 정렬하는 방법

		//                 0-1  1-2  2-3  3-4   1회차          ****
		//                 0-1  1-2  2-3            2회차         ***
		//                 0-1  1-2                    3회차          **
		//                 0-1                            4회차          *
		//                 [1][2][3][4][5] 
		// i=0  j=3
		// i=1  j=2
		// i=3  j=1
		// i=4  j=0
		// i+j=4
		// j=4-i
		for (int i = 0; i < 4; i++) {                     // i = 행 갯수
			for (int j = 0; j < 4-i; j++) {  // j = 열(별) 갯수
				System.out.printf("%d-%d ", j , j+1);
				if( m[j] > m[j+1]) { 
					System.out.print( " *** ");
					int temp = m[j];
					m[j] = m[j+1];
					m[j+1] = temp;
				}
				System.out.println(  Arrays.toString( m ) );
			} 
		}
	}//buubleSort

}//class
