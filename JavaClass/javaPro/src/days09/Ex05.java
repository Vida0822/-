package days09;

/**
 * @author dlsgu
 * @date 2023. 2. 7. 오후 4:26:43
 * @subject String.substring() 함수(메서드)
 * @content 1. 기능
 * 			2. 매개변수
 * 			3. 리턴값, 리턴자료형
 */
public class Ex05 {

	public static void main(String[] args) {
		String rrn = "830412-1700001";
		
		// rrn.substring(beginIndex);
		// rrn.substring(beginIndex, endIndex);
		
		// 1. System.out.println("830412-*******");
		System.out.println(rrn.substring(0, 7) + "*******");
		// 2. System.out.println("830412-1******");
		System.out.println(rrn.substring(0, 8) + "******");

	}//main

}//class
