package days07;

public class Ex03_03 {

	public static void main(String[] args) {
		// ****
		// ***
		// **
		// *
		
		/*
		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <= 5-i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		*/
		
		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <= 4; j++) {
				if (i+j <= 5) {
					System.out.print("*");
				} else {
					System.out.print("_");
				}
			}
			System.out.println();
		}
		
	}//main

}//class
