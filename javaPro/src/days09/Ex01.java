package days09;

/**
 * @author dlsgu
 * @date 2023. 2. 7. 오전 9:18:45
 * @subject 함수(메서드) + 매개변수 -> 호출방법
 * @content 1) Call By Name			이름 -> 매개변수 없이 함수명만 가지고 호출하는 것
 * 			2) Call By Value		값 -> 기억 공간에 있는 값이 넘어가는 것
 * 			3) Call By Point		X
 * 			4) Call By Reference	참조형(배열,클래스,인터페이스)
 */
public class Ex01 {

	public static void main(String[] args) {

		int x = 10, y = 20; // 지역 변수
		System.out.printf("x=%d, y=%d\n", x, y);
		// x, y 두 기억공간의 값을 바꾸기(교환) - swap
		/*
		int temp;
		temp = x;
		x = y;
		y = temp;
		*/
		// 두 기억공간의 값을 바꾸는 swap() 함수를 1)선언 + 2)호출
		// 1)기능 swap 2) 매개변수 x, y 3) 리턴값 void
		swap(x,y); // Call By Value
		System.out.printf("x=%d, y=%d\n", x, y);
	}//main
	// 왜 x, y 교환 X -> 해결
	// 함수 선언부
	public static void swap(int x, int y) { // 지역 변수
		int temp;
		temp = x;
		x = y;
		y = temp;
	}

}//class
