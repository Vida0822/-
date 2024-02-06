package days02;

import java.io.PrintStream;

/**
 * @author kenik
 * @date  2023. 1. 27. - 오전 11:35:01
 * @subject   지역변수를 사용하는 예제 + 두 변수의 값을 교환하기. ( 시험 문제 )
 * @content +   덧셈연산자,  문자열 연결연산자. 
 *                      두 변수의 값을 교환할 때는 같은 자료형의 변수(임시)가 필요하다. 
 */
public class Ex01_04 {

	public static void main(String[] args) {
		// 1. 두 정수를 저장할 x,y 변수를 선언 +  10, 20 초기화
		/*
			int x = 10;
			int y ;
			y = 20;
		 */

		// , 나열 연산자
		int x = 10, y = 20;

		// 출력  
		// System.out.println(  1 + x );            // 1 숫자 +  x 숫자       + 덧셈연산자
		// "> x = 10 , y =  20"
		System.out.println( "> x = " + x +", y = " + y );  //  "문자열" + 숫자       "결과문자열"  문자열 연결연산자 
		{
			int temp;
			temp = x;
			x =  y;
			y = temp;
		}
		
		// System.out.println( "> x = " + x +", y = " + y );
		// 가변인자  ...
		// %d   conversion    int 정수 -> %d
		System.out.printf("> x = %d , y = %d\n", x, y);
		

		// 12:07 수업시작
		// 어떤 값을 내가 원하는 출력형식으로 출력하고 싶을 때 printf() 함수를 사용한다. 
		// 함수 3가지 : 기능, 매개변수, 리턴값
		// 1. 기능 : foramt 출력형식 + 출력함수
		// 2. 매개변수 
		//               (1) String format                "출력형식"
		//               (2) Object [] args                배열 X
		// 3. 리턴값  :  PrintStream 클래스 객체.
		// PrintStream System.out.printf(String format, Object [] args);
		// PrintStream System.out.printf(String format, Object... args);  X
		/*
String name = "홍길동";
int age =20;
Object [] orgs =  {
		name,
		new Integer( age )
};
System.out.printf("이름은 %s이고, 나이는 %d살입니다." , orgs );
		 */
		// 이름은 홍길동이고, 나이는 20살입니다.
		// System.out.printf("이름은 %s이고, 나이는 %d살입니다.", name, age);

	} // main

}  // class







