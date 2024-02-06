package days07;

public class Ex03_04 {

	public static void main(String[] args) {
		// ___*
		// __**
		// _***
		// ****
		/*
		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <= 4; j++) {
				if (j <= 4-i) {
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
			// 공백 찍는 for
			for (int j = 1; j <= 4-i; j++) {
					System.out.print(" ");
			}
			// 별 찍는 for
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}

			System.out.println();
		}
		*/
		
		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <= 4; j++) {
				if (i+j >= 5) {
					System.out.print("*");
				} else {
					System.out.print("_");
				}
			}
			System.out.println();
		}
		
	}

}
