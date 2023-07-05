package days08;

import java.util.Scanner;

/**
 * @author dlsgu
 * @date 2023. 2. 6. 오후 12:41:42
 * @subject
 * @content
 */
public class Ex02 {

	public static void main(String[] args) {
		// [문제] 정규표현식 (String.matches() 사용)
		// 등급을 나타내는 한 문자를 입력받아서 수,우,미,양,가 일 경우에는 올바른 입력 출력
		// 잘못된 입력일 경우에는 do~while문 사용해서 다시 등급을 입력 받도록
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("> 등급을 입력하세요 ? ");
		String grade = scanner.next();
		String regex = "[수우미양가]";
		grade.matches(regex);
		
		System.out.println(grade);

	}//main

}//class
