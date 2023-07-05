package days05;

import java.util.Scanner;

/**
 * @author dlsgu
 * @date 2023. 2. 1. 오전 11:12:20
 * @subject Scanner [시험문제]
 * @content
 */
public class Ex02 {

	public static void main(String[] args) {
		// Scanner
		// 이름(String), 나이(byte), 키(double), 성별(boolean) 입력받아서 출력
		
		String name;
		byte age;
		double height;
		boolean gender;
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("> 이름, 나이, 키, 성별 입력 ? ");
		name = scanner.next(); // next() - String(문자열)을 읽어나가는 변수
		age = scanner.nextByte(); // next자료형() - 해당 자료형을 읽어나가는 변수
		height = scanner.nextDouble();
		gender = scanner.nextBoolean();
		
		// 홍길동 20 178.89 true
		System.out.printf("> 이름: %s, 나이: %d살, 키: %.2f, 성별: %s\n", name, age, height, gender ? "남자" : "여자");

	} // main

} // class
