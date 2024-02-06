package days06;

/**
 * @author dlsgu
 * @date 2023. 2. 2. - 오후 4:56:36
 * @subject 
 * @content 
 *
 */
public class Ex06 {

	public static void main(String[] args) {
        // 1번 문제
		// *
		// **
		// ***
		// ****
		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
		
		// 2번 문제
		// ****
		// ***
		// **
		// *
		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <= (5-i); j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
		
		// 3번 문제
		// ___*
		// __**
		// _***
		// ****
		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <= 4; j++) {
				if (j < (5-i)) {
					System.out.print(" ");
				} else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
		System.out.println();

		// 4번 문제
		// ****
		// _***
		// __**
		// ___*
		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <= 4; j++) {
				if (j < i) {
					System.out.print(" ");
				} else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
		System.out.println();

		// 5번 문제 ( 이등변 삼각형 )
		// __*
		// _***
		// *****


		// 6번 문제( 마름모 )
		// __*
		// _***
		// *****
		// _***
		// __*

		// 7번 문제  Ex05_07.java
		// *
		// _*
		// __*
		// ___*
		// ____*

		// 8번 문제  Ex05_08.java
		// ____*
		// ___*
		// __*
		// _*
		// *

		// 9번 문제  Ex05_09.java
		// *___*
		// _*_*
		// __*
		// _*_*
		// *___*


	}//main

}//class
