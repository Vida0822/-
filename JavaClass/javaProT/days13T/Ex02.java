package days13;

import java.util.Arrays;

/**
 * @author ♈ kenik
 * @date 2023. 2. 13. - 오전 9:57:00
 * @subject     배열 + 제어문 연습.
 * @content     
 *
 */
public class Ex02 {

	public static void main(String[] args) {
		// 10:08 수업 시작~ 
		int [] m = new int[30];
		// 1.   0<=   <=9 임의의 정수를 채워넣는 코딩.
		// 2.  배열 확인.
		for (int i = 0; i < m.length; i++) {
			m[i] =  (int)(Math.random()*10 );   
		}
		System.out.println(  Arrays.toString(m)  );
		
		// [6, 0, 9, 2, 9, 7, 9, 6, 3, 2, 3, 6, 0, 6, 8, 2, 3, 4, 2, 7, 6, 1, 5, 2, 3, 9, 0, 1, 4, 1]
		
		//   0   1     2    3   4   5   6     7    8   9             인덱스(첨자값)
 		// [0][0][0][0][0][0][0][0][0][0]		  counts 배열 선언
		int [] counts = new int[10];
		
		for (int i = 0; i < m.length; i++) {  // 30번 반복
			  // m 배열의 0~29 값을 읽어와서
			  //int index =  m[i] ;
			  //counts[  index   ]++  ; // 0~9
			counts[  m[i]  ]++  ; // 0~9
		}
		
		for (int i = 0; i < counts.length; i++) {
			System.out.printf("%d : %d개 \n", i, counts[i] );
		}
				
		
		// [문제]  m 배열에   0~9 정수의 갯수를 파악하고자 한다..
		// i=0   j=0,1,2,3,4,5~29  cnt++     System.out.printf("%d : %d개 \n", i, cnt );
		// i=1   j=0,1,2,3,4,5~29
		// i=2   j=0,1,2,3,4,5~29
		// :
		// i=9   j=0,1,2,3,4,5~29
		//  10 * 30 == 300 번 반복 처리 ..
		/*
		int cnt ;
		for (int i = 0; i <= 9 ; i++) {                      // 행 갯수
			cnt = 0;
			for (int j = 0; j < m.length; j++) {       // 열갯수
				if( i == m[j])  cnt++;
			}
			System.out.printf("%d : %d개 \n", i, cnt );
		}
		*/
		
		/*
		// 0 : 5개
		int cnt_0 = 0;
		for (int i = 0; i < m.length; i++) {
			 if(   0 == m[i] )  cnt_0++;    
		}
		System.out.printf("0 : %d개 \n", cnt_0);
		
		// 1  : 2개
	    int cnt_1 = 0;
		for (int i = 0; i < m.length; i++) {
			 if(   1 == m[i] )  cnt_1++;    
		}
		System.out.printf("1 : %d개 \n", cnt_1);
		//      :
		//  8: 3개
		// 9 : 0개
		int cnt_9 = 0;
		for (int i = 0; i < m.length; i++) {
			 if(   9== m[i] )  cnt_9++;    
		}
		System.out.printf("9 : %d개 \n", cnt_9);
		*/
		

	}  // main

} // class






