package days11;

/**
 * @author dlsgu
 * @date 2023. 2. 9. - 오후 4:46:02
 * @subject 배열 + 제어문
 * @content 
 *
 */
public class Ex05_02 {

	public static void main(String[] args) {
		int [] m = new int[3]; // new -> Heap이라는 동적영역에 int 3개를 만들어라
		m[0] = 100;
		m[1] = 50;
		
		m = null; // 이 코딩의 의미
		
		m = new int[10];
		
		disp(m); // Call By Reference
		// + m = null;
		// NullPointerException -> 값을 못읽어온다
		
		// Heap 영역 [][][] -> 가비지(쓰레기) -> 껐다 켜야 사라짐
		// 자바 : GC(가비지 컬렉터) - 자동으로 메모리 관리(자바 특징)
		//		   Heap(동적영역)의 가비지가 가득 차면 Heap 메모리 제거

	}//main

	private static void disp(int[] m) {
		for (int i = 0; i < m.length; i++) {
			System.out.printf("m[%d]=%d\n", i, m[i]);
		}
		
	}

}//class
