package days09;

import java.util.Random;

/**
 * @author dlsgu
 * @date 2023. 2. 7. 오후 2:06:20
 * @subject 중복되지 않는 로또 번호 발생
 * @content
 */
public class Ex03_03 {

	public static void main(String[] args) {

		int [] lotto = new int[6];

		fillLotto(lotto);

		dispLotto(lotto); // Call By Reference
	}//main

	private static void fillLotto(int[] lotto) {

		Random rnd = new Random(); //Random 객체 생성
		int index = 0; // [0][][][][][]
		int n; // 임의의 정수 저장 변수

		n =  rnd.nextInt(45)+1;
		System.out.println(n);
		lotto[index++] = n;

		boolean flag = false;
		while (index <= 5) {
			flag = false;
			n =  rnd.nextInt(45)+1;
			for (int i = 0; i < index; i++) {
				if (lotto[i] == n) {
					System.out.print("중복 : ");
					flag = true; // 중복이 되는 것이 있으면 flag는 true로 설정
					break;
				}//if
			}//for i
			System.out.println( n );			
			if( !flag )   lotto[index++] = n;
		}//while

	}//fillLotto

	public static void dispLotto(int[] lotto) {
		// 배열명.length == 배열크기
		for (int i = 0; i < lotto.length; i++) {
			System.out.printf("[%d]", lotto[i]);
		}//for i
		System.out.println(); //개행
	}//dispLotto

}//class
