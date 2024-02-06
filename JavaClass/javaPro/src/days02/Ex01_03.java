package days02;

/**
 * @author kenik
 * @date  2023. 1. 27. - 오전 11:20:47
 * @subject   local variable(  지역 변수  ) 란 ? ( 시험문제 )
 * @content   Ex01_04.java 예제
 *
 */
public class Ex01_03 {

	public static void main(String[] args) {
		// [변수 선언 형식 ]
		// 자료형 변수명[= 초기값];
		
		// ;
		// .
		// {} 범위(지역) 연산자
		int age = 20 ;
		// age = 20; // 초기화	
		{
			System.out.println( age ); 
		}
		//  age cannot be resolved to a variable ( 시험 문제 )
		// 나이       해결할수없다.                  변수로		
		
		System.out.println(" END ");

	} // main

} // class





