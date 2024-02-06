package days07;

public class Ex04_02 {

	public static void main(String[] args) {
		// [ 구구단 세로 출력 ] 
		// [순서도] -> 코딩
		
		// 2*1  3*1  4*1 5*1  ~ 9*1
		
		// i= 행   1
		// j= 열    2,3,4,5,6,7,8,9  단
		//       :
		// i= 행   9
		// j= 열    2,3,4,5,6,7,8,9  단
		
		for (int i = 1; i <=9 ; i++) {          // 행 
			for (int j = 2; j <= 9 ; j++) {      // 열(단)
				// 커서의 위치를 설정해서 
				System.out.printf("%d*%d=%02d\t", j, i, i*j);
			} // for j
			System.out.println();
		} // for i
		

	} // main

} // class
