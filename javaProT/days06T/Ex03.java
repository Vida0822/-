package days06;

/**
 * @author kenik
 * @date  2023. 2. 2. - 오후 2:46:16
 * @subject 9. 한 문자를 입력받아서 알파벳, 한글, 숫자, 특수문자( #, @,%, ! ) 출력
 * @content 
 *
 */
public class Ex03 {

	public static void main(String[] args) {
		// 알파벳 출력 ( 대, 소 )  
		//       ㄴ 대문자        'A' <=  ch &&  ch <= 'Z'
		//       ㄴ 소문자         'a' <=  ch &&  ch <= 'z'
		
		// short s = 65;     [][][][][][][][] [][1][][][][][][1]
		// char    A = 'A';    [][][][][][][][] [][1][][][][][][1]
		
		//for (int i = 65; i <= 90; i++) {
		for (int i = 'A' ; i <= 'Z' ; i++) {
			System.out.printf("'%c'(%d)" ,    (char)i, i);
		}
		System.out.println();  //개행
		for (int i = 'a' ; i <= 'z' ; i++) {
			System.out.printf("'%c'(%d)" ,    (char)i, i);
		}
		// 3:05 수업시작~~
		// 한글     '가' <=  ch &&  ch <= '힣'
		System.out.println();
		System.out.printf("'%c'(%d)" ,    '가', (int)'가');
		System.out.printf("'%c'(%d)" ,    '힣', (int)'힣');
		
		for (int i = '가' ; i <= '힣' ; i++) {
			System.out.printf("'%c'(%d)\n" ,    (char)i, i);
		}
		
		// 숫자  
		System.out.println();
		for (int i = '0' ; i <= '9' ; i++) {
			System.out.printf("'%c'(%d)" ,    (char)i, i);
		}
		// 특수문자

	} // main

} // class




