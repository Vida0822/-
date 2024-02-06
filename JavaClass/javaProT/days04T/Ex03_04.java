package days04;

/**
 * @author kenik
 * @date  2023. 1. 31. - 오후 12:13:47
 * @subject     쉬프트(shift) 연산자  >>   >>>   <<
 * @content    (비트 연산자)
 *                       shift == 교대하다. 
 *
 */
public class Ex03_04 {

	public static void main(String[] args) {
		System.out.println(   15 >> 2 );   // 첫 부호 비트 1  모두 1,    0  모두 0 
		System.out.println(   15 >>> 2 );  // 무조건 0 으로 채우겠다.
		System.out.println(   15 << 2 );  // 60=32+16+8+4
		
		// 15      0000 1111 >> 2   
		//           000000 11     3
		
		
		// 15      0000 1111 << 2   무조건 0으로 채운다.
		//          00 111100

	}

}
