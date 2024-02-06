package days06;

import java.io.IOException;

/**
 * @author kenik
 * @date  2023. 2. 2. - 오후 1:57:53
 * @subject 
 * @content 
 *
			> 한 문자 입력 ? a 엔터
			one='a' 
			> 한 문자 입력 ? b 엔터
			one='b' 
 */
public class Ex02_02 {

	public static void main(String[] args) throws IOException {
		
		int  i ;
		char one;
		// 'a'      엔터 ( "\r\n" )
		// [97][13][10][][][][] 버퍼(Stream)
		
		//          CR   LF
		// 1
		System.out.print("> 한 문자 입력 ? "); 
		i = System.in.read();   
		one = (char)i;
		System.out.printf("one = '%c'\n", one); 
		//System.out.printf("i = %d\n", i); 
		
		// [97][13][10][][][][] 버퍼(Stream)
		/*
		System.in.read(); // 13
		System.in.read(); // 10
		*/
		
		// System.in.skip(2);
		System.in.skip(   System.in.available()  );  // (암기)
		 
		// 2.  원인 파악 -> 해결
		System.out.print("> 한 문자 입력 ? "); 
		i = System.in.read();   
		one = (char)i;
		System.out.printf("one = '%c'\n", one);
		//System.out.printf("i = %d\n", i); 
		
		 
		System.out.println(" end ");
	} // main

} // class









