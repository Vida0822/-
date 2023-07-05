package days14;

/**
 * @author ♈ k§nik
 * @date 2023. 2. 14. - 오후 12:47:08
 * @subject 
 * @content 
 */
public class Ex05 {

	public static void main(String[] args) {
		int x = 100;
		plus( x );  // Call By Value
		System.out.printf("x = %d\n", x );  // x = 100

	} // main

	private static void plus(int x) {  // x = 300;
		x += 200;		
	}

} // class






/*
 *  오전 수업 내용
 * 1. OOP , OOP 특징
 * 2. 객체, 클래스, 인스턴스 
 * 3. 인스턴스화 
 * 4. 클래스의 구성 요소
 *     ㄱ. 필드
 *     ㄴ. 메서드
 * 5. 클래스 앞에 붙는  modifiers(  접근지정자, 기타제어자 )  설명
 * 6. 클래스 설계 과정    
 * */


