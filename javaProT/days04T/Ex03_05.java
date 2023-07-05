package days04;

/**
 * @author kenik
 * @date  2023. 1. 31. - 오후 12:21:38
 * @subject  삼항 연산자 == 조건연산자                  항1 ? 항2 : 항3
 * @content 
 *
 */
public class Ex03_05 {

	public static void main(String[] args) {
		// 삼항연산자 = 항의 갯수 3개    1개
		// 조건연산자(기능)
		// 선언형식 :                      항1 ? 항2 : 항3
		//                                  x > 5 ? x     : x + 100
		//                                    참            항2 x
		//                                   거짓            항3   x + 100
		int x = 3, y ;
		
		y =  x > 5 ? x : x + 100 ;
		// y =   x + 100 ;
		
		System.out.println(  y  );  // 103
		

	} // main

} // class







