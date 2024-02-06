package days04;

/**
 * @author dlsgu
 * @date 2023. 1. 31. 오후 12:47:23
 * @subject
 * @content
 */
public class Ex05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double pi = 3.141592;
		// 소수점 3자리부터 잘라내기 == 소수점 2자리까지 출력
		// System.out.printf("%.2f", pi);
		
		pi = (int)(pi*100)/100d; // 3.0 -> d -> 3.14
		System.out.println(pi); // 값 변형 및 절삭
		
		System.out.printf("%.2f", pi); // 반올림 및 값은 유지
		
		/*
		pi = pi*100;
		System.out.println(pi); // 314.1592
		pi = (int)pi;
		System.out.println(pi); // 314.0
		pi = pi/100;
		System.out.println(pi); // 3.14
		*/

	}//main

}//class
