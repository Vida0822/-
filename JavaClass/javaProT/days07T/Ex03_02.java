package days07;

public class Ex03_02 {

	public static void main(String[] args) {
		 // *
		 // **
		 // ***
		 // ****		
		
		/*
		 * i=1                  j=1                    2<=4 거짓          **** 개행
		 * i=2                 j=1,2                 3<=4 거짓          **** 개행
		 * i=3                  j=1,2,3             4<=4 거짓          **** 개행
		 * i=4                  j=1,2,3,4           5<=4 거짓          **** 개행
		 * i=5   5<=4(거짓)
		 * */
 
		/*
		for (int i = 1; i <= 4; i++) {          // 행 갯수
			for (int j = 1; j <= i; j++) {      // 열(별) 갯수
				System.out.print("*");
			} // for j
			System.out.println(); // 개행
		} // for i
		*/
		
		for (int i = 1; i <= 4; i++) {          // 행 갯수
			for (int j = 1; j <= 4 ; j++) { 
				if (  i >=  j    ) {
					System.out.print("*");
				} else {
					System.out.print("_");
				}
			}// for j
			System.out.println();
		}// for i
		

	} // main

} // class
