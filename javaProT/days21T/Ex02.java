package days21;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ♈ k§nik
 * @date 2023. 2. 23. - 오후 12:24:32
 * @subject 
 * @content 
 */
public class Ex02 {

	public static void main(String[] args) {
		/*
		 * 1. 정규표현식( Regular Expression ) == 정규식
		 *    - 정의 ? 텍스트 데이터 중에서 원하는 조건(패턴, pattern)과 일치하는 문자열을 
		 *                 찾아내기 위해 사용되는 것
		 *                 미리 정의된  기호와 문자를 이용해서 작성한 문자열 패턴.  \\.  {2}  ?  [0-9]
		 *     - 예) 비밀번호 : 숫자1, 알대1, 알소1, 특수문자1, 길이  8~15  
		 *     - 자바는 정규표현식 관련 클래스 
		 *        java.util.regex 패키지 안에 2개의 클래스가 있습니다.
		 *                        ㄴ Pattern 클래스
		 *                        ㄴ Matcher 클래스
		 *         
		 *     - boolean String.matches(String regex)              
		 * */ 
		String [] data = {"bat","baby","bonus","cA","ca","co", "c.", "c0", "car"
				                     , "combat", "count", "date", "disc", "fx"};
		// [ 정규표현식을 설명하세요 ]
		// String regex = "c[a-z]*";
		// String regex = "c[a-z]";
		// String regex = "c[a-zA-Z]";
		// String regex = "c[a-zA-Z0-9]";
		// String regex = "c\\w";
		// String regex = ".*";
		// String regex = "c.";
		// String regex = "c\\.";   //    \\[   escape 제외시킨다.
		// String regex = "c[0-9]";    //  "c\\d"
		// String regex = "c.*t";   // c 모든문자*.......  t
		//String regex = "[b|c]";
		// String regex = "[bc]";
		// String regex = "[b-c].*";
		// String regex = "[^bc].*";
		
		// String regex = ".*a.*"; // 위치에 상관없이  a 가  1개  포함된 문자열
		
		//  [질문] 첫번째 문자   알파벳대소문자   bcd 제외한  뒤에는 상관없다...
		// String regex = "[^bcd].*";
		
		//String regex = "[a-zA-Z].*";
		// String regex = "[ae-zA-Z].*";
		String regex = "[a-zA-Z&&[^b-d]].*";
		
		
		/*
		for (int i = 0; i < data.length; i++) {
			// true / false  data[i].matches(regex)
		}
		*/
		
		// 1. Pattern 객체 생성
		Pattern p = Pattern.compile(regex);
		// 2. matcher 객체 생성
		for (int i = 0; i < data.length; i++) {
			Matcher m = p.matcher(   data[i]   );
			if(    m.matches()  )  System.out.println( data[i] );
		} 
		
		 
		
	} // main

} // class








