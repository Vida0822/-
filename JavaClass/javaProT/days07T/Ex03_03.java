package days07;

public class Ex03_03 {

	public static void main(String[] args) {
		// ****   i=1    j=4
		// ***     i=2   j=3
		// **       i=3   j=2
		// *         i=4   j=1
		//            i+j=5
		//            j=5-i
		
		for (int i = 1; i <= 4; i++) {          // 행 갯수
			for (int j = 1; j <= 4 ; j++) { 
				if (  i + j <= 5   ) {
					System.out.print("*");
				} else {
					System.out.print("_");
				}
			}// for j
			System.out.println();
		}// for i
		
		// 반복문은 반복 규칙을 어떻게 쉽게 파악....(중요)
		/*
		for (int i = 1; i <=4; i++) {  // 행 갯수
			
			for (int j = 1; j <=5-i ; j++) {  // 열(별) 갯수
			// for (int j = 5; j > i ; j--) {  // 열(별) 갯수
				System.out.print("*");
			}
			System.out.println();
			
		} // for i
		*/

	} // main

} // class
