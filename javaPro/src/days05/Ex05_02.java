package days05;

import java.util.Scanner;

/**
 * @author dlsgu
 * @date 2023. 2. 1. 오후 2:47:26
 * @subject
 * @content
 */
public class Ex05_02 {

	public static void main(String[] args) {
		// [시험문제] switch문을 사용해서 수우미양가 출력
		
		int kor;
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("> 국어 점수 입력 ? ");
		kor = scanner.nextInt();
		
		// key: 변수, 수식
		// value: 변수X, 리터럴
		// switch문에 break문이 필수 사항은 아니다 - 제어문 빠져나가는 역할
		char grade;
		grade = ' ';
		if (kor >= 0 && kor <= 100) {
			switch (kor / 10) {
			case 10:
			case 9:
				grade = '수';
				break;
			case 8:
				grade = '우';
				break;
			case 7:
				grade = '미';
				break;
			case 6:
				grade = '양';
				break;
			default:
				grade = '가';
				break;
			}//switch
			System.out.println(grade);	
		} else {
			System.out.println("입력을 잘못했습니다(0~100)");
		}//if

	}//main

}//class
