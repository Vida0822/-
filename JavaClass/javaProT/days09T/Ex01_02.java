package days09;

/**
 * @author kenik
 * @date  2023. 2. 7. - 오전 7:15:34
 * @subject   함수(메서드) + 매개변수      -> 호출 방법
 * @content   1) Call By Name                  drawLine(); //  함수 호출부
 *                                                                   매개변수 없이 함수명만 가지고 호출하는 것.
 *                      2) Call By Value                 값(value)   swap( x, y );
 *                      3) Call By Point  X
 *                      4) Call By Reference        참조형(배열, 클래스, 인터페이스)
 *
 */
public class Ex01_02 {   // 시험 문제 1) 

	public static void main(String[] args) {		 
		int [] m = {10, 20};
		System.out.printf("x=%d, y=%d\n", m[0],  m[1]);		
		// The method swap(int, int) in the type Ex01_02 is not applicable for the arguments (int[])
		swap( m );  // Call By Reference
		System.out.printf("x=%d, y=%d\n", m[0],  m[1]);
	} // main
 
	private static void swap(int[] m) {   // int [] m = m;
		//    [10][20]                [0x100번지]m              main 배열명 m
		//   0x100번지
		int temp = m[0];
		m[0] = m[1];
		m[1] = temp; 
		//                                   [0x100번지]m              swap 배열명 m 
		
	}

	public static void swap(int x, int y) {  // 지역변수   int x = 10, y = 20
		System.out.printf("swap before : x=%d, y=%d\n", x, y);
		int temp = x;
		x = y;
		y = temp;		
		System.out.printf("swap after : x=%d, y=%d\n", x, y);
	}

} // class


/*
1조_연봉1조  		:  [팀장]이태규(*), 김지은(*), 설경인(*), 윤재민(*), 홍성철, 김동현, 박상범             		(화요일)
2조_귀염2(이)조 	: [팀장]하동호(*), 박진용(*), 이혜진(*), 김수민, 신희민, 진예림, 박현주                     	(수요일)
3조_자바를 잡아	: [팀장]박민종(*), 심성환(*), 이진우(*), 홍찬기(*), 김예지, 하지예 , 탁인혁              	(목요일)
 */

