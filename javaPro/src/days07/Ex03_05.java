package days07;

public class Ex03_05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ****
		// _***
		// __**
		// ___*
		/*
		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <= 4; j++) {
				if (j < i) {
					System.out.print(" ");
				} else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
		*/
		
		/*
		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <= i-1; j++) {
				System.out.print("_");
			}
			for (int j = 1; j <= 5-i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		*/
		
		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <= 4; j++) {
				if (i<=j) {
					System.out.print("*");
				} else {
					System.out.print("_");
				}
			}
			System.out.println();
		}
		
	}//main

}//class
