package days04;

/**
 * @author dlsgu
 * @date 2023. 1. 31. 오후 3:51:19
 * @subject
 * @content
 */
public class Ex10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] kors = null;
		// 오류: The local variable kors may not have been initialized -> 초기화가 되지 않았다
		// 오류: NullPointerException -> 기억공간에 Heap 영역 없는데 넣으려고 해서 발생하는 오류
		kors[0] = 90;
		
	}//main

}//class
