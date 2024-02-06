package days07;

public class Ex03_07 {

	public static void main(String[] args) {
		//                                     k=3
		// __*     i=1   j=2            -1
		// _***   i=2   j=1             -1
		// *****  i=3  j=0            -1
		                // i+j=3
		               //	j=3-i                               2*i-1
		
		// _***   i=4  j=1              +1            (6-i )*2-1
		// __*    i=5  j=2              +1             1
		                //  i-j=3
		                //  j= i-3		  
		
	 
		for (int i = 1; i <= 5; i++) {          // 행 갯수
			for (int j = 1; j <= 5 ; j++) {  
				if (  i + j >= 4 && j-i <=2 && i-j <=2 && i+j<= 8  ) {
					System.out.print("*");
				} else {
					System.out.print("_");
				}
			}// for j
			System.out.println();
		}// for i
		 
		
		/*
        for (int i = 1; i <=5; i++) {  // 행 갯수
			
			// 공백 찍는 for
			for (int j = 1; j <=  ( i > 3 ? i-3: 3-i )  ; j++) {
				System.out.print("_");
			}			
			// 별 찍는 for 
			for (int j = 1; j <= ( i > 3 ? (6-i )*2-1 : 2*i-1 )   ; j++) {
				System.out.print("*");
			}			
			System.out.println();
			
		} // for i
		*/

	} // main

} // class
