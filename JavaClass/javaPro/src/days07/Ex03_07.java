package days07;

public class Ex03_07 {

	public static void main(String[] args) {
		// [마름모]
		// __*
		// _***
		// *****
		// _***
		// __*
		
		/*
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= 3-i; j++) {
				System.out.print("_");
			}
			for (int j = 1; j <= 2*i-1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		*/
		
		/*
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= (i>3 ? i-3 : 3-i); j++) {
				System.out.print("_");
			}
			for (int j = 1; j <= (i>3 ? (6-i)*2-1 : 2*i-1); j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		*/
		
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= 5; j++) {
				if (i+j>=4 && j-i<=2 && i-j<=2 && i+j<=8) {
					System.out.print("*");
				} else {
					System.out.print("_");
				}
			}
			System.out.println();
		}
		
	}//main

}//class
