package days07;

public class Ex03_06 {

	public static void main(String[] args) {
		// [이등변삼각형]		
		// __*       i=1   j=2             j=1
		// _***     i=2   j=1             j=3
		// *****    i=3  j=0            j=5
		//             i+j=3
		//             j=3-i
		
		for (int i = 1; i <= 3; i++) {          // 행 갯수
			for (int j = 1; j <= 5 ; j++) { 
				//if (    i + j >= 4   ) {
				//if (   j - i <=2   ) {
				if (   j - i <=2  &&   i + j >= 4 ) {
					System.out.print("*");
				} else {
					System.out.print("_");
				}
			}// for j
			System.out.println();
		}// for i
		
		
		// i
		// 1-1
		// 2-3
		// 3-5
		//  고등학생:       2*i-1
		/*
        for (int i = 1; i <=3; i++) {  // 행 갯수
			
			// 공백 찍는 for
			for (int j = 1; j <=  3-i ; j++) {
				System.out.print("_");
			}
			// 별 찍는 for
			for (int j = 1; j <= 2*i-1; j++) {
				System.out.print("*");
			}
			
			System.out.println();
			
		} // for i
		*/
		
	} // main

} // class
