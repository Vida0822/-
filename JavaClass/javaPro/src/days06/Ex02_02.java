package days06;

import java.io.IOException;

/**
 * @author dlsgu
 * @date 2023. 2. 2. - 오후 2:05:20
 * @subject read() 함수
 * @content 
 *
 */
public class Ex02_02 {

	public static void main(String[] args) throws IOException {
		// 한 문자를 입력받아서 알파벳, 한글, 숫자, 특수문자( #, @,%, ! ) 출력
		
		int i;
		char one;
		
		// 1
		System.out.print("> 한 문자 입력 ? ");
		i = System.in.read();
		one = (char)i;
		System.out.printf("one = '%c'\n", one);
		
		// [97][13][10][][][][] 버퍼(Stream)
		/*
		System.in.read(); // 13 CR
		System.in.read(); // 10 LF
		*/
		//System.in.skip(2);
		System.in.skip(System.in.available()); // 버퍼(Stream) 비우기 [암기]
		
		// 2 원인파악 -> 해결
		System.out.print("> 한 문자 입력 ? ");
		i = System.in.read();
		one = (char)i;
		System.out.printf("one = '%c'\n", one);

		System.out.println("end");
		
	}//main

}//class
