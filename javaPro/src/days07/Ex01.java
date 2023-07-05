package days07;

import java.util.Scanner;

/**
 * @author dlsgu
 * @date 2023. 2. 3. 오전 10:51:59
 * @subject
 * @content
 */
public class Ex01 {

	public static void main(String[] args) {
		//[문제] 한 라인에 10개씩 출력하도록 코딩하세요 [시험문제]
		//[추가문제] 각 라인 앞에 라인번호를 붙이고자한다
		
		/*
		int count = 0;
		for (int i = 0; i < 256; i++) {
			count++;
			System.out.printf("[%c]", (char)i);
			if (count == 10) {
				System.out.println();
				count = 0;
			}
		}
		*/
		
		/*
		for (int i = 0; i < 26; i++) {
			for (int j = 0; j < 10; j++) {
				System.out.printf("[%c]", (char)(10*i+j));
			}
				System.out.println();				
		}
		*/
		
		/*
		for (int i = 0; i < 256; i++) {
			if (i % 10 == 0) {
				System.out.printf("%d:",i/10+1);
			}
			System.out.printf("[%c]", (char)i);
			if (i % 10 == 9) {
				System.out.println();				
			}
		}
		*/
		
		/*
		int count = 2;
		System.out.printf("%d:",1);
		for (int i = 0; i < 256; i++) {
			System.out.printf("[%c]", (char)i);
			if (i % 10 == 9) {
				System.out.println();	
				System.out.printf("%d:",count);
				count++;
			}
		}
		*/
		
		int lineNumber = 1;
		for (int i = 0; i < 256; i++) {
			if (i % 10 == 0) {
				System.out.printf("%d:",lineNumber++); // 출력시키고 나서 증가시킨다: 후위형 증감연산자
				//lineNumber++;
			}
			System.out.printf("[%c]", (char)i);
			if (i % 10 == 9) {
				System.out.println();				
			}
		}
		
		
	}//main

}//class