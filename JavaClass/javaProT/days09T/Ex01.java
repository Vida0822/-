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
public class Ex01 {

	public static void main(String[] args) {
		// 9:30 제출
		int x = 10, y = 20;  // 지역변수
		System.out.printf("x=%d, y=%d\n", x, y);
		
		// x,y 두 기억공간의 값을 바꾸기(교환) - swap
		/*
		{
			int temp = x;
			x = y;
			y = temp;
		}
		*/
		// 두 기억공간의 값을 바꾸는 swap() 함수를 1) 선언 + 2) 호출
		// 1) 기능 swap 2) 매개변수 x, y 3) 리턴값  void
		swap( x, y );  // 함수 호출부              Call By Value

		System.out.printf("x=%d, y=%d\n", x, y);
	} // main

	// 왜 이유? x,y 교환 X -> 해결
	// 함수 선언부
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

