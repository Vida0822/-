package days12;

import java.util.Arrays;

/**
 * @author ♈ kenik
 * @date 2023. 2. 10. - 오후 2:06:42
 * @subject
 * @content
 *
 */
public class Ex04_03 {

	public static void main(String[] args) {
		// 등수처리 ? [총점]
		/*                                        총점
		[1]	늨천딍	93	80	13		186	62.00	1
		[2]	섀꺜닄	50	95	44	189	63.00	1
		[3]	눒솼걒	90	62	36	188	62.67	1
		[4]	굽쏐뽱	14	36	9		59	19.67	1
		[5]	휈쉮츈	3	50	79		132	44.00	1
		[6]	웛줞뎿	50	41	33		124	41.33	1
		*/

		/*
		 * int [] m = new int[3];      
		 * m[0]=1; // 초기화
		 * m[1]=2; // 초기화
		 * m[2]=3; // 초기화
		 * 
		 * int [] m = new int[]{1,2,3};  // 배열 초기화
		 * int [] m = { 1,2,3 };  // 배열 초기화
		 * 
		 * */
		// int [] tots =  ( 186, 189, 188, 59, 132, 124 );    () 최우선연산자, cast 연산자
		

		// [배열 초기화]
		int [] tots = { 186, 189, 188, 59, 132, 124 };		
		int [] ranks = new int[6];
		
		//  코딩 구현.   (별, 구구단)
		// [1]    1        1x 2 3 4 5 6
		// [2]    1       1 2x 3 4 5 6
		// [3]    1       1 2 3x 4 5 6
		// [4]    1       1 2 3 4x 5 6
		// [5]    1       1 2 3 4 5x 6
		// [6]    1       1 2 3 4 5 6x
		for (int i = 0; i < tots.length; i++) {  // 등수를 매길
			ranks[i]=1;
			for (int j = 0; j < tots.length; j++) {
				// if(   tots[i] < tots[j]  &&  i != j)  ranks[i]++;
				if(   tots[i] < tots[j] )  ranks[i]++;
			}
		}
		System.out.println( Arrays.toString(tots) );
		System.out.println( Arrays.toString(ranks) );
		
		
		
		
		

	} // main

} // class









