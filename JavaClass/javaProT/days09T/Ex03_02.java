package days09;

import java.util.Random;

/**
 * @author kenik
 * @date  2023. 2. 7. - 오후 2:05:39
 * @subject   중복되지 않는 로또 번호 발생.  ( 시험 3 )
 * @content 
 *
 */
public class Ex03_02 {

	public static void main(String[] args) {
		//int i ;  지역변수는 초기화를 해야 사용할 수 있다. 
		//System.out.println(i);
		
		// ( 암기 ) 
		// 배열은 초기화 하지 않아도 기본값으로 초기화 되어져 있다. 
		// int []  이기 때문에   int의 기본값인 0으로 초기화 되어져 있다.
		// [0][0][0][0][0][0]
		int [] lotto = new int[6];
		
		// lotto 배열에 로또번호를 임의의 정수를 발생시켜서 채워넣는 코딩.
		fillLotto(  lotto );

		// 배열 출력하는 함수 선언 -> 호출
		// 1) 기능 : 배열 출력   dispLotto()
		// 2) 매개변수 : 출력할 배열  int [] lotto
		// 3) 리턴값 : X  void 
		dispLotto(  lotto  );  // Call By Reference
	} // main

	public static void fillLotto(int[] lotto) {
		//                             index
		//                                      ↓
		//    0     1    2   3    4   5 
		//   [32][0][0][0][0][0]
		Random rnd = new Random();
		int index = 0; // 배열에 채워넣기 위한 위치값
		int n ; // 임의의 로또 번호
		
		n =  rnd.nextInt(45)+1;
		lotto[index++] = n;
		
		// n == lotto 다시 임의의 로또번호 발생.
		do {
			n =  rnd.nextInt(45)+1;
		} while ( lotto[0]  == n );
		lotto[index++] = n;
		
		
		do {
			n =  rnd.nextInt(45)+1;  // 22
		} while ( lotto[0]  == n  || lotto[1] == n );          // [23][22] [X]
		lotto[index++] = n;
		
		do {
			n =  rnd.nextInt(45)+1;
		} while ( lotto[0]  == n  || lotto[1] == n || lotto[2] == n );
		lotto[index++] = n; 

		do {
			n =  rnd.nextInt(45)+1;
		} while ( lotto[0]  == n  || lotto[1] == n || lotto[2] == n || lotto[3] == n);
		lotto[index++] = n;

		do {
			n =  rnd.nextInt(45)+1;
		} while ( lotto[0]  == n  || lotto[1] == n || lotto[2] == n || lotto[3] == n || lotto[4] ==n );
		lotto[index++] = n;
		/*
		// [32][21][45][0][0][0]
		Random rnd = new Random();
		
		int n =  rnd.nextInt(45)+1; // 32
		lotto[0] = n;
		
		n =  rnd.nextInt(45)+1; // 21
		// 중복체크 X
		lotto[1] = n;
		
		n =  rnd.nextInt(45)+1; // 45
		// 중복체크 X
		lotto[2] = n;
		
		n =  rnd.nextInt(45)+1; // 1 ~ 45
		// 중복체크 X
		lotto[3] = n;
		
		n =  rnd.nextInt(45)+1; // 1 ~ 45
		// 중복체크 X
		lotto[4] = n;
		
		n =  rnd.nextInt(45)+1; // 1 ~ 45
		// 중복체크 X
		lotto[5] = n;
		*/
		
		
		 
	}  // fillLotto

	public  static void dispLotto(int[] lotto) {
		// 배열명.length == 배열크기
		for (int i = 0; i < lotto.length; i++) {
			 System.out.printf("[%d]", lotto[i]);
		} // for i
		System.out.println(); // 개행
	}  // dispLotto

} // class


		