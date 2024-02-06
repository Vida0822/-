package days05;

import java.util.Scanner;

/**
 * @author kenik
 * @date  2023. 2. 1. - 오전 11:12:58
 * @subject   Scanner 시험.
 * @content 
 *
 */
public class Ex02 {

	public static void main(String[] args) {
		// Scanner 
		// 이름(String), 나이(byte), 키(double), 성별(boolean) 입력받아서 출력.
		// > 이름:홍길동, 나이:20살, 키:178.89, 성별:남자/여자
		String name;
		byte age;
		double height;
		boolean gender;
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("> 이름, 나이, 키, 성별 입력 ? ");
		
		name =  scanner.next(); // String
		age =  scanner.nextByte();
		height = scanner.nextDouble();
		gender =  scanner.nextBoolean(); 
		//  홍길동 20 178.89 true
		System.out.printf(
				"> 이름:%s, 나이:%d살, 키:%.2f, 성별:%s \n"
				, name, age, height
				, gender ? "남자" : "여자"
				);

	} // main

} // class
