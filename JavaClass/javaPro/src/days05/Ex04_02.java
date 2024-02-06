package days05;

import java.util.Scanner;

/**
 * @author dlsgu
 * @date 2023. 2. 1. 오후 12:22:59
 * @subject if elseif
 * @content
 */
public class Ex04_02 {

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
		// 0~100 입력값에 대한 유효성 검사 (전공자)
		
		// if elseif -> 하나라도 만족하는거 있으면 바로 건너뜀
		if (kor >= 90 && kor <= 100) {
			System.out.println("수");
		} else if (kor >= 80 && kor <= 89) {
			System.out.println("우");
		} else if (kor >= 70 && kor <= 79) {
			System.out.println("미");
		} else if (kor >= 60 && kor <= 69) {
			System.out.println("양");
		} else { // 조건식 X -> 그 외의 모든 경우
			System.out.println("가");
		}
		
	}//main

}//class
