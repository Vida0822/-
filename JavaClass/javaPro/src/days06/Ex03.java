package days06;

/**
 * @author hyejin
 * @date 2023. 2. 2. - 오후 2:46:20
 * @subject 
 * @content 
 *
 */
public class Ex03 {

	public static void main(String[] args) {
		// 알파벳 출력 (대, 소)
		// 대문자	'A' <= ch && ch <= 'Z'
		// 소문자	'a' <= ch && ch <= 'z'
		//for (int i = 65; i <=90; i++) {
		for (int i = 'A'; i <='Z'; i++) {
			System.out.printf("'%c'(%d)", (char)i, i);
		}
		System.out.println(); //개행
		for (int i = 'a'; i <='z'; i++) {
			System.out.printf("'%c'(%d)", (char)i, i);
		}
		
		// 한글 '가' <= ch && ch <= '힣'
		System.out.println(); //개행
		System.out.printf("'%c'(%d)", '가', (int)'가');
		System.out.printf("'%c'(%d)", '힣', (int)'힣');
		
		// 숫자 '0' <= ch && ch <= '9'
		System.out.println(); //개행
		for (int i = '0'; i <='9'; i++) {
			System.out.printf("'%c'(%d)", (char)i, i);
		}
		// 특수문자
		

	}//main

}//class
