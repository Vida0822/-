package days04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author kenik
 * @date  2023. 1. 31. - 오후 4:07:25
 * @subject 
 * @content 
 *
 */
public class Ex11 {

	public static void main(String[] args) throws IOException {
		// [days03.Ex05.java  복사 + 붙이기]
		// 이름, 국어,영어,수학을 입력
		// 총점, 평균
		// 형식 출력...
		// 이름="홍길동",국어=89,영어=78,수학=90,총점=257,평균=85.67
		String name;
		int kor, eng, mat;    
	    int tot;  
	    double avg;
	    
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    System.out.print("> 이름, 국어, 영어, 수학 입력 ? "); // "홍길동, 89, 78, 90"    엔터
	    String input = br.readLine();  // toggle(토글) breakpoint(중단점)  디버깅~   F11	    
	    // System.out.println( "> input : " +   input );
	    
	    // "홍길동, 89, 78, 90"     콤마 "구분자로  문자열 잘라내기"    String []  split( 구분자 ) 함수	    
	    String []  datas =  input.split(",");
	    
	    name =  datas[0]; // "홍길동"
	    kor =  Integer.parseInt(  datas[1].trim()  )  ; //  "98"  String -> int 형변환
	    eng =  Integer.parseInt(  datas[2].trim()  )  ; //  "98"  String -> int 형변환
	    mat =  Integer.parseInt(  datas[3].trim()  )  ; //  "98"  String -> int 형변환 
	    
	    // "홍길동"  name 변수 저장
	    // "_98"   문자열 공백 제거  "98"  -> 98 형변환   kor 변수 저장
	    // "_78"   문자열 공백 제거  "78"  -> 78 형변환    eng 변수 저장
	    // "_90"   문자열 공백 제거  "90"  -> 90 형변환  mat 변수 저장 
	   
	  
	    tot          =  kor + eng + mat;	     
	    avg = (double)tot / 3;  
	    
	    System.out.printf("이름은 %s이고, 국어=%d, 영어=%d, 수학=%d, 총점=%d, 평균=%f 이다."
	    		, name , kor , eng, mat, tot , avg );
	 

	} // main

} // class










