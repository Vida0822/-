package days04;

/**
 * @author dlsgu
 * @date 2023. 1. 31. 오후 12:42:21
 * @subject 소문자 -> 대문자 변경해서 출력
 * @content
 */
public class Ex04_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 소문자 lowerCase
		// 대문자 upperCase
		
		char lowerCase = 'x';
		char upperCase;
		// 소문자 - 32 = 대문자
		// 에러: Type mismatch: cannot convert from int to char -> 좌측 char(작) = 우측 int(큰)
		upperCase = (char) (lowerCase - 32); 
		// 대문자 + 32 = 소문자
		System.out.println(upperCase);

	}///main

}//class
