package days07;

public class Ex03_05 {

	public static void main(String[] args) {
		// 12:02 수업시작~
		// ****    i=1  공=0   별=4
		// _***   i=2  공=1     별=3
		// __**   i=3 공=2     별=2
		// ___*  i=4 공=3     별=1
		//          공 = i-1           i+j=5    j=5-i
		
		for (int i = 1; i <= 4; i++) {          // 행 갯수
			for (int j = 1; j <= 4 ; j++) { 
				if (  i  <=   j  ) {
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
			for (int j = 1; j <=  i-1 ; j++) {
				System.out.print("_");
			}
			// 별 찍는 for
			for (int j = 1; j <=5-i; j++) {
				System.out.print("*");
			}
			
			System.out.println();
			
		} // for i
		*/

	} // main

} // class
