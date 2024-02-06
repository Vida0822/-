package days11;

/**
 * @author kenik
 * @date 2023. 2. 9. - 오전 7:03:10
 * @subject
 * @content
 *
 */
public class Ex01 {

	public static void main(String[] args) {
		// [문제]
		// 10진수 정수(int)를 입력받아서 10
		// 2바이트 2진수 형태로 출력 00000000 000010[1][0]
		
		int n = 10;
		
		// int []  m =  [][][][][][][][][][][1][0][1][0]
		// 방법 3  - 제어문 사용..
		int 몫, 나머지;
		
		String b = "";
		while( n != 0) {
			몫 = n/2;
			나머지 = n%2;
			// System.out.printf("[%d]", 나머지);
			b += 나머지;
			n =  몫;
		} // 
		// [0][1][0][1]        => 1010
	    System.out.println(b);  // "0101"  문자열 reverse 기능
	    
	    String rb = "";
	    for (int i = b.length()-1; i >=0 ; i--) {
		    System.out.println(  b.charAt(i));
		    rb += b.charAt(i);
		}
		System.out.println( rb );
		/*
		int 몫 = n/2;       // 5
		int 나머지 = n%2;  // 0
		
		n = 몫;            // 5
		몫 = n/2;        // 2
		나머지 = n%2;  // 1
		
		n = 몫;            // 2
		몫 = n/2;        // 1
		나머지 = n%2;  // 0
		
		n = 몫;            // 1
		몫 = n/2;        // 0
		나머지 = n%2;  // 1
		
		중단~
		*/
		
		// 방법 2
		/*
		String binaryN =  Integer.toBinaryString(n);  // "1010";
		// System.out.printf("%016d\n", n);               %d  10진수 정수값만 출력		
		System.out.printf( "%016d\n" , Integer.parseInt( binaryN ));
		*/
		
		/* 방법 1
		String binaryN =  Integer.toBinaryString(n);  // "1010";
		int zeroCount = 16- binaryN.length();  // 4
		// ***  String.repeat( 갯수 )  ***
		System.out.printf( "%s%s" , "0".repeat(zeroCount) , binaryN );
		*/
		 
		/*
		System.out.println( Integer.toBinaryString(n) );
		System.out.println( Integer.toOctalString(n) );
		System.out.println( Integer.toHexString(n) );
		*/

	} // end of main

} // end of class

/*
 * 1조_연봉1조 : [팀장]이태규(*), 김지은(*), 설경인(*), 윤재민(*), 홍성철, 김동현, 박상범 (화요일)
 * 2조_귀염2(이)조  : [팀장]하동호(*), 박진용(*), 이혜진(*), 김수민, 신희민, 진예림, 박현주 (수요일)
 * 3조_자바를 잡아 : [팀장]박민종(*), 심성환(*), 이진우(*), 홍찬기(*), 김예지, 하지예 , 탁인혁 (목요일)
 */




