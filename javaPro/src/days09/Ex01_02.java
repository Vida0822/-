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
public class Ex01_02 {

	public static void main(String[] args) {
		int [] m = {10,20};
		System.out.printf("x=%d, y=%d\n", m[0], m[1]);
		// 에러: The method swap(int, int) in the type Ex01_02 is not applicable for the arguments (int[])
		swap(m); // Call By Reference
		System.out.printf("x=%d, y=%d\n", m[0], m[1]);
	}//main

	private static void swap(int[] m) { // main 함수와 swap 함수의 배열이 같은 주소를 공유한다
		// [10][20]    [0x100번지]m		main 배열명 m
		// 0x100번지
		int temp;
		temp = m[0];
		m[0] = m[1];
		m[1] = temp;
		//				[0x100번지]m	swap 배열명 m
		
	}

	public static void swap(int x, int y) { // 지역 변수 int x = 10, y = 20
		int temp;
		temp = x;
		x = y;
		y = temp;
	}

}//class
