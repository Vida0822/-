package days12;

import java.io.IOException;
import java.util.Random;

/**
 * @author ♈ kenik
 * @date 2023. 2. 10. - 오전 10:02:26
 * @subject   정의, 선언, 생성, 초기화, 출력 등등
 * @content   변수, 참조변수, 배열명 
 *                       배열 단점 - 배열 크기 자동 증가/감소 X
 *                       
 *                       (시험1)
 */
public class Ex02 {

	public static void main(String[] args) throws IOException {
		// 10:14 수업 시작~ 
		// 제어문(for) + 배열
		Random rnd = new Random();
		// 0,1,2   - ArrayIndexOutOfBoundsException
		int [] m = new int[3];  // int의   기본값  0으로 자동 초기화..
		
		int idx = 0; // 시작 인덱스 : 0
		char con = 'y';
	   do {
		    m[idx++] =  rnd.nextInt(100);  // 0<=    int    <100 
		    System.out.printf("> 배열(%d) 계속 초기화할거니 ? ", idx);
		    con = (char)System.in.read();  // y n  Y  N
		    System.in.skip( System.in.available() );  // 13,  10 제거
	    //}  while (   con == 'y' || con == 'Y'  );        Ctrl + Alt + 방향키
	    }  while (   m.length != idx && Character.toUpperCase(con) == 'Y'   );
		

		disp(m);
	} // end of main 

	private static void disp(int[] m) {
		for (int i = 0; i < m.length; i++) {
			System.out.printf("m[%d]=%d\n", i, m[i]);
		}
	}

} // end of Class










