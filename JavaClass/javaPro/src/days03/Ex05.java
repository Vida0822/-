package days03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author dlsgu
 * @date 2023. 1. 30. 오후 3:52:21
 * @subject 형변환, 표준입출력 [시험문제]
 * @content 
 */
public class Ex05 {

	public static void main(String[] args) throws IOException {
		// [이름, 국어, 영어, 수학] 입력 받아서
		// 총점, 평균 계산
		// "이름은 홍길동이고, 국어=90, 영어=89, 수학=78, 총점=???, 평균=??.??이다." 출력
		
		String name;
		byte kor, eng, mat; // 0~100 정수
		short tot; // 0~300 정수
		double avg;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("> 이름 입력 ? ");
		name = br.readLine();
		
		System.out.print("> 국어 입력 ? ");
		// Type mismatch: cannot convert from String to byte
		// byte = String
		// readline() 함수는 입력받은 값을 String(문자열)으로 반환하는 함수
		// 형 일치 코딩 필요
		// String -> byte 형변환 필요
		// String s = br.readLine(); //"90"
		// kor = Byte.parseByte(s);
		// 기본형 byte -> 래퍼클래스 Byte
		kor = Byte.parseByte(br.readLine());
		
		System.out.print("> 영어 입력 ? ");
		eng = Byte.parseByte(br.readLine());
		
		System.out.print("> 수학 입력 ? ");
		mat = Byte.parseByte(br.readLine());
		
		// 에러 - Type mismatch: cannot convert from int to short
		// short = int
		//         = byte + byte + byte
		// CPU 처리: int보다 작은 자료형은 int로 처리
		// cast 연산자(short) 사용해서 강제 형변환 해야한다.
		tot = (short)(kor + eng + mat);
		
		// 프로그램을 작성하다보면 강제로 형변환을 해야하는 경우
		avg = (double)tot / 3; // short / int -> int (소수점 다 날아간다)
		
		// 에러: java.util.IllegalFormatConversionException: d != java.lang.Double -> 잘못된 형식 Conversion 예외
		// 평균 %d -> %f
		System.out.printf("이름은 %s이고, 국어=%d, 영어=%d, 수학=%d, 총점=%d, 평균=%f이다.", name, kor, eng, mat, tot, avg);

	}//main

}//class
