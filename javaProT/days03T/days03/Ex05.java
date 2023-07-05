package days03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author kenik
 * @date 2023. 1. 30. - 오후 3:52:05
 * @subject
 * @content 형변환, 표준입출력 
 *     4:03 수업 시작~ 
 *
 */
public class Ex05 {

	public static void main(String[] args) throws IOException {
		 // [이름, 국어, 영어, 수학]  입력받아서
		//  총점, 평균 계산
		//  "이름은 홍길동이고, 국어=90, 영어=89, 수학=78, 총점=???, 평균=??.?? 이다." 출력
		String name;
		byte kor, eng, mat;   // 0~100 정수
	    short tot;  // 0~300 정수
	    double avg;
	    
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    System.out.print("> 이름 입력 ? ");
	    name =  br.readLine();
	    
	    System.out.print("> 국어 입력 ? ");
	    // Type mismatch: cannot convert from String to byte
	    // byte = String
	    // readLine() 함수는 입력받은 값을 String(문자열)으로 반환하는 함수.
	    // 형 일치 코딩..
	    // "String -> byte 형 변환"
	    /*
	    String s =  br.readLine(); // "90"	    
	    kor = Byte.parseByte(s);
	    */
	    
	    // 기본형 byte -> 래퍼클래스 Byte.parseByte() 함수 (메서드)
	    //                 String -> byte 형변환	    
	    kor = Byte.parseByte(  br.readLine()  );	    
	    System.out.print("> 영어 입력 ? ");
	    eng = Byte.parseByte(  br.readLine()  );
	    System.out.print("> 수학 입력 ? ");
	    mat = Byte.parseByte(  br.readLine()  );
	    
	    // Type mismatch: cannot convert from int to short
	    // short = int
	    //           = 우측항 연산
	    //                 b  + b   + b
	    // CPU 처리 :  int 보다 작은 자료형은 int로 처리
	    // cast 연산자 사용해서 강제 형변환해야 된다. 
	    tot          = (short) (kor + eng + mat);
	    
	    // 이럴 경우가 프로그램작성 하다보면 강제로 형변환을 해야하는 경우 ~~~
	    avg = (double)tot / 3;  // 2.3333333  -> int -> 2 -> double 2.0
	    // java.util.[IllegalFormatConversionException]: d != java.lang.Double
	    //                잘못된 형식       Conversion 예외
	    //                                     %   d, f, c, b, s
	    // 1,2,4     -> 평균 2.333333333333333
	    //              -> 평균=2.000000
	    System.out.printf("이름은 %s이고, 국어=%d, 영어=%d, 수학=%d, 총점=%d, 평균=%f 이다."
	    		, name , kor , eng, mat, tot , avg );

	} // main

} // class










