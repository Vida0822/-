package days04;

/**
 * @author kenik
 * @date  2023. 1. 31. - 오전 11:50:28
 * @subject    2) 다른 수식이나 메서드의 매개변수로 사용될 때
 * @content 
 *
 */
public class Ex03_03 {
	
	public static void main(String[] args) {
		// 12:03 수업 시작~~ 
		int x = 10;
		
		//연산자 우선 순위 :  ++   >   =
		int y =  ++x;  // 전위형         > x = 11, y = 11 
		// int y =  x++;  // 후위형     > x = 11, y = 10 
		
		System.out.printf("> x = %d, y = %d \n", x, y);
		
		// while( x++ < y ){}   x, y  비교 먼저 한 후에 x 1증가 
		// while( ++x < y ){}   x 1증가 후에 비교
		

	} // main

} // class



