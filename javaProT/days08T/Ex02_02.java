package days08;

/**
 * @author kenik
 * @date 2023. 2. 6. - 오후 12:52:11
 * @subject  정규표현식 예제
 * @content
 *
 */
public class Ex02_02 {

	public static void main(String[] args) {
		// [문제] 주민등록번호의  유효성 검사
		// 000000-0000000   총14자리
		// String rrn = "123456-1234567";
		
		//String regex = "[0-9][0-9][0-9][0-9][0-9][0-9]-[0-9][0-9][0-9][0-9][0-9][0-9][0-9]";
		
		// Invalid escape sequence (valid ones are  \b  \t  \n  \f  \r  \"  \'  \\ )
		// String regex = "\\d\\d\\d\\d\\d\\d-\\d\\d\\d\\d\\d\\d\\d";
		
		// X?  0,1
		// X*  0~여러번
		// X+ 1~여러번
		// X{n}  정확히 n번
		// X{n, } 적어도 n번
		// X{n, m}  n~m번
		/*
		 * String regex = "\\d{6}-\\d{7}"; 
		 * System.out.println( rrn.matches(regex) );
		 */
		// [문제] 우편번호( zipCode )  000-000 또는   00000
		/*
		String regex = "(\\d{3}-\\d{3}|\\d{5})";  
		System.out.println("123-123".matches(regex));   // true
		System.out.println("12345".matches(regex));       // true
		System.out.println("123456".matches(regex));     // false
		System.out.println("123-a56".matches(regex));   // false
		System.out.println("123-4567".matches(regex)); // false
		*/
		
		// [문제] 국어 점수 ( 0<=   <=100)의 유효성 검사를 정규표현식 사용해서 처리.
		// String regex = "\\d{1,3}";   // 101~999
		// String regex = "\\d{1,2}|100";   // 101~999
		String regex = "[1-9]?\\d|100";
		System.out.println(  "01".matches(regex) ); // false
		System.out.println(  "100".matches(regex) ); // t
		System.out.println(  "99".matches(regex) );   // t
		System.out.println(  "1a".matches(regex) );    // f
		System.out.println(  "101".matches(regex) );  // f
		System.out.println(  "-10".matches(regex) ); // f
		
		int n = Integer.parseInt("01");  //  "01" -> 1 형변환
		System.out.println( n );
		
		// [과제] 팀장 제출해 주세요.  ( 정규 표현식 )  검색해서 찾아서 공부 -> 설명적어서  제출.. 
		// 회원가입
		// 아이디 :  [            ][ 아이디 중복체크 버튼] 
		// 비밀번호 : [                               ]                       5~15, 대문자 1개 이상, 소문자 1개 이상, 숫자 1개 이상 , 특수문자(#!@&) 1개 이상

	} // main

} // class











