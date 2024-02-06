package days07;

public class Ex03_06 {

	public static void main(String[] args) {
		// [이등변 삼각형]
		// __*
		// _***
		// *****
		
		/*
		for (int i = 1; i <= 3; i++) {
			for (int j = 1; j <= 3-i; j++) {
				System.out.print("_");
			}
			for (int j = 1; j <= 2*i-1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		*/
		
		for (int i = 1; i <= 3; i++) {
			for (int j = 1; j <= 5; j++) {
				if (i+j>=4 && j-i<=2) {
					System.out.print("*");
				} else {
					System.out.print("_");
				}
			}
			System.out.println();
		}
		
	}//main

}//class
