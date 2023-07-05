package days06;

import java.io.IOException;

/**
 * @author kenik
 * @date  2023. 2. 2. - 오후 1:57:53
 * @subject 
 * @content 
 *
 */
public class Ex02 {

	public static void main(String[] args) throws IOException {
		// 9. 한 문자를 입력받아서 알파벳, 한글, 숫자, 특수문자( #, @,%, ! )
		
		// BufferedReader br = new BufferedReader(new InputStreamReader( System.in ) );
		// Scanner scanner = new Scanner( System.in );
		int  i ;
		char one;
		System.out.print("> 한 문자 입력 ? ");
		
		// int read()  [함수(메서드)  3가지 ]
		// 1. 표준 입력 함수
		// 2. 매개변수 X
		// 3. 리턴값 : 스트림의 끝 : - 1 ,   0~255
		i = System.in.read();  // 'a' 엔터 -> i=97
		// System.out.printf("i = %d\n", i);
		
		one = (char)i;
		System.out.printf("one = '%c'\n", one);
		// Ex02_02.java
		
		

	} // main

} // class









