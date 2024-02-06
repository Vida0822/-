package days09;

import java.util.Random;

/**
 * @author kenik
 * @date  2023. 2. 7. - 오후 3:39:11
 * @subject 
 * @content 
 *
 */
public class Ex04 {

	public static void main(String[] args) {
		// 신용카드 
		//                        1        [2]         3      4              랜덤하게 1~4 정수를 발생.
		String card ="7655-8988-9234-5677";
		//              -  String []  구분자로 car 문자열를 잘라내기(split)
		//                  [1]="****"
		//                배열의 문자열을 다시 조립(결합) 해서 출력.
		
		// 3:50 + 10쉬는 시간  + 5분 
		// 4:06 수업 시작~  .Ex04_02.java
		String [] cards = card.split("-");
		
		for (int i = 0; i < cards.length; i++) {
			System.out.printf("cards[%d]=%s\n", i, cards[i]);
		} // 
		
		Random rnd = new Random();
		int index =  rnd.nextInt(4);  // 0,1,2,3  배열의 index
		cards[index ] = "****";
		/*
		for (int i = 0; i < cards.length; i++) {
			System.out.printf("cards[%d]=%s\n", i, cards[i]);
		} //
		*/
		
		/*
		card = String.format("%s-%s-%s-%s", cards[0], cards[1], cards[2],cards[3]);
		System.out.println( card );
		*/
		
		card =  String.join("-", cards);
		System.out.println(card );
		
		

		// 결재할 때 마다 랜덤하게 특정 위치 4자리 숫자가 **** 로 출력(표시)
		/*
		System.out.println("7655-****-9234-5677");
		System.out.println("7655-8988-9234-****");		
		System.out.println("****-8988-9234-5677");
		System.out.println("7655-8988-****-5677");
		*/
	} // main

} // class
