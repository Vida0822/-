package days08;

import java.util.Scanner;

/**
 * @author kenik
 * @date 2023. 2. 6. - 오후 3:35:20
 * @subject   [문제]
 * @content
 *
 */
public class Ex03_04 {

	public static void main(String[] args) {
		// 국어, 영어, 수학               -> 총점, 평균         -> 출력
		// 각각의 점수를 입력받아서 유횽성 검사(0~100)를 마친 후 반환하는 getScore() 함수 선언 -> 호출.
		
		int kor, eng, mat;
		
		
		kor = getScore("국어");  // String 과목명을 매개변수 처리.
		eng = getScore("영어");
		mat = getScore("수학");		
		
		int tot = kor + eng + mat;		
		double avg = (double)tot/3;
		
		// 출력함수
		printScore(kor,eng,mat,tot,avg);
		
		

	} // main

	private static void printScore(int kor, int eng, int mat, int tot, double avg) {
		
		System.out.printf("kor=%d, eng=%d, mat=%d, tot=%d, avg=%.2f\n"
				                          ,kor, eng, mat, tot, avg );
		
	}

	private static int getScore( String subject ) {
		
		Scanner scanner = new Scanner(System.in);
		
		String score ;
		String scoreRegex = "[1-9]?\\d|100";
		
		do {
			System.out.print( subject +" 점수 입력 ? ");
			 score = scanner.next();
		} while ( !score.matches(scoreRegex) );
		
		return Integer.parseInt(score);
	}
 
	
} // class












