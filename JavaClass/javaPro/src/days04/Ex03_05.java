package days04;

/**
 * @author dlsgu
 * @date 2023. 1. 31. 오후 12:21:32
 * @subject
 * @content
 */
public class Ex03_05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 삼항연산자 = 항의 갯수 3개
		// 조건연산자(기능)
		// 선언형식:	항1 ? 항2 : 항3
		//				참 -> 항2
		//				거짓 -> 항3
		int x = 3, y;
		
		y = x>5 ? x : x+100; // 거짓 -> x+100 -> 103
		
		System.out.println(y);

	}//main

}//class
