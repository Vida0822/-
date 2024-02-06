package days08;

import java.util.Scanner;

/**
 * @author dlsgu
 * @date 2023. 2. 6. 오후 3:50:32
 * @subject 함수 선언 연습 -> 함수 호출 사용
 * @content
 */
public class Ex04 {

	public static void main(String[] args) {
		// 년도를 입력받아서 윤년/평년을 체크해서 출력
		/*
		 * 1. 년도 입력받아서 반환하는 함수
		 * 2. 윤년: 오차를 보정하기 위해 삽입하는 날이나 주, 달이 들어가는 해를 말한다
		 * 	  치윤법: 삽입하는 달을 정하는 방법(오차보정)
		 * 	  윤년: 한국력 = 그레고리력 2월 29일이 있는 해
		 * 	  평년: 윤년이 아니면 평년
		 * 
		 * 	  [치윤법]
		 * 	  1년 365.2425일 [오차 0.003일] 보정
		 * 	  1) 서력 기원 연수가 4로 나누어 떨어지는 해는 우선 윤년으로 하고
		 * 	  2) 그 중에서 100으로 나누어 떨어지는 해는 평년으로 하며
		 * 	  3) 다만 400으로 나누어 떨어지는 해는 다시 윤년으로 정하였다
		 * 
		 * 	  년도를 매개변수로 윤년/평년을 반환하는 함수
		 * 3. 출력
		 * */

		int year = getYear();
		
		// 함수
		// 1. 기능: 윤년, 평년인지 체크해주는 함수 isLeapYear()
		// 2. 매개변수: 체크할 년도 int year
		// 3. 리턴값: 윤년(true), 평년(false) / 리턴자료형: boolean
		boolean check = isLeapYear(year);
		
		if (isLeapYear(year)) {
			System.out.println("윤년(leap year)");
		} else {
			System.out.println("평년(common year)");
		}

	}//main

	public static boolean isLeapYear(int year) {
		 //* 	  [치윤법]
		 //* 	  1년 365.2425일 [오차 0.003일] 보정
		 //* 	  1) 서력 기원 연수가 4로 나누어 떨어지는 해는 우선 윤년으로 하고	year%4==0
		 //* 	  2) 그 중에서 100으로 나누어 떨어지는 해는 평년으로 하며			year%100==0
		 //* 	  3) 다만 400으로 나누어 떨어지는 해는 다시 윤년으로 정하였다		year%400==0		
		return year % 4 == 0 && year % 100 != 0 || year % 400 == 0; // 연산자 우선순위: && > ||
	}

	public static int getYear() {
		Scanner scanner = new Scanner(System.in);

		String year;
		String yearRegex = "\\d+"; // 정수 1자리 이상

		do {
			System.out.print("년도 입력 ? ");
			year = scanner.next();
		} while (!year.matches(yearRegex));

		return Integer.parseInt(year);
	}

}//class
