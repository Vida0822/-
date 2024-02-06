package days13;

import java.util.Arrays;

/**
 * @author dlsgu
 * @date 2023. 2. 13. 오전 9:57:32
 * @subject 배열 + 제어문 연습 [시험문제1]
 * @content
 */
public class Ex02 {

	public static void main(String[] args) {
		int [] m = new int[30];
		// 1. 0<= <=9 임의의 정수를 채워넣는 코딩
		// 2. 배열 확인

		for (int i = 0; i < m.length; i++) {
			m[i] = (int)(Math.random()*10);
		}
		System.out.println(Arrays.toString(m));
		
		// [문제] m 배열에 0~9 정수의 갯수를 파악하고자 한다
		// 0: 5개
		// 1: 2개
		//   :
		// 8: 3개
		// 9: 0개
		
		//  0  1  2  3  4  5  6  7  8  9	인덱스(첨자값)
		// [0][0][0][0][0][0][0][0][0][0]	counts 배열 선언
		int [] counts = new int[10];
		for (int i = 0; i < m.length; i++) {
			// int index = m[i];
			// counts[index]++;
			counts[m[i]]++;
		}
		for (int i = 0; i < counts.length; i++) {
			System.out.printf("%d : %d개\n", i, counts[i]);
		}
		
		// for문 10*30 == 300번 반복처리
		/*
		 * int count;
		for (int i = 0; i <= 9; i++) {
			count = 0;
			for (int j = 0; j < m.length; j++) {
				if (m[j] == i) count++;
			}
			System.out.printf("%d : %d개\n", i, count);
		}
		*/

	}//main

}//class
