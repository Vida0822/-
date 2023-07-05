package days27;

import java.io.PrintStream;

/**
 * @author dlsgu
 * @date 2023. 3. 6. 오후 4:45:55
 * @subject Piped[Reader] / Piped[Writer] - 쓰레드 간에 데이터를 주고 받을 때 사용하는 스트림 클래스
 * @content 
 * 			[표준 입출력 관련 스트림]
 * 			1) InputStream	InputStream		Systeam.in - 표준 입력 장치
 * 			2) PrintStream 	System.out		println()/print()/printf() - 표준 출력 장치
 * 			3) PrintStream	System.err								   - 표준 출력 장치
 */
public class Ex12 {

	public static void main(String[] args) {
		/*
		PrintStream ps = System.out;
		
		ps.println("홍길동");
		ps.printf("%s\n", "박현주");
		ps.print(false);
		*/
		
		System.out.println("A");
		System.out.println("B");
		System.out.println("C");
		System.out.println("D");
		System.out.println("E");
		System.out.println("F");
		
		// 화면(콘솔)에 출력 (반드시 마지막에 나오는건 아님)
		// 에러 메시지를 출력하는 스트림 객체 : err
		System.err.println("X");

	}//main

}//class
