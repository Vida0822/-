package days08;

import java.util.Scanner;

/**
 * @author dlsgu
 * @date 2023. 2. 6. 오전 11:40:16
 * @subject [제어문 활용]
 * @content 1. 다시 게임할거니 ? y -> 반복 / n -> 종료
 * 				1) 반복처리 해야할 부분이 어디인지
 * 			2. 입력값에 대한 유효성 검사
 */
public class Ex01_02 {

	public static void main(String[] args) {
		//days05.Ex06
		
		Scanner scanner = new Scanner(System.in);
		char con;//"y" -> 'y'
		int com, user;
		
		do {	
			com = (int)(Math.random()*3)+1;	
			
			String regex = "[1-3]";
			String sUser;
			
			boolean flag = false;
			do {
				System.out.print("> user 가위(1), 바위(2), 보(3) 선택 ? ");
				sUser = scanner.next();
				flag = sUser.matches(regex);
			} while (!flag);
			user = Integer.parseInt(sUser);
			System.out.printf("> com = %d, user = %d\n", com, user);

			switch (user - com) {
			case 0:
				System.out.println("무승부");
				break;
			case 1: case -2:
				System.out.println("사용자 승리");
				break;
			case -1: case 2:
				System.out.println("컴퓨터 승리");
				break;
			}//switch
			
			// 다시 게임할거니? y or n
			// y를 입력했을 때 다시 게임 처리 반복 for / while / [do~while] ***
			System.out.print("\n\t 다시 게임할거니 ? ");
			con = scanner.next().charAt(0);//"y" -> 'y'
			
		} while (con == 'Y' || con == 'y');

		System.out.println("게임 종료");

		/*
		Scanner scanner = new Scanner(System.in);
		System.out.print("> user 가위(1), 바위(2), 보(3) 선택 ? ");
		
		// scanner.nextInt() <- 'a' 오류 발생 / 4 오류 X -> 이상한 결과
		String input = scanner.next(); // "문자열"
		// 입력받은 문자열 속에 숫자가 아닌 문자가 있는지 체크
		// input.length() == 1 -> 문자열 길이 1
		boolean flag = false;
		/*
		if (input.length() == 1) {
			char ch = input.charAt(0);
			if ('1' <= ch && ch <= '3') {
				flag = true;
			}
		}
		
		char ch = input.charAt(0);
		if (input.length() == 1 && '1' <= ch && ch <= '3') {
			flag = true;
		}
		
		if (flag) {
			System.out.println("유효한 입력값 O");
		} else {
			System.out.println("유효한 입력값 X");
		}
		*/
		
	}//main

}//class
