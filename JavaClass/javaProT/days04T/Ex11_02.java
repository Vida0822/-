package days04;

import java.io.BufferedReader;
import java.util.Scanner;

/**
 * @author kenik
 * @date  2023. 1. 31. - 오후 4:51:50
 * @subject    Ex11.java 을  Scanner 클래스 사용해서 수정.  
 * @content 
 *
 */
public class Ex11_02 {

	public static void main(String[] args) {
		
		String name;
		int kor, eng, mat;    
	    int tot;  
	    double avg;
		
	    Scanner scanner = new Scanner(System.in);
	    
	    System.out.print("> 이름 국어 영어 수학 입력 ? ");  // 홍길동 90 87 77
	    name =  scanner.next();
	    kor =  scanner.nextInt();
	    eng =  scanner.nextInt();
	    mat =  scanner.nextInt();
	    
	    tot          =  kor + eng + mat;	     
	    avg = (double)tot / 3;  
	    
	    System.out.printf("이름은 %s이고, 국어=%d, 영어=%d, 수학=%d, 총점=%d, 평균=%f 이다."
	    		, name , kor , eng, mat, tot , avg );
	 

	} // main

} // class
