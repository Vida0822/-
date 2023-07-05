package days05;

import java.util.Scanner;

/**
 * @author dlsgu
 * @date 2023. 2. 1. 오후 12:22:59
 * @subject if elseif
 * @content
 */
public class Ex04_03 {

	public static void main(String[] args) {
		// [시험문제] if문을 사용해서 입력받은 국어 점수를
		//		등급(수, 우, 미, 양, 가)을 출력
		//		수: 90~100
		//		우: 80~89
		//		미: 70~79
		//		양: 60~69
		//		가: 0~59

		int kor;
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("> 국어 점수 입력 ? ");
		kor = scanner.nextInt();
		
		if (kor >= 0 && kor <= 100) {
			
			if (kor >= 90) {
				System.out.println("수");
			} else if (kor >= 80) {
				System.out.println("우");
			} else if (kor >= 70) {
				System.out.println("미");
			} else if (kor >= 60) {
				System.out.println("양");
			} else {
				System.out.println("가");
			}
		} else {
			System.out.println("국어점수를 잘못 입력했습니다 (0~100)");
		}
	}//main

}//class
