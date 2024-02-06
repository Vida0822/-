package days06;

import java.io.IOException;

/**
 * @author dlsgu
 * @date 2023. 2. 2. - 오후 2:05:20
 * @subject read() 함수
 * @content 
 *
 */
public class Ex02 {

	public static void main(String[] args) throws IOException {
		// 한 문자를 입력받아서 알파벳, 한글, 숫자, 특수문자( #, @,%, ! ) 출력
		
		// BufferedReader br =  new BufferedReader (new InputStreamReader (System.in));
		// Scanner scanner = new Scanner (System.in);
		
		int i;
		char one;
		System.out.print("> 한 문자 입력 ? ");
		
		// int read() [함수(메서드) 3가지]
		// 기능 - 표준입력함수
		// 매개변수 X
		// 리턴값 - 스트림의 끝: -1, 0~255 
		i = System.in.read(); // a 엔터 -> i = 97
		//System.out.printf("i = %d\n", i);
		
		one = (char)i;
		System.out.printf("one = '%c'\n", one);

	}//main

}//class
