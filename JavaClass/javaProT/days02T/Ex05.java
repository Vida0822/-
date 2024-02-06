package days02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author kenik
 * @date  2023. 1. 27. - 오후 4:57:00
 * @subject   이름을 입력받아서 name 변수에 저장하고 출력.
 * @content       키보드로부터( 표준 입력 장치 )
 *
 */
public class Ex05 {

	public static void main(String[] args) throws IOException {
		// 5:10 수업시작~
		// 이름 저장하는 name 변수를 선언하고
		// "이창익" 초기화
		// "이름은 "이창익"입니다."  출력.
		String name;
		
		/*
		[키보드] -> System.in -> InputStreamReader -> BufferedReader
		                       byte                char 변환         -> String 변환
		*/      

		// Ctrl + Shift + O  import 문 ?
		BufferedReader  br = new BufferedReader( new InputStreamReader(System.in) );
		// JDK 1.5 ~ Scanner 클래스 
		
		System.out.print("> 이름을 입력하세요 ? ");
		// Unhandled exception type IOException
		name =  br.readLine();
		// Syntax error on token ""입니다."", delete this token
		
		// '\n'
		// '\"'
		System.out.printf("이름은 \"%s\'입니다.", name);
		
	} // main

} // class










//그러면 큰따움표 안에넣으면 인식이 안되나요?
		// Type mismatch: cannot convert from String to char
		// char one = "\u0061";
