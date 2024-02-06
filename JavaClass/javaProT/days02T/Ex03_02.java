package days02;

/**
 * @author kenik
 * @date  2023. 1. 27. - 오후 2:45:15
 * @subject  기본형 - boolean(1) 설명
 * @content 
 *
 */
public class Ex03_02 {

	public static void main(String[] args) {
		// 예)  성별을 저장할 변수 선언  ( 남 true, 여 false )
		//   1 / 0		            int gender = 0;
		// "남자"/"여자"		String gender = "남자";
		
		// 자료형 변수명 [= 초기값];
		boolean  gender = true;
		gender = false;
		// Type mismatch: cannot convert from int to boolean
		//gender = 1;
		
		// String -> %s   %S
		// int       -> %d
		// double -> %f
		// 3:06수업시작~
		// boolean -> %b  %B
		// 형식 :  %[argument_index$][flags][width][.precision]conversion
		// 형식 :  %conversion
		
		System.out.printf("성별 : %b\n", gender);
		System.out.printf("성별 : %B\n", gender);
		
		String id = "kenik";
		System.out.printf("아이디 : %s\n", id);
		System.out.printf("아이디 : %S\n", id);
	} // main

} // class




