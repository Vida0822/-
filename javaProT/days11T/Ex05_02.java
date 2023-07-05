/**
 * 
 */
package days11;

/**
 * @author kenik
 * @date  2023. 2. 9. - 오후 4:45:55
 * @subject   
 * @content 
 *
 */
public class Ex05_02 {
 
	public static void main(String[] args) {
		
		int [] m = new int[3];
        m[0] = 100;
        m[1] = 50;
		
        m = null; // 이 코딩의 의미 
        
        m = new int[10];
        
		disp(m); // Call By Reference
		// NullPointerException

		// [][][]
		// 가비지(쓰레기)
		// 자바 :  GC -  자동으로 메무리 관리( 자바 특징 )
		//            동적영역(Heap)의 가비지가 가득차면 언젠?  힘 메모리 제거.
		
	} // end of main
 
	private static void disp(int[] m) {
		 for (int i = 0; i < m.length; i++) {
			System.out.printf("m[%d]=%d\n", i, m[i]);
		}		 
	}

} // end of class








