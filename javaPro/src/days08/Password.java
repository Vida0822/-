package days08;

import java.util.Scanner;

public class Password {

	public static void main(String[] args) {
		// [기본적인 정규표현식]
		// ^ 문자열의 시작
		// $ 문자열의 끝
		// . 임의의 문자
		// * 앞 문자가 없을수도 무한정 많을수도 있음
		// + 앞 문자가 하나 이상
		// ? 앞 문자가 없을수도 있고 하나 있을수도 있음
		// \s 공백문자
		// \w 알파벳이나 숫자
		// \d 숫자만
		// [] 문자의 집합이나 범위 [] 안의 ^는 !(not)의 의미
		// {} 횟수나 범위
		// () 그룹지정
		// | or 조건
		// ?= 뒤에 있는 조건을 만족해야 한다
		// .*[] 앞에 나온 조건으로 글자의 []안에 있는 것들 중 1개를 만족하는지 본다
		String passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[#@!&])[a-zA-Z\\d#@!&]{5,15}";
		// String idRegex = "[]"; // 아이디 중복체크를 위한 코딩 필요
		
		String id,password;
		Scanner scanner = new Scanner(System.in);
		boolean flag;
		
		// do {
			System.out.print("아이디를 입력해주세요 : ");
			id=scanner.next();
			// flag=id.matches(idRegex);
		// } while (!flag);

		do {
			System.out.print("비밀번호를 입력해주세요 : ");
			password=scanner.next();
			flag=password.matches(passwordRegex);
			if (!flag) System.out.println("형식이 올바르지 않습니다");
		} while (!flag);

		System.out.println("회원가입이 완료되었습니다!");
		System.out.printf("ID : [%s], PW : [%s]\n", id, password);
		
	}//main

}//class
