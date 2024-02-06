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
public class Ex03 {

	public static void main(String[] args) {
		// 메서드 선언 + 예외
		// method1 메서드 내에서 발생할 수 있는 예외들을 throws문을 사용해서 선언한다
		// void method1() throws E1, E2... {
		// }
		
		/*
		try {
			System.in.read();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		*/
		
		try {
			int kor = getScore(); // 메서드를 호출하는 곳에서 예외처리를 해야한다
			System.out.println(kor);			
		} catch (InputMismatchException e) {
			// e.printStackTrace;
			System.out.println(e.getMessage());
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		System.out.println("end");

	}// main
	
	// 0~100 점수를 입력받아서 반환하는 메서드 getScore()
	public static int getScore() throws InputMismatchException {
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
			throw new InputMismatchException("점수 범위(0~100) 벗어났다");
		}
	}

}//class
