package days07;

public class Ex03_08 {

	public static void main(String[] args) {
		// *
		// _*
		// __*
		// ___*
		// ____*
		/*
		for (int i = 1; i <= 5; i++) {
			// 
			for (int j = 1; j <= i - 1; j++) {
				System.out.print("_");
			}
			//
			System.out.print("*");
			System.out.println();
		} // for i
		*/
		
		// ____*
		// ___*
		// __*
		// _*
		// *
		
		/*
		for (int i = 1; i <= 5; i++) {
			// 
			for (int j = 1; j <= 5- i; j++) {
				System.out.print("_");
			}
			//
			System.out.print("*");
			System.out.println();
		} // for i
		*/
		

		// *___*
		// _*_*
		// __*
		// _*_*
		// *___*
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= 5; j++) {
				if ( i == j  ||  i + j == 6) {
					System.out.print("*");
				} else {
					System.out.print("_");
				}
			} // for j
			System.out.println();
		} //  for i 
		
	} // main 

} // class 
