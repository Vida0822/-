package days14;

public class Ex03_02 {

	public static void main(String[] args) {
		// 배열 ( 참조타입 ) 
		/*
		 *   스택                                힙
		 *   
		 *    [0x100번지]               [][100][][][][][][][][]
		 *                                        0x100번지
		 *        m
		 * */ 
		int [] m = null;
		m = new int[10];
		
		m[1] = 100;   // NullPointerException
		
		System.out.println(  m[1] );

	}

}
