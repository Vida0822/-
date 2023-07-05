package days07;

public class Ex03_04 {

	public static void main(String[] args) {
		// ___* i=1       공j=3 ___     별j=1 *
		// __** i=2       공j=2__             2**
		// _*** i=3       공j=1                   3  
		// **** i=4       공j=0                 4
		//            i+공j = 4                    i=별j
		//            공j= 4-i
		
		for (int i = 1; i <= 4; i++) {          // 행 갯수
			for (int j = 1; j <= 4 ; j++) { 
				if (  i + j >= 5   ) {
					System.out.print("*");
				} else {
					System.out.print("_");
				}
			}// for j
			System.out.println();
		}// for i
		
		/*
		for (int i = 1; i <=4; i++) {  // 행 갯수
			
			// 공백 찍는 for
			for (int j = 1; j <= 4-i; j++) {
				System.out.print("_");
			}
			// 별 찍는 for
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			
			System.out.println();
			
		} // for i
		*/

	} // main

} // class
