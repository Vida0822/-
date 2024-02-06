package days07;

/**
 * @author kenik
 * @date 2023. 2. 3. - 오후 3:24:02
 * @subject
 * @content
 *
 */
public class Ex04_04 {

	public static void main(String[] args) {
		// [구구단 세로 출력]
		// 2단 3단 4단
		// 5단 6단 7단
		// 8단 9단
		
		/*
		for (int i = 1; i <=9 ; i++) {         
			for (int j = 2; j <= 4 ; j++) {      
				System.out.printf("%d*%d=%02d\t", j, i, i*j);
			} // for j
			System.out.println();
		} // for i
		System.out.println();
		
		for (int i = 1; i <=9 ; i++) {         
			for (int j = 5; j <= 7 ; j++) {      
				System.out.printf("%d*%d=%02d\t", j, i, i*j);
			} // for j
			System.out.println();
		} // for i
		System.out.println();
		
		for (int i = 1; i <=9 ; i++) {         
			for (int j = 8; j <= 9 ; j++) {      
				System.out.printf("%d*%d=%02d\t", j, i, i*j);
			} // for j
			System.out.println();
		} // for i
		System.out.println();
		*/

		// k=1            2   3   4
		// k=2            5   6  7
		// k=3            8
		//                   3*k - 1 
		
		// [문제점] 10단 출력 X       LG  (3문제)
		// *** 이름 붙은 반복문  : break 이름;  ***
		// *** 이름 붙은 반복문  : continue 이름;  ***
		loop1:
		for (int k = 1; k <= 3; k++) {
			loop2:
			for (int i = 1; i <=9 ; i++) {         
				for (int j = 3*k-1; j <= 3*k+1  && j <=9 ; j++) {      
					/*
					if( j == 10 ) {
						//System.out.println( "if j==10 break");
						// break loop1;
						// continue loop1;
						break;
					}
					*/
					System.out.printf("%d*%d=%02d\t", j, i, i*j);
				} // for j
				System.out.println();
			} // for i
			System.out.println();
		} // for k
	} // main

} // class














