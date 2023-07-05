package days21;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * @author dlsgu
 * @date 2023. 2. 23. 오전 10:45:18
 * @subject
 * @content
 */
public class Ex02 {

	public static void main(String[] args) {
		/*
		 * 1. 정규표현식 (Regular Expression) == 정규식
		 * 	- 정의 : 텍스트 데이터 중에서 원하는 조건(패턴, pattern)과 일치하는 문자열을 찾아내기 위해 사용되는 것
		 * 			 미리 정의된 기호와 문자를 이용해서 작성한 문자열 패턴 ex) \\. {2} ? [0-9]
		 * 	- ex) 비밀번호 : 숫자1, 알대1, 알소1, 특수문자1, 길이 8~15
		 *  - 자바는 정규표현식 관련 클래스
		 *    java.util.regex 패키지 안에 2개의 클래스가 있습니다
		 *    			ㄴ Pattern 클래스
		 *    			ㄴ Matcher 클래스
		 *    
		 *	- boolean String.matches(String regex)
		 * */
		String [] data = {"bat","baby","bonus","cA","ca","co", "c.", "c0", "car", "combat", "count", "date", "disc"};

		String regex = "c[a-z]*"; // c + 소문자 0 ~ 여러개
		// String regex = "c[a-z]"; c + 소문자
		// String regex = "c[a-zA-Z]"; c + 소문자, 대문자
		// String regex = "c[a-zA-Z0-9]"; c + 소문자, 대문자, 숫자 1개 == c\\w
		// String regex = ".*"; 모든 문자 0 ~ 여러개
		// String regex = "c."; c + 모든 문자
		// String regex = "c\\."; c + .
		// String regex = "c[0-9]"; c + 숫자 == c\\d
		// String regex = "c.*t"; c + 모든 문자 0 ~ 여러개 + t
		// String regex = "[b|c]"; b or c == [bc] == [b-c]
		// String regex = "[b-c].*"; b or c + 모든 문자 0 ~ 여러개
		// String regex = "[^bc].*"; not b or not c + 모든 문자 0 ~ 여러개
		// String regex = ".*a.*"; 위치에 상관없이 a가 1개 이상 포함된 문자열
		// String regex = ".+a.+"; a가 중간에 포함된 문자열
		// String regex = "[ae-zA-Z].*"; 첫번째 문자 알파벳 대소문자 bcd 제외한 뒤에는 상관은 없다
		// String regex = "[a-zA-Z&&[^b-d]].*"; 첫번째 문자 알파벳 대소문자 bcd 제외한 뒤에는 상관은 없다
		
		/*
		for (int i = 0; i < data.length; i++) {
			// true / false <- data[i].matches(regex)
		}
		*/
		
		// 1. Pattern 객체 생성
		Pattern p = Pattern.compile(regex);
		// 2. matcher 객체 생성
		for (int i = 0; i < data.length; i++) {
			Matcher m = p.matcher(data[i]);
			if (m.matches()) System.out.println(data[i]);
		}
		
	}//main

}//class
