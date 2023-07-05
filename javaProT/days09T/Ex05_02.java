package days09;

/**
 * @author kenik
 * @date  2023. 2. 7. - 오후 4:26:06
 * @subject 
 * @content  String.substring() 함수(메서드)
 *    1. 기능
 *    2. 매개변수
 *    3. 리턴값, 리턴자료형
 *
 */
public class Ex05_02 {

	public static void main(String[] args) {
		String rrn = "830412-1700001";
		// 1. System.out.println("830412-*******"); 
		
		//String rrn.substring(beginIndex)
		//String rrn.substring(beginIndex, endIndex)
		
		System.out.println( rrn.substring(0, 7) + "*******");
		 
		// 2. System.out.println("830412-1******");
		System.out.println( rrn.substring(0, 8) + "******");
		
		// 5:00 수업시작~ (10분)
	} // main

} // class










