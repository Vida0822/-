package days12;

import java.io.IOException;
import java.util.Random;

/**
 * @author ♈ kenik
 * @date 2023. 2. 10. - 오전 10:02:26
 * @subject   정의, 선언, 생성, 초기화, 출력 등등
 * @content   변수, 참조변수, 배열명 
 *                       배열 단점 - 배열 크기 자동 증가/감소 X
 *                        => 배열의 크기를 자동으로 증가 시키자.
 *                       (시험1)
 */
public class Ex02_02 {

	public static void main(String[] args) throws IOException {
	 
		Random rnd = new Random(); 
		int [] m = new int[3];
		// [43][91][98]                     [0x200] m
		//     배열복사
		// [43][91][98][][][]                        [0x200]temp
		// m = temp
		
		int idx = 0;  
		char con = 'y';
		
	   do {
		   
		   if( m.length == idx ) {
			   System.out.println("배열크기 3개 증가...");
			   /*
			   int [] temp = new int[ m.length + 3 ];
			   for (int i = 0; i < m.length; i++) {
				   temp[i] =m[i];
			  }
			   m = temp;
			   */
			   // System.arraycopy() 위의 코딩을 수정
			   int [] temp = new int[ m.length + 3 ];
			   System.arraycopy(  m , 0, temp , 0 , m.length ); 
			  m =	temp;
		   }
		   
		    m[idx++] =  rnd.nextInt(100);  
		    System.out.printf("> 배열(%d) 계속 초기화할거니 ? ", idx);
		    con = (char)System.in.read(); 
		    System.in.skip( System.in.available() );  
	    }  while (   Character.toUpperCase(con) == 'Y'   );
		

		disp(m);
	} // end of main 

	private static void disp(int[] m) {
		for (int i = 0; i < m.length; i++) {
			System.out.printf("m[%d]=%d\n", i, m[i]);
		}
	}

} // end of Class










