package days19;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author dlsgu
 * @date 2023. 2. 21. 오전 10:14:43
 * @subject [메서드에 예외 선언하기]
 * @content
 */
public class Ex03_02 {

	public static void main(String[] args) {

		try {
			int kor = getScore();
			System.out.println(kor);			
		} catch (InputMismatchException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
		}
		
		System.out.println("end");

	}// main
	
	public static int getScore() throws ScoreOutOfBoundException {
		Scanner scanner = new Scanner(System.in);
		int score;
		
		System.out.print("> 점수 입력 ? ");
		String input = scanner.next();
		String regex = "100|[1-9]?\\d"; // 0~100
		if (input.matches(regex)) {
			score = Integer.parseInt(input);
			return score;
		} else {
			// 강제로 예외를 발생시키자
			// 			"입력 불일치 예외"
			throw new ScoreOutOfBoundException(1001, "점수 범위(0~100) 벗어났다");
		}
	}

}//class

// 사용자가 정의하는 예외 클래스
class ScoreOutOfBoundException extends Exception {

	public ScoreOutOfBoundException(String message) {
		super(message);
		this.ERROR_CODE = 1000;
	}

	// 예외 코드 번호 필드
	private final int ERROR_CODE;
	
	public int getERROR_CODE() {
		return this.ERROR_CODE;
	}
	
	public ScoreOutOfBoundException(int errorCode, String message) {
		super(message);
		this.ERROR_CODE = errorCode;
	}
	
}


