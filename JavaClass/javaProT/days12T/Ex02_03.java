package days12;

import java.util.Arrays;

/**
 * @author ♈ kenik
 * @date 2023. 2. 10. - 오전 10:49:27
 * @subject                배열 복사( copy )   
 * @content
 *
 */
public class Ex02_03 {

	public static void main(String[] args) {
		int [] m = { 76, 34, 10 };
		int [] temp = new int[ m.length + 3];
		// 2. 배열 복사
		// Arrays 클래스 ? 배열을 다루기 쉽도록 기능(함수)이 구현되어 있는 클래스.
		// Arrays.fill()
		// Arrays.toString()
		// Arrays.copyOf(null, 0);
		
		// 1. 기능 : System클래스 안에 배열을 복사하는 메서드
		// 2. 매개변수 :  src, srcPos, dest, destPos, length
		// 3. 리턴값( 리턴자료형 ) : void
		//System.arraycopy(src, srcPos, dest, destPos, length);
		System.arraycopy(  m , 0, temp , 0 , m.length );
		// System.out.println( Arrays.toString( temp ));
	    m =	temp;
	    System.out.println(  Arrays.toString(m));
	    
		// 1. 배열 복사 
		/*
		for (int i = 0; i < m.length; i++) {
			temp[i] = m[i];
		}
		m = temp;
		System.out.println(  Arrays.toString(m));
		*/

	} // main 

} // class








